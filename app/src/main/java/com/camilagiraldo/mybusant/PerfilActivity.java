package com.camilagiraldo.mybusant;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PerfilActivity extends DrawerActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView nameTextView;
    private TextView emailTextView;
    private TextView uidTextView;
   private ImageView iFoto_perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_perfil);
        FrameLayout framecontenedor = (FrameLayout)findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_perfil,framecontenedor);
        iFoto_perfil = (ImageView) findViewById(R.id.iFoto_perfil);
        nameTextView = (TextView) findViewById(R.id.tNombre);
        emailTextView = (TextView) findViewById(R.id.tCorreo);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();
            String photoUrl = user.getPhotoUrl().toString();
            String uid = user.getUid();
            Glide.with(this).load(photoUrl).into(iFoto_perfil);
            nameTextView.setText(name);
            emailTextView.setText(email);

        } else {

        }
    }
}
