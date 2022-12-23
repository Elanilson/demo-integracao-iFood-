package com.apkdoandroid.demoifoodintegracao.repositorio;

import android.content.Context;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.listener.APIListener;
import com.apkdoandroid.demoifoodintegracao.model.CancelamentoDePedido;
import com.apkdoandroid.demoifoodintegracao.model.Endereco;
import com.apkdoandroid.demoifoodintegracao.model.iifood.Autenticacao;
import com.apkdoandroid.demoifoodintegracao.model.iifood.Cliente;
import com.apkdoandroid.demoifoodintegracao.model.iifood.Coordenadas;
import com.apkdoandroid.demoifoodintegracao.model.iifood.DetalhesPedido;
import com.apkdoandroid.demoifoodintegracao.model.iifood.EnderecoDeEntrega;
import com.apkdoandroid.demoifoodintegracao.model.iifood.Entrega;
import com.apkdoandroid.demoifoodintegracao.model.iifood.Error;
import com.apkdoandroid.demoifoodintegracao.model.iifood.EventoPedido;
import com.apkdoandroid.demoifoodintegracao.model.iifood.Item;
import com.apkdoandroid.demoifoodintegracao.model.iifood.LayoutEnvioPedido;
import com.apkdoandroid.demoifoodintegracao.model.iifood.RespostaDisponibilidadeDeEntrega;
import com.apkdoandroid.demoifoodintegracao.model.iifood.RespostaPedido;
import com.apkdoandroid.demoifoodintegracao.model.iifood.Telefone;
import com.apkdoandroid.demoifoodintegracao.repositorio.remoto.RetrofitClientIFood;
import com.apkdoandroid.demoifoodintegracao.repositorio.remoto.services.IfoodService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IfoodRepositorio {
    private Context context;
    private IfoodService service ;
    private  String  grantType , grantType2;
    private  String  clientId ;
    private  String  clientSecret ;
    private  String  authorizationCode ;
  //  private  String  refresh_token ;
    private  String  authorizationCodeVerifier ;
    private Cliente cliente = new Cliente();
    private EnderecoDeEntrega enderecoDeEntrega = new EnderecoDeEntrega();
    private Entrega entrega = new Entrega();
    private Coordenadas coordenadas = new Coordenadas();
    private Telefone telefone = new Telefone();
    private List<Item> itens=  new ArrayList<>();
    private String token = "";

    public IfoodRepositorio(Context context ) {
        this.context = context;


        service =  RetrofitClientIFood.classService(IfoodService.class);


         grantType = context.getString(R.string.grantType);
        grantType2 = context.getString(R.string.grantType2);
         clientId = context.getString(R.string.clientId);
         clientSecret = context.getString(R.string.clientSecret);
       // refresh_token = context.getString(R.string.refresh_token);
         authorizationCode = context.getString(R.string.authorizationCode);
         authorizationCodeVerifier = context.getString(R.string.authorizationCodeVerifier);
    }


    public void autenticar(APIListener<Autenticacao> listener ){
        Call<Autenticacao> call = service.autenticar(grantType2,clientId,clientSecret);
        call.enqueue(new Callback<Autenticacao>() {
            @Override
            public void onResponse(Call<Autenticacao> call, Response<Autenticacao> response) {
                if(response.isSuccessful()){
                    listener.onSuccess(response.body());
                    System.out.println("autenticar "+response.body().toString());

                }else{
                    System.out.println("autenticar: "+response.errorBody());
                    try {
                        String json = response.errorBody().string();
                        Gson gson = new GsonBuilder().create();
                        Error obj = gson.fromJson(json, Error.class);
                        listener.onFailures(obj.getMensagem() + " Tente novamente");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Autenticacao> call, Throwable t) {
                listener.onFailures(t.getMessage());

            }
        });

    }
    public void renovarToken(APIListener<Autenticacao> listener,String refresh_token){
        Call<Autenticacao> call = service.renovarToken(grantType,clientId,clientSecret,refresh_token);
        call.enqueue(new Callback<Autenticacao>() {
            @Override
            public void onResponse(Call<Autenticacao> call, Response<Autenticacao> response) {
                    System.out.println("renovarToken - Code "+response.code());
                if(response.isSuccessful()){
                    System.out.println("renovarToken "+response.body().toString());
                    listener.onSuccess(response.body());

                }else{
                    System.out.println("renovarToken: "+response.errorBody());
                    try {
                        String json = response.errorBody().string();
                        Gson gson = new GsonBuilder().create();
                        Error obj = gson.fromJson(json, Error.class);
                        listener.onFailures(obj.getMensagem() + " Tente novamente");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Autenticacao> call, Throwable t) {
                listener.onFailures(t.getMessage());

            }
        });

    }
    public void verificarEventos(APIListener<List<EventoPedido>> listener){
        Call<List<EventoPedido>> call = service.verificarEventos();
        call.enqueue(new Callback<List<EventoPedido>>() {
            @Override
            public void onResponse(Call<List<EventoPedido>> call, Response<List<EventoPedido>> response) {
                if(response.isSuccessful()){
                    System.out.println("verificarEventos : "+response.code());
                    listener.onSuccess(response.body());

                }else{
                    System.out.println("verificarEventos: "+response.errorBody());
                    try {
                        String json = response.errorBody().string();
                        Gson gson = new GsonBuilder().create();
                        Error obj = gson.fromJson(json, Error.class);
                        listener.onFailures(obj.getMensagem() + " Tente novamente");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<EventoPedido>> call, Throwable t) {
                listener.onFailures(t.getMessage());

            }
        });
    }
    public void despachar(APIListener<Boolean> listener,String idPedido){
        // String idPedido = "a0af51da-72ff-44dc-9950-a09912d00f12";
        Call<Void> call = service.despachar(idPedido);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 202){
                    listener.onSuccess(true);
                }else{
                    try {
                        String json = response.errorBody().string();
                        Gson gson = new GsonBuilder().create();
                        Error obj = gson.fromJson(json, Error.class);
                        listener.onFailures(obj.getMensagem() + " Tente novamente");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    listener.onSuccess(false);
                }


                System.out.println("Code: "+response.code());
                System.out.println("Body: "+response.body());


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onFailures(t.getMessage());
            }
        });

    }
    public void confirmarPedido(APIListener<Boolean> listener,String idPedido){
       // String idPedido = "a0af51da-72ff-44dc-9950-a09912d00f12";
        Call<Void> call = service.confirmarPedido(idPedido);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.code() == 202){
                        listener.onSuccess(true);
                    }else{
                        try {
                            String json = response.errorBody().string();
                            Gson gson = new GsonBuilder().create();
                            Error obj = gson.fromJson(json, Error.class);
                            listener.onFailures(obj.getMensagem() + " Tente novamente");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        listener.onSuccess(false);
                   }


                    System.out.println("Code: "+response.code());
                    System.out.println("Body: "+response.body());


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onFailures(t.getMessage());
            }
        });

    }
    public void cancelarPepdido(APIListener<Boolean> listener, CancelamentoDePedido cancelamentoDePedido, String idPedido){
      //  String idPedido = "a0af51da-72ff-44dc-9950-a09912d00f12";
        Call<Void> call = service.cancelarPepdido(idPedido,cancelamentoDePedido);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                    if(response.code() == 202){
                        listener.onSuccess(true);
                    }else{
                        try {
                            String json = response.errorBody().string();
                            Gson gson = new GsonBuilder().create();
                            Error obj = gson.fromJson(json, Error.class);
                            listener.onFailures(obj.getMensagem() + " Tente novamente");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        listener.onSuccess(false);

                    }


                System.out.println("Body: "+response.body());
                System.out.println("Code: "+response.code());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onFailures(t.getMessage());
            }
        });

    }
    public void aceitarPedidoDeCanelamento(APIListener<Boolean> listener){
        String idPedido = "a0af51da-72ff-44dc-9950-a09912d00f12";
        Call<Void> call = service.aceitarPedidoDeCanelamento(idPedido);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.code() == 202){
                        listener.onSuccess(true);
                    }else{

                        try {
                            String json = response.errorBody().string();
                            Gson gson = new GsonBuilder().create();
                            Error obj = gson.fromJson(json, Error.class);
                            listener.onFailures(obj.getMensagem() + " Tente novamente");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        listener.onSuccess(false);
                    }
                    System.out.println("Code: "+response.code());
                    System.out.println("Body: "+response.body());


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onFailures(t.getMessage());
            }
        });

    }
    public void negarPedidoDeCanelamento(APIListener<Boolean> listener){
        String idPedido = "a0af51da-72ff-44dc-9950-a09912d00f12";
        Call<Void> call = service.negarPedidoDeCanelamento(idPedido);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                    if(response.code() == 202){
                        listener.onSuccess(true);
                    }else{

                        try {
                            String json = response.errorBody().string();
                            Gson gson = new GsonBuilder().create();
                            Error obj = gson.fromJson(json, Error.class);
                            listener.onFailures(obj.getMensagem() + " Tente novamente");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        listener.onSuccess(false);
                    }
                    System.out.println("Code: "+response.code());
                    System.out.println("Body: "+response.body());


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onFailures(t.getMessage());
            }
        });

    }
    public void buscarDetalhesDoPedido(APIListener<DetalhesPedido> listener){
        String idPedido = "a0af51da-72ff-44dc-9950-a09912d00f12";
        Call<DetalhesPedido> call = service.buscarDetalhesDoPedido(idPedido);
        call.enqueue(new Callback<DetalhesPedido>() {
            @Override
            public void onResponse(Call<DetalhesPedido> call, Response<DetalhesPedido> response) {
                if(response.code() == 200){
                    listener.onSuccess(response.body());
                }else{
                    try {
                        String json = response.errorBody().string();
                        Gson gson = new GsonBuilder().create();
                        Error obj = gson.fromJson(json, Error.class);
                        listener.onFailures(obj.getMensagem() + "Tente novamente");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
               // System.out.println("Detalhes Pedido "+response.body());
             //   System.out.println("Detalhes Pedido "+response.errorBody());

            }

            @Override
            public void onFailure(Call<DetalhesPedido> call, Throwable t) {
                listener.onFailures(t.getMessage());


            }
        });
    }
    public void reconhecerLimparEnventos(APIListener<Boolean> listener, List<EventoPedido> eventoPedidos){
        Call<Void> call = service.reconhecerLimparEnventos(eventoPedidos);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                    if(response.code() == 202 || response.code() == 204 ){
                        listener.onSuccess(true);
                    }else{
                        listener.onSuccess(false);
                    }
                    System.out.println("Code: "+response.code());
                    System.out.println("Body: "+response.body());


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onFailures(t.getMessage());
            }
        });

    }
    public void verificarFreteIfood(APIListener<RespostaDisponibilidadeDeEntrega> listener, Endereco endereco){
        String idLoja = context.getString(R.string.idLoja);
        Double latitude = -9.822159;
        Double longitude = -67.948475;
        endereco.setLatitude(latitude);
        endereco.setLongitude(longitude);
        Call<RespostaDisponibilidadeDeEntrega> call = service.verificarFreteIfood(idLoja,endereco.getLatitude(),endereco.getLongitude());
        call.enqueue(new Callback<RespostaDisponibilidadeDeEntrega>() {
            @Override
            public void onResponse(Call<RespostaDisponibilidadeDeEntrega> call, Response<RespostaDisponibilidadeDeEntrega> response) {
              if(response.code() == 200) {
                  listener.onSuccess(response.body());


            //  }else if(response.code() == 401){
              //    listener.onFailures("token expirado");
              }else{ //parei no error que ta dando para saber o frete
                  System.out.println("frete "+response.code());
                //  listener.onFailures("Entrega Fácil indisponível: o endereço da entrega está a mais de 10 km da  loja.");
                //  System.out.println("Entrega Fácil indisponível: o endereço da entrega está a mais de 10 km da  loja.");
                  try {
                     String json = response.errorBody().string();
                      Gson gson = new GsonBuilder().create();
                      Error obj = gson.fromJson(json, Error.class);
                      listener.onFailures(obj.getMensagem() + " Tente novamente");
                  } catch (Exception  e) {
                      e.printStackTrace();
                  }

              }

            }

            @Override
            public void onFailure(Call<RespostaDisponibilidadeDeEntrega> call, Throwable t) {
                listener.onFailures(t.getMessage());


            }
        });


    }
    public void criarPedidoIfood(APIListener<RespostaPedido> listener, LayoutEnvioPedido layoutPedidos){
        carregarDadosPedido();
        LayoutEnvioPedido layoutPedido = new LayoutEnvioPedido();
        layoutPedido.setCliente(cliente);
        layoutPedido.setEntrega(entrega);
        layoutPedido.setItens(itens);

        String idLoja = context.getString(R.string.idLoja);
        Call<RespostaPedido> call = service.criarPedidoIfood(idLoja,layoutPedido);
        call.enqueue(new Callback<RespostaPedido>() {
            @Override
            public void onResponse(Call<RespostaPedido> call, Response<RespostaPedido> response) {
                if(response.isSuccessful()){
                    System.out.println("resposta: "+response.code());
                    listener.onSuccess(response.body());

                }else{

                    System.out.println("apkdoandroid: mensagem de error "+response.errorBody());
                    System.out.println("apkdoandroid: code "+response.code());

                    try {
                        String json = response.errorBody().string();
                        Gson gson = new GsonBuilder().create();
                        Error obj = gson.fromJson(json, Error.class);
                        listener.onFailures(obj.getMensagem() + "Tente novamente");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<RespostaPedido> call, Throwable t) {
                listener.onFailures(t.getMessage());

            }
        });
    }


    private void carregarDadosPedido(){
        telefone.setCodigoDoPais("55");
        telefone.setCodigoDeArea("91");
        telefone.setNumero("996017676");

        coordenadas.setLatitude(-9.822159);
        coordenadas.setLongitude(-67.948475);

        cliente.setNome("Elanilson");
        cliente.setTelefone(telefone);
        enderecoDeEntrega.setBairro("Sacramenta");
        enderecoDeEntrega.setCidade("Belém");
        enderecoDeEntrega.setComplemento("");
        enderecoDeEntrega.setEstado("PA");
        enderecoDeEntrega.setCodigo_postal("66120300");
        enderecoDeEntrega.setPais("BR");
        enderecoDeEntrega.setNome_da_rua("Santa maria");
        enderecoDeEntrega.setNumero_da_casa("526");
        enderecoDeEntrega.setReferencia("");
        enderecoDeEntrega.setCoordenadas(coordenadas);

        entrega.setTaxa_do_comerciante(10f);
        entrega.setEnderecoDeEntrega(enderecoDeEntrega);

        itens.add(new Item(UUID.randomUUID().toString(),"Banana nanica",123L,1,4.99f,4.99f,4.99f));
        itens.add(new Item(UUID.randomUUID().toString(),"Óleo SOYA 900ml",124L,1,4.99f,4.99f,4.99f));
        itens.add(new Item(UUID.randomUUID().toString(),"Fanta laranja 350ml",125L,1,0.99f,0.99f,0.99f));
       // itens.add(new Item(UUID.randomUUID().toString(),"Aveia",126L,1,1f,1f,1f));


    }



}
