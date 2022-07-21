package com.mc.qr.entity.service;

import kotlin.experimental.ExperimentalTypeInference;

public class Usuario {

    private Long ad_user_id;
    public Long getAd_user_id(){
        return ad_user_id;
    }

    public void setAd_user_id(Long ad_user_id) {
        this.ad_user_id = ad_user_id;
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  String getPassword(){
        return  password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
