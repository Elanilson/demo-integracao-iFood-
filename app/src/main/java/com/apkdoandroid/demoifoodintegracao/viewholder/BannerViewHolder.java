package com.apkdoandroid.demoifoodintegracao.viewholder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.demoifoodintegracao.R;
import com.bumptech.glide.Glide;

public class BannerViewHolder extends RecyclerView.ViewHolder {
    private ImageView imagem;
    public BannerViewHolder(@NonNull View itemView) {
        super(itemView);
        imagem = itemView.findViewById(R.id.imageViewBanner);
    }

    public void bind(String url){

        Glide.with(itemView.getContext()).load(url).into(imagem);


    }
}
