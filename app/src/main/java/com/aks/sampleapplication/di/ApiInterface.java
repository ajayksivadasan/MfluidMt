package com.aks.sampleapplication.di;

import com.aks.sampleapplication.data.BaseUserData;
import com.aks.sampleapplication.data.MessageDetails;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("users")
    Observable<List<BaseUserData>> getUsersList();

    @GET("chats/{id}")
    Observable<List<MessageDetails>> getMessageDetails(@Path("id") String id);
}
