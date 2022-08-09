package com.aks.sampleapplication.di;

import com.aks.sampleapplication.utils.RetrofitNetwork;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class SampleModule {
    @Provides
    @Singleton
    public Retrofit providesRetrofitNetwork() {
        return RetrofitNetwork.getRetrofitInstance();
    }

    @Provides
    @Singleton
    public ApiInterface providesRetrofitPublicInstance(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

}
