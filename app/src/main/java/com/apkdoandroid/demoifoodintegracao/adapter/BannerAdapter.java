package com.apkdoandroid.demoifoodintegracao.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.viewholder.BannerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {
    private List<String> lista_banner = new ArrayList<>();

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_banner,parent ,false);

        return new BannerViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.bind(lista_banner.get(position));

    }

    @Override
    public int getItemCount() {
        return lista_banner.size();
    }

    public void attackListaBanner(List<String> lista_banner){
        this.lista_banner = lista_banner;
        notifyDataSetChanged();
    }
}
