package com.apkdoandroid.demoifoodintegracao.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.model.Destaque;
import com.bumptech.glide.Glide;

public class DestaqueViewHolder extends RecyclerView.ViewHolder {
    private ImageView imagem;
    private TextView textView;
    public DestaqueViewHolder(@NonNull View itemView) {
        super(itemView);
        imagem = itemView.findViewById(R.id.imageViewDestaque);
        textView = itemView.findViewById(R.id.textViewTitulo);
    }

    public void bind(Destaque destaque){

        Glide.with(itemView.getContext()).load(destaque.getUrlImagem()).into(imagem);
        textView.setText(destaque.getTitulo());


    }
}
