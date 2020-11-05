package com.appynitty.cavistacodecallengeapp.common.retrofit;


import com.appynitty.cavistacodecallengeapp.common.CommonConstant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ayan Dey on 30/10/20.
 */
public  class Retro {
    public static  Retro retro;

  public   static Retro getInstance() {
        if(retro==null) {
            retro   =new Retro();
        }
        return retro;
    }


    private Interceptor getHeader(String header){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request  original = chain.request();
                Request.Builder requestBuilder= original.newBuilder().header("Authorization",header);
                Request request = requestBuilder.build();
                return chain.proceed(request);

            }
        };


    }

     public ApiController getController(String header){
         HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
         interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
         OkHttpClient.Builder builder= new OkHttpClient.Builder();
         builder.connectTimeout(5, TimeUnit.MINUTES);
         builder.addInterceptor(interceptor);
         builder.readTimeout(5, TimeUnit.MINUTES);
         if(header!=null)
             builder.addInterceptor(getHeader(header));

         OkHttpClient client = builder.build();
         Gson gson= new GsonBuilder().setLenient().serializeNulls().create();
         Retrofit retrofit;
         retrofit= new Retrofit.Builder().baseUrl(CommonConstant.baseUrl)
         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();


         return retrofit.create(ApiController.class);

     };

//                   .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

}
