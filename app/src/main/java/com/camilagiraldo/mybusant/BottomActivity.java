package com.camilagiraldo.mybusant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class BottomActivity extends DrawerActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Empresa1Fragment Empresa1 = new Empresa1Fragment();
                    fragmentTransaction.replace(R.id.content,Empresa1).commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Empresa2Fragment Empresa2 = new Empresa2Fragment();
                    fragmentTransaction.replace(R.id.content,Empresa2).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_bottom);
        FrameLayout framebottom = (FrameLayout)findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_bottom,framebottom);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Empresa1Fragment fragmentdefault = new Empresa1Fragment();
        fragmentTransaction.add(R.id.content,fragmentdefault).commit();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
