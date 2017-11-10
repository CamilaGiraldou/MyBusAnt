package com.camilagiraldo.mybusant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OriDesActivity extends DrawerActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button seguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ori_des);
        FrameLayout framecontenedor = (FrameLayout)findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_ori_des,framecontenedor);
        seguiente = (Button) findViewById(R.id.salt);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Myref = database.getReference();
    }

    public void pasar(View view) {
        Intent intent = new Intent(OriDesActivity.this, BuscarActivity.class);

        startActivity(intent);

    }
}
