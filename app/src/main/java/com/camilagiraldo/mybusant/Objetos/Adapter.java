package com.camilagiraldo.mybusant.Objetos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.camilagiraldo.mybusant.R;

import java.util.ArrayList;

/**
 * Created by USER on 07/11/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<String> values;
    public Adapter(Context applicationContext, ArrayList<String> values) {
        this.values = values;
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.name.setText(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.list_item_text);
        }
    }
}
