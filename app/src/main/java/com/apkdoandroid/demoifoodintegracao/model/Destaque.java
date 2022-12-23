package com.apkdoandroid.demoifoodintegracao.model;

public class Destaque {
    private String urlImagem;
    private String titulo;


    public Destaque() {
    }

    public Destaque(String urlImagem, String titulo) {
        this.urlImagem = urlImagem;
        this.titulo = titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
