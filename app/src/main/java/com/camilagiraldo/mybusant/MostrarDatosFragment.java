package com.camilagiraldo.mybusant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

public class MostrarDatosFragment extends Fragment {

   /* private  Recyclerview recycler;
    private  Recyclerview.Adapter adapter;
    private  Recyclerview.LayoutManager lManager;*/

    public MostrarDatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflated = inflater.inflate(R.layout.fragment_mostrar_datos, container, false);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        database.getReference("Viajes").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //recycler = (RecyclerView) inflated.findViewById(R.id.recicladordatos);

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mostrar_datos, container, false);

        return inflated;




    }
}
