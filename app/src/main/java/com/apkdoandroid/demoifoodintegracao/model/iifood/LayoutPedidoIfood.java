package com.apkdoandroid.demoifoodintegracao.model.iifood;



import com.apkdoandroid.demoifoodintegracao.model.Endereco;
import com.apkdoandroid.demoifoodintegracao.model.ItensPedido;
import com.apkdoandroid.demoifoodintegracao.model.Pedido;
import com.apkdoandroid.demoifoodintegracao.model.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LayoutPedidoIfood implements Serializable {
    private Pedido pedido;
    private Usuario usuario;
    private Endereco endereco;
    private List<ItensPedido> itensPedidos = new ArrayList<>();

    @Override
    public String toString() {
        return "LayoutPedidoIfood{" +
                "usuario=" + usuario +
                ", endereco=" + endereco +
                ", itensPedidos=" + itensPedidos +
                '}';
    }


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ItensPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItensPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
}
