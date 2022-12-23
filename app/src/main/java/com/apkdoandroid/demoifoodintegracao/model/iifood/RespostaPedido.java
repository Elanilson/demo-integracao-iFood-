package com.apkdoandroid.demoifoodintegracao.model.iifood;

import com.google.gson.annotations.SerializedName;

public class RespostaPedido {
    @SerializedName("id")
    private String id;
    @SerializedName("trackingUrl")
    private String link;

    @Override
    public String toString() {
        return "RespostaPedido{" +
                "id='" + id + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
