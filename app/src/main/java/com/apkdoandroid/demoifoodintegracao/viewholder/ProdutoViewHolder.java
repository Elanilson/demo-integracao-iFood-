package com.apkdoandroid.demoifoodintegracao.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.listener.ListernesProduto;
import com.apkdoandroid.demoifoodintegracao.model.Produto;

public class ProdutoViewHolder extends RecyclerView.ViewHolder {
    private ImageView imagem, imagemMaisVendido;
    private TextView titulo,preco;
    private Button btnCarrinho;

    public ProdutoViewHolder(@NonNull View itemView) {
        super(itemView);

        imagem = itemView.findViewById(R.id.imageViewProduto);
        imagemMaisVendido = itemView.findViewById(R.id.imageViewMaisVendido);
        titulo = itemView.findViewById(R.id.textViewTituloProduto);
        preco = itemView.findViewById(R.id.textView6PrecoProduto);
        btnCarrinho = itemView.findViewById(R.id.buttonCarrinhoProduto);
    }

    public  void bind(Produto produto, ListernesProduto listener  ){
        imagem.setImageResource(produto.getImagem());
        titulo.setText(produto.getTitulo());
        preco.setText("R$: "+produto.getPreco());


        if(produto.getMaisVendido() == 1){
            imagemMaisVendido.setVisibility(View.VISIBLE);
        }else{
            imagemMaisVendido.setVisibility(View.GONE);
        }

        btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(produto,v);
            }
        });
    }
}
