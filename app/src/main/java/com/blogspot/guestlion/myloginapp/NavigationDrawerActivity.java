package com.blogspot.guestlion.myloginapp;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class NavigationDrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }



        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle item selection
            switch (item.getItemId()) {
                case R.id.build:
                    showBuild();
                    return true;

                case R.id.face:
                    showface();
                    return true;

                case R.id.fingerprint:
                    showFingerPrint();
                    return true;

                case R.id.share:
                    showShare();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }


    public void showBuild(){
        Intent intent = new Intent(NavigationDrawerActivity.this, BuildMenu.class);
        startActivity(intent);
    }

    public void showface(){
        Intent intent = new Intent(NavigationDrawerActivity.this, FaceMenu.class);
        startActivity(intent);
    }

    public void showFingerPrint(){
        Intent intent = new Intent(NavigationDrawerActivity.this, FingerprintMenu.class);
        startActivity(intent);
    }

    public void showShare(){
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String sAux = "\nLet me recommend you this application\n\n";
            sAux = sAux + "https://play.google.com/store/apps/ \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }
}
