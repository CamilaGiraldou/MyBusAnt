package com.camilagiraldo.mybusant.Objetos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.camilagiraldo.mybusant.R;

import java.util.ArrayList;

/**
 * Created by USER on 07/11/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Viajes> items;
    Context ctx;

    public Adapter(ArrayList<Viajes> items, Context ctx) {

        this.items = items;
        this.ctx = ctx;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_client, viewGroup, false);
        ViewHolder productosViewHolder = new ViewHolder(v,ctx,items);
        return productosViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText("Ruta:"+String.valueOf(items.get(i).getOrigen_Destino()));
        viewHolder.visitas.setText("Precio:"+String.valueOf(items.get(i).getEmpresa()));
        viewHolder.estado.setText("Fecha:"+String.valueOf(items.get(i).getHorarios()));

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Campos respectivos de un item
        //public ImageView imagen;
        public TextView nombre;
        public TextView visitas;
        public TextView estado;

        ArrayList<Viajes> items = new ArrayList<Viajes>();
        Context ctx;

        public ViewHolder(View v, Context ctx, ArrayList<Viajes> items) {
            super(v);
            this.items = items;
            this.ctx = ctx;
            v.setOnClickListener(this);
            //imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.cardnombre);
            visitas = (TextView) v.findViewById(R.id.cardcedula);
            estado = (TextView) v.findViewById(R.id.cardfecha);

        }


        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),"funciona putita",Toast.LENGTH_SHORT).show();
        }
    }

}
