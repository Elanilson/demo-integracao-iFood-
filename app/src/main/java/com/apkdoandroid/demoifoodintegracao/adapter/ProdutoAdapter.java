package com.apkdoandroid.demoifoodintegracao.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.listener.ListernesProduto;
import com.apkdoandroid.demoifoodintegracao.model.Produto;
import com.apkdoandroid.demoifoodintegracao.viewholder.ProdutoViewHolder;
import com.apkdoandroid.demoifoodintegracao.viewholder.ProdutoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoViewHolder> {
    private List<Produto> produtos = new ArrayList<>();
    private ListernesProduto listener;


    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_produto,parent ,false);

        return new ProdutoViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        holder.bind(produtos.get(position),listener);

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public void attackProdutos(List<Produto> produtos ){
        this.produtos = produtos;
        notifyDataSetChanged();
    }
    public void attackListener(ListernesProduto listener){
        this.listener = listener;
    }
}
