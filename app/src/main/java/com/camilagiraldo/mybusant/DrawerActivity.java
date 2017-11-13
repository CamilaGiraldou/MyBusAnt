package com.camilagiraldo.mybusant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,GoogleApiClient.OnConnectionFailedListener  {
    GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = null;

        Fragment fragmento = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.frame,fragmento).commit();
        if (id == R.id.nav_camera) {

            intent = new Intent(getApplicationContext(),PerfilActivity.class);
            startActivity(intent);
            finish();


        } else if (id == R.id.nav_gallery) {
            /*intent = new Intent(getApplicationContext(),OriDesActivity
                    .class);
            startActivity(intent);
            finish();
*/


            fragmento = new MostrarDatosFragment();

            fragmentManager.beginTransaction().replace(R.id.frame,fragmento).commit();

            //Toast.makeText(getApplicationContext(),"Bien", Toast.LENGTH_SHORT).show();
            /*intent = new Intent(getApplicationContext(),RecyclerView.class);
            startActivity(intent);
            finish();
*/

        } else /*if (id == R.id.nav_slideshow){
            intent = new Intent(getApplicationContext(),MapasActivity.class);
            startActivity(intent);
            finish();
        } else */if (id == R.id.nav_tabs) {

            intent = new Intent(getApplicationContext(),MapasActivity.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_buttom) {
            intent = new Intent(getApplicationContext(),BottomActivity.class);
            startActivity(intent);
            finish();


        } else if (id == R.id.nav_manage) {
            LoginManager.getInstance().logOut();
            Auth.GoogleSignInApi.signOut(googleApiClient);
            FirebaseAuth.getInstance().signOut();
            intent = new Intent(this,LogginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
