package com.apkdoandroid.demoifoodintegracao.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.adapter.ProdutoAdapter;
import com.apkdoandroid.demoifoodintegracao.databinding.FragmentProdutosBinding;
import com.apkdoandroid.demoifoodintegracao.listener.ListernesProduto;
import com.apkdoandroid.demoifoodintegracao.model.Produto;
import com.apkdoandroid.demoifoodintegracao.viewmodel.ProdutosViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;


public class ProdutosFragment extends Fragment {
    private FragmentProdutosBinding binding;
    private ProdutoAdapter bebidaAdapter = new ProdutoAdapter();
    private ProdutoAdapter hortAdapter = new ProdutoAdapter();
    private ProdutoAdapter alimentosBasicosAdapter ;
    private ProdutoAdapter produtoMaisVendidoAdapter = new ProdutoAdapter();
    private ProdutosViewModel viewModel;
    private int qtd =1; // quantidade



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProdutosBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(ProdutosViewModel.class);

        binding.toolbarproduto.toolbar.setTitle("Delivery");
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarproduto.toolbar);

        viewModel.carregarMaisVendidos();
        viewModel.carregarAlimentosBasicos();
        viewModel.carregarHort();
        viewModel.carregarBebidas();
        observe();
        configurarRecycleviewMaisVendido();
        configurarRecycleviewAlimentosBasicos();
        configurarRecycleviewHort();
        configurarRecycleviewBebida();


        ListernesProduto listernesProduto = new ListernesProduto() {
            @Override
            public void onClick(Produto produto, View view) {
                adddCarrinhoSheetCustom(produto);
            }
        };


        produtoMaisVendidoAdapter.attackListener(listernesProduto);
        alimentosBasicosAdapter.attackListener(listernesProduto);
        hortAdapter.attackListener(listernesProduto);
        bebidaAdapter.attackListener(listernesProduto);



        return  binding.getRoot();
    }

    public void configurarRecycleviewMaisVendido(){


        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        //  GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        binding.recyclerviewMaisVentidos.setLayoutManager(manager);
        binding.recyclerviewMaisVentidos.setLayoutManager(manager);
        binding.recyclerviewMaisVentidos.setHasFixedSize(true);
        binding.recyclerviewMaisVentidos.setAdapter(produtoMaisVendidoAdapter);
    }

    public void configurarRecycleviewHort(){


        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        //  GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        binding.recyclerviewHortfrut.setLayoutManager(manager);
        binding.recyclerviewHortfrut.setLayoutManager(manager);
        binding.recyclerviewHortfrut.setHasFixedSize(true);
        binding.recyclerviewHortfrut.setAdapter(hortAdapter);
    }

    public void configurarRecycleviewAlimentosBasicos(){
        alimentosBasicosAdapter = new ProdutoAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        //  GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        binding.recyclerviewAlimentosBasico.setLayoutManager(manager);
        binding.recyclerviewAlimentosBasico.setLayoutManager(manager);
        binding.recyclerviewAlimentosBasico.setHasFixedSize(true);
        binding.recyclerviewAlimentosBasico.setAdapter(alimentosBasicosAdapter);
    }
    public void configurarRecycleviewBebida(){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        //  GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        binding.recyclerviewBebida.setLayoutManager(manager);
        binding.recyclerviewBebida.setLayoutManager(manager);
        binding.recyclerviewBebida.setHasFixedSize(true);
        binding.recyclerviewBebida.setAdapter(bebidaAdapter);
    }

    private void observe() {
        viewModel.bebida.observe(getViewLifecycleOwner(), new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                bebidaAdapter.attackProdutos(produtos);
            }
        });
        viewModel.hort.observe(getViewLifecycleOwner(), new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                hortAdapter.attackProdutos(produtos);
            }
        });
        viewModel.alimentosBasico.observe(getViewLifecycleOwner(), new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                alimentosBasicosAdapter.attackProdutos(produtos);
            }
        });

        viewModel.produtosMaisVendidos.observe(getViewLifecycleOwner(), new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                produtoMaisVendidoAdapter.attackProdutos(produtos);
            }
        });
    }

    public void adddCarrinhoSheetCustom(Produto produto){


        BottomSheetDialog sheetDialog = new BottomSheetDialog(getActivity(),R.style.BottomSheetDialogTheme);

        View view = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_carrinho_custom,(LinearLayout)this.getActivity().findViewById(R.id.shetetCarrinho));

        ImageView imagem = view.findViewById(R.id.imageViewImageSelecCarrinho);
        TextView titulo = view.findViewById(R.id.textViewtituloSelecCarrinho);
        TextView preco = view.findViewById(R.id.textViewPrecoSelecCarrinho);
        TextView estoque = view.findViewById(R.id.textViewEstoqueSelecCarrinho);
        Button mais = view.findViewById(R.id.buttonMaisSelecCarrinho);
        Button menos = view.findViewById(R.id.buttonMenosSelecCarrinho);
        Button carrinho = view.findViewById(R.id.buttonAdicionarSelecCarrinho);
        EditText quantidade = view.findViewById(R.id.editQuantidadeSelecCarrinho);
        quantidade.setText(""+qtd);

        atribuicarrinho(menos,mais,quantidade,titulo,preco,estoque,imagem,produto,carrinho);

        sheetDialog.setContentView(view);
        sheetDialog.setCancelable(true);
        sheetDialog.show();

    }

    public void atribuicarrinho(
            Button menos,
            Button mais,
            EditText quantidade,
            TextView titulo,
            TextView preco,
            TextView estoque,
            ImageView imagem,
            Produto produto,
            Button btnCarrinho
    ){


        mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtd ++;
                produto.setQuantidade(qtd);
                quantidade.setText(""+qtd);


            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtd > 0){
                    qtd--;
                    produto.setQuantidade(qtd);
                    quantidade.setText(""+qtd);

                }


            }
        });
        btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtd > 0){
                   /* Intent intent = new Intent(getActivity(), CarrinhoActivity.class);
                    intent.putExtra("produto",produto);
                    startActivity(intent);*/

                }else{
                    Toast.makeText(getActivity(), "Por favor, selecione uma quantidade!! :"+qtd, Toast.LENGTH_SHORT).show();
                }

            }
        });

        titulo.setText(produto.getTitulo());
        imagem.setImageResource(produto.getImagem());
        preco.setText("R$: "+produto.getPreco());
        Log.d("Produto",produto.toString());
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_shopping, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}