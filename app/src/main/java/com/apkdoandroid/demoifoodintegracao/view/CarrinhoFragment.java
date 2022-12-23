package com.apkdoandroid.demoifoodintegracao.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.databinding.FragmentCarrinhoBinding;
import com.apkdoandroid.demoifoodintegracao.view.activity.PaineliFoodActivity;


public class CarrinhoFragment extends Fragment {
private FragmentCarrinhoBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCarrinhoBinding.inflate(inflater, container, false);


        binding.toolbar.toolbar.setTitle("Delivery");
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar.toolbar);

        binding.buttonFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertaPedidoEnviado();
            }
        });


        return  binding.getRoot();
    }

    private void alertaPedidoEnviado(){
        Dialog dialog = new Dialog(getActivity(),android.R.style.Theme_Light_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.layout__pedido_enviado_com_sucesso);
        Button btnFechar = dialog.findViewById(R.id.buttonSucessoFechar);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PaineliFoodActivity.class));
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new PedidosFragment()).commit();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_shopping, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}