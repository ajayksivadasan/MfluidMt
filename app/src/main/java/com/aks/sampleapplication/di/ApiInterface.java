package com.aks.sampleapplication.di;

import com.aks.sampleapplication.data.BaseUserData;
import com.aks.sampleapplication.data.ReceiveMessage;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("users")
    Observable<List<BaseUserData>> getUsersList();

    @GET("chats/{id}")
    Observable<ReceiveMessage> getMessageDetails(@Path("id") String id);
}
