package com.example.constructdemo.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static Retrofit mRetrofit;

    public static RetrofitManager getInstance(){
        return Holder.ins;
    }

    private RetrofitManager(){
        initRetrofit();
    }

    private static class Holder{
        private static final RetrofitManager ins=new RetrofitManager();
    }

    public  <T> T getService(Class<T> cls){
        T t= mRetrofit.create(cls);
        return t;
    }

    private static void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .client(HttpBase.getInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
