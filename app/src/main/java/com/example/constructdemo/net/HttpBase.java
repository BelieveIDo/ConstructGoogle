package com.example.constructdemo.net;

public class HttpBase {

    public static HttpBase getInstance(){
        return ClientSingle.ins;
    }

    private static class ClientSingle{
        private static final HttpBase ins=new HttpBase();
    }

    private HttpBase(){

    }

}
