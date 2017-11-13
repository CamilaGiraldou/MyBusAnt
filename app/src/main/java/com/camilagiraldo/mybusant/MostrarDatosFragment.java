package com.camilagiraldo.mybusant;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camilagiraldo.mybusant.Objetos.Adapter;
import com.camilagiraldo.mybusant.Objetos.Viajes;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MostrarDatosFragment extends Fragment {


    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    public static ArrayList<Viajes> items;

    String nomb = "";

    public MostrarDatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_mostrar_datos, container, false);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        items = new ArrayList<Viajes>();

        database.getReference("Viaje").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {

                    Viajes viaje = dataSnapshot.getValue(Viajes.class);

                    nomb = viaje.getOrigen_Destino();


                    items.add(viaje);

                    adapter.notifyItemInserted(items.size() - 1);
                    //adapter.notifyDataSetChanged();
                    //adapter.notifyItemInserted(items.size() - 1);


                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String key = dataSnapshot.getKey();
                Viajes parqueadero = dataSnapshot.getValue(Viajes.class);
                for (Viajes cl : items
                        ) {
                    if (cl.getOrigen_Destino().equals(key)) {
                        cl.setEmpresa(parqueadero.getEmpresa());
                        cl.setHorarios(parqueadero.getHorarios());
                        //cl.setCedula(parqueadero.getCedula());
                        break;

                    }

                }

                adapter.notifyDataSetChanged();
                /*
                items.add(parqueadero);
                adapter.notifyItemInserted(items.size() - 1);
                //adapter.notifyItemChanged(Integer.parseInt(parqueadero.getCedula()));
                adapter.notifyDataSetChanged();*/

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
        recycler = (RecyclerView) view.findViewById(R.id.recicladorProductos);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this.getContext());
        recycler.setLayoutManager(lManager);


        // Crear un nuevo adaptador

        adapter = new Adapter(items, this.getContext());
        recycler.setAdapter(adapter);

        recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i= v.getId();
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });





        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_mostrar, container, false);

        return view;
    }
}
