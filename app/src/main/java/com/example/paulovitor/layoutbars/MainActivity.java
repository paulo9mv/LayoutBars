package com.example.paulovitor.layoutbars;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.SearchView;

import java.util.Timer;

public class MainActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Barra");

        //Uso de Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Adiciona tabs
        actionBar.addTab(actionBar.newTab().setText("Tab 1").setTabListener(new MyTabListener(this, 1)));
        actionBar.addTab(actionBar.newTab().setText("Tab 2").setTabListener(new MyTabListener(this, 2)));
        actionBar.addTab(actionBar.newTab().setText("Tab 3").setTabListener(new MyTabListener(this, 3)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Infla o menu com o que está no XML
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(onSearch());

        MenuItem itemShare = menu.findItem(R.id.action_share);
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(itemShare);

        shareActionProvider.setShareIntent(getDefaultIntent());

        return true;
    }

    private Intent getDefaultIntent(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Text to share");

        return intent;
    }

    private SearchView.OnQueryTextListener onSearch(){
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "Submetido", Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, "Mudado!", Toast.LENGTH_SHORT).show();

                return false;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_search){
            toast("Search!");
        }
        else if(id == R.id.action_refresh){
            toast("Refresh!");
        }
        else if(id == R.id.action_settings){
            toast("Settings!");
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
