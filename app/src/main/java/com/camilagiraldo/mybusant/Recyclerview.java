package com.camilagiraldo.mybusant;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.camilagiraldo.mybusant.Objetos.Adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Recyclerview extends DrawerActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private RecyclerView recyclerView;
    String holi;
    ArrayList<String> productos;
    int cont=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_recyclerview);
        FrameLayout framecontenedor = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_recyclerview, framecontenedor);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Viajes");
        productos = new ArrayList<String>();
        final Adapter adapter = new Adapter(getApplicationContext(), productos);
        recyclerView.setAdapter(adapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                /*for (DataSnapshot alert: dataSnapshot.getChildren()) {
                    System.out.println(alert.getValue());
                }*/
                // This method is called once with the initial value and again
             /*   // whenever data at this location is updated.
                holi = (String) dataSnapshot.getValue();

                productos.add(holi);
                adapter.notifyDataSetChanged();*/

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read value." + error.toException());
            }
        });
    }




}
