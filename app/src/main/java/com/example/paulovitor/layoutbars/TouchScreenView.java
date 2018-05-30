package com.example.paulovitor.layoutbars;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class TouchScreenView extends View {

    private static final String TAG = "Livro";
    private Drawable img;
    int x, y;
    private boolean selecionou;
    private int larguraTela;
    private int alturaTela;
    private int larguraImg;
    private int alturaImg;

    private int cor = Color.RED;
    private Rect colisionBox;
    private Rect exitBox;

    private boolean exitDoor = false;
    public boolean quit = false;
    private Context context;

    public TouchScreenView(Context context) {
        super(context, null);
        this.context = context;

        //Imagem em si
        img = context.getResources().getDrawable(R.drawable.android);

        //Altura e largura da imagem
        larguraImg = img.getIntrinsicWidth();
        alturaImg = img.getIntrinsicHeight();

        //Esta view tratara eventos de teclado
        setFocusable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        Log.i(TAG, "onTouchEvent: x/y > " + x + "/" + y);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //Se clicou na imagem, selecionou = verdadeira
                selecionou = img.copyBounds().contains((int)x,(int) y);
                break;
            case MotionEvent.ACTION_MOVE:
                //Move o boneco
                if(selecionou){
                    this.x = (int) x - (larguraImg / 2);
                    this.y = (int) y - (alturaImg / 2);
                    if(colisionBox.contains(this.x, this.y)){
                        cor = Color.BLACK;
                        Log.i(TAG,"Colidiu");
                        exitDoor = true;
                    }
                    else {
                        cor = Color.RED;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                //Finaliza o movimento
                selecionou = false;
                break;
        }

        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        this.larguraTela = w;
        this.alturaTela = h;

        colisionBox = new Rect(0, 0, this.larguraTela, 300);
        exitBox = new Rect(0, this.alturaTela - 300, this.larguraTela, this.alturaTela);

        this.x = w / 2 - (larguraImg/2);
        this.y = h / 2 - (alturaImg/2);

        Log.i(TAG, "onSizeChanged x/y: " + x + "/" + y);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //fundo branco
        Paint pincel = new Paint();
        pincel.setColor(Color.GREEN);

        //Desenha o fundo branco
        canvas.drawRect(0, 0, larguraTela, alturaTela, pincel);

        pincel.setColor(cor);
        canvas.drawRect(colisionBox, pincel);

        pincel.setColor(Color.WHITE);
        pincel.setTextSize(50);
        if(!exitDoor)
            canvas.drawText("Arraste aqui para retornar ao início",40, 100, pincel);
        else{
            pincel.setColor(Color.YELLOW);
            canvas.drawRect(exitBox, pincel);
            canvas.drawText("Para confirmar, arraste aqui.", 40, alturaTela - 350, pincel);
        }

        //Seta onde desenhar a imagem e desenha
        img.setBounds(x, y, x + larguraImg, y + alturaImg);
        img.draw(canvas);

        if(exitBox.contains(this.x, this.y)){
            Intent intent = new Intent((Activity)context, MainActivity.class);
            ((Activity)context).startActivity(intent);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            this.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}
