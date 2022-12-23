package com.apkdoandroid.demoifoodintegracao.listener;

public interface APIListener<T>{
    void onSuccess(T result);
    void onFailures(String mensagem);

}
