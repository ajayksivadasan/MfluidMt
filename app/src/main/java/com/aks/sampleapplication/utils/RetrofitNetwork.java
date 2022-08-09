package com.aks.sampleapplication.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetwork {
    private RetrofitNetwork() {
        //nothing to do here
    }

    public static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(logging);
        httpClient.interceptors().add(chain -> {
            Request request = chain.request();
            // try the request
            Response response = chain.proceed(request);
            if (response.code() == 401) {
                // close previous response
                response.close();
                // create a new request and modify it accordingly using the new token
                Request.Builder requestBuilder = chain.request().newBuilder();
                // retry the request
                return chain.proceed(requestBuilder.build());
            }
            // otherwise just pass the original response on
            return response;
        });
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }
}

