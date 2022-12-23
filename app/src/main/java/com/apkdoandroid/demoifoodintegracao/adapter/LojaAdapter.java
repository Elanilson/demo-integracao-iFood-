package com.apkdoandroid.demoifoodintegracao.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.viewholder.LojaViewHolder;

import java.util.ArrayList;
import java.util.List;

public class LojaAdapter extends RecyclerView.Adapter<LojaViewHolder> {
    private List<String> lista = new ArrayList<>();

    @NonNull
    @Override
    public LojaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_lojas,parent ,false);

        return new LojaViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull LojaViewHolder holder, int position) {
        holder.bind(lista.get(position),position);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void attackLista(List<String> lista){
        this.lista = lista;
        notifyDataSetChanged();
    }
}
