package com.apkdoandroid.demoifoodintegracao.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.model.Destaque;
import com.apkdoandroid.demoifoodintegracao.viewholder.BannerViewHolder;
import com.apkdoandroid.demoifoodintegracao.viewholder.DestaqueViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DestaqueAdapter extends RecyclerView.Adapter<DestaqueViewHolder> {
    private List<Destaque> lista= new ArrayList<>();

    @NonNull
    @Override
    public DestaqueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_destaque,parent ,false);

        return new DestaqueViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull DestaqueViewHolder holder, int position) {
        holder.bind(lista.get(position));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void attackListar(List<Destaque> lista){
        this.lista= lista;
        notifyDataSetChanged();
    }
}
