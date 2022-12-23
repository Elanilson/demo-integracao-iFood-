package com.apkdoandroid.demoifoodintegracao.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.demoifoodintegracao.R;
import com.bumptech.glide.Glide;

public class LojaViewHolder extends RecyclerView.ViewHolder {
    private ImageView imagem;
    private TextView textView;
    private String [] nomes = new String[]{"Comidas Brasileiras","Restaurante do Chef","Bergs","Kit ovo"};
    private int contador = 0;
    public LojaViewHolder(@NonNull View itemView) {
        super(itemView);
        imagem = itemView.findViewById(R.id.imageViewLoja);
        textView = itemView.findViewById(R.id.textViewLojaNome);
    }

    public void bind(String url,int posicao){

        contador++;
        Glide.with(itemView.getContext()).load(url).into(imagem);
        textView.setText(nomes[posicao]);


    }
}
