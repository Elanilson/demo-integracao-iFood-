package com.apkdoandroid.demoifoodintegracao.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.apkdoandroid.demoifoodintegracao.model.Destaque;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<List<String>> _Banners = new MutableLiveData<>();
    public LiveData<List<String>> banners = _Banners;
    private MutableLiveData<List<String>> _Lojas = new MutableLiveData<>();
    public LiveData<List<String>> lojas = _Lojas;
    private MutableLiveData<List<Destaque>> _Destaques = new MutableLiveData<>();
    public LiveData<List<Destaque>> destaques = _Destaques;

    private List<String> lista_banner = new ArrayList<>();
    private List<String> lista_lojas = new ArrayList<>();
    private List<Destaque> lista_Destaque = new ArrayList<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getListaBanners(){
        popularLista_banners();
    }

    public void carregarLoja(){
        popularLista_lojas();
    }


    public void popuarDestaque(){
        carregarDestaque();
    }

    private void popularLista_banners(){
        lista_banner.add("https://static-images.ifood.com.br/image/upload/t_high/discoveries/bannercarrossel1_7Cdv.png");
        lista_banner.add("https://static-images.ifood.com.br/image/upload/t_high/discoveries/0912amigosecreto30principal1_zSJ8.png");
        lista_banner.add("https://static-images.ifood.com.br/image/upload/t_high/discoveries/13dezrestaurantescomcupomde5Principal_HW5T.png");
        lista_banner.add("https://static-images.ifood.com.br/image/upload/t_high/discoveries/13dezrestaurantescomentregagratisPrincipal_1xuh.png");
        _Banners.setValue(lista_banner);
    }

    private void popularLista_lojas(){
        lista_lojas.add("https://static-images.ifood.com.br/image/upload/t_medium/logosgde/2305f43a-807a-4c79-8b25-5a7290d75572/202110111654_lYTO_.jpeg");
        lista_lojas.add("https://static-images.ifood.com.br/image/upload/t_medium/logosgde/6ca4d6e2-dcf4-48c0-a74b-0ae4a05b2e55/202111301632_OP3v_i.png");
        lista_lojas.add("https://static-images.ifood.com.br/image/upload/t_medium/logosgde/logoberp_teste_temas.jpg");
        lista_lojas.add("https://static-images.ifood.com.br/image/upload/t_medium/logosgde/5729dc04-f62c-4165-8075-02b5043d92c0/202101202013_RC2e_i.png");
        _Lojas.setValue(lista_lojas);
    }


    private  void carregarDestaque(){

        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/lanches_HC15.png","Lanches"));
        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/salgados_dTNG.png","Salgados"));
        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/docesebolos_RfHb.png","Doces & Bolos"));
        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/brasileira_1XfT.png","Brasileira"));
        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/pastel2_qeWo.png","Pastel"));
        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/pizzas_KxCO.png","Pizza"));
        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/Marmita2_LXbQ.png","Marmita"));
        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/gourmet_qo1l.png","Gourmet"));
        lista_Destaque.add(new Destaque("https://static-images.ifood.com.br/image/upload/t_medium/discoveries/japonesa_FP14.png","Japonesa"));

        _Destaques.setValue(lista_Destaque);

    }
}
