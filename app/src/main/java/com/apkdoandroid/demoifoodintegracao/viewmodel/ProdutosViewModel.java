package com.apkdoandroid.demoifoodintegracao.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutosViewModel extends AndroidViewModel {

    private MutableLiveData<List<Produto>> _ProdutosMaisVendidos = new MutableLiveData<>();
    public LiveData<List<Produto>> produtosMaisVendidos = _ProdutosMaisVendidos;

    private MutableLiveData<List<Produto>> _Hort = new MutableLiveData<>();
    public LiveData<List<Produto>> hort = _Hort;

    private MutableLiveData<List<Produto>> _Bedida = new MutableLiveData<>();
    public LiveData<List<Produto>> bebida = _Bedida;

    private MutableLiveData<List<Produto>> _AlimentosBasicos = new MutableLiveData<>();
    public LiveData<List<Produto>> alimentosBasico = _AlimentosBasicos;

    private List<Produto> maisvendidos = new ArrayList<>();
    private List<Produto> alimentos = new ArrayList<>();
    private List<Produto> frutas = new ArrayList<>();
    private List<Produto> bebidas = new ArrayList<>();
    public ProdutosViewModel(@NonNull Application application) {
        super(application);
    }


    public void carregarMaisVendidos(){
        montarProdutosMaisVendidos();
    }

    public void carregarAlimentosBasicos(){
        montarAlimentosBasicos();
    }
    public void carregarHort(){
        montarHort();
    }
    public void carregarBebidas(){
        montarBebida();
    }



    private void montarProdutosMaisVendidos(){
        Produto produto = new Produto("Banana nanica",4.99, R.drawable.banana,1);
        maisvendidos.add(produto);
        produto = new Produto("Pytaia",4.19,R.drawable.fruta1,1);
        maisvendidos.add(produto);
        produto = new Produto("Arroz tipo 1 1kg",4.58,R.drawable.alimento2,1);
        maisvendidos.add(produto);
        produto = new Produto("Tang laranja 25g",0.75,R.drawable.refri2,1);
        maisvendidos.add(produto);
        produto = new Produto("Açúcar UNIÃO 1kg",2.59,R.drawable.alimento4,1);
        maisvendidos.add(produto);
        produto = new Produto("Abacate",2.99,R.drawable.fruta2,1);
        maisvendidos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        maisvendidos.add(produto);

        _ProdutosMaisVendidos.setValue(maisvendidos);
    }

    private void montarAlimentosBasicos(){
        Produto alimento = new Produto("Feijão Carioca 1 Kg",7.99,R.drawable.alimento1,0);
        alimentos.add(alimento);
        alimento = new Produto("Arroz tipo 1 1kg",4.58,R.drawable.alimento2,0);
        alimentos.add(alimento);
        alimento = new Produto("Farinha de Milho 500g",5.15,R.drawable.alimento3,0);
        alimentos.add(alimento);
        alimento = new Produto("Açúcar UNIÃO 1kg",2.59,R.drawable.alimento4,0);
        alimentos.add(alimento);
        alimento = new Produto("Óleo SOYA 900ml",4.99,R.drawable.alimento5,0);
        alimentos.add(alimento);
        _AlimentosBasicos.setValue(alimentos);
    }

    private void montarHort(){
        Produto fruta = new Produto("Abacate",4.99,R.drawable.fruta2,0);
        frutas.add(fruta);
        fruta = new Produto("Pytaia",4.19,R.drawable.fruta1,0);
        frutas.add(fruta);
        fruta = new Produto("Banana nanica",4.99,R.drawable.banana,0);
        frutas.add(fruta);
        fruta = new Produto("Melancia",4.99,R.drawable.fruta3,0);
        frutas.add(fruta);
        fruta = new Produto("Pera",3.99,R.drawable.fruta4,0);
        frutas.add(fruta);
        fruta = new Produto("Abacate",2.99,R.drawable.fruta2,0);
        frutas.add(fruta);
        fruta = new Produto("Banana nanica",2.99,R.drawable.banana,0);
        frutas.add(fruta);
        fruta = new Produto("Pera",5.99,R.drawable.fruta4,0);
        frutas.add(fruta);

        _Hort.setValue(frutas);
    }

    private void montarBebida(){
        Produto bebida = new Produto("Coca cola 2L",5.99,R.drawable.refri1,0);
        bebidas.add(bebida);
        bebida = new Produto("Tang laranja 25g",0.75,R.drawable.refri2,0);
        bebidas.add(bebida);
        bebida = new Produto("Dafruta premium uva 1L",1.50,R.drawable.refri3,0);
        bebidas.add(bebida);
        bebida = new Produto("Fanta laranja 350ml",0.99,R.drawable.refri4,0);
        bebidas.add(bebida);
        bebida = new Produto("Kero coco",4.45,R.drawable.refri5,0);
        bebidas.add(bebida);

        _Bedida.setValue(bebidas);
    }


}
