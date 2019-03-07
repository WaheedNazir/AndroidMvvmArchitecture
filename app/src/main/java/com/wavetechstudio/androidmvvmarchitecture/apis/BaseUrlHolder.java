package com.wavetechstudio.androidmvvmarchitecture.apis;

public class BaseUrlHolder {
    private String baseUrl;

    public BaseUrlHolder(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}

//App.appComponent.getBaseUrlHolder().set("https://www.changed.com");