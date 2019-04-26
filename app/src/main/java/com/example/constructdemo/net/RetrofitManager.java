package com.example.constructdemo.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    public  <T> T getService(Class<T> cls){
        T t=new Retrofit.Builder().baseUrl(AppConstant.BASE_URL)
                .client(HttpBase.getInstance())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(cls);

        return t;
    }
}
