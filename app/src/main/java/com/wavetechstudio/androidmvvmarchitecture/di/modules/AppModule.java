package com.wavetechstudio.androidmvvmarchitecture.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wavetechstudio.androidmvvmarchitecture.BuildConfig;
import com.wavetechstudio.androidmvvmarchitecture.apis.ApiServices;
import com.wavetechstudio.androidmvvmarchitecture.apis.BaseUrlHolder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    //-----Network Client Injection-------
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson, BaseUrlHolder baseUrlHolder) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrlHolder.getBaseUrl())
                .build();
    }

    @Provides
    @Singleton
    ApiServices provideApiServices(Retrofit retrofit) {
        return retrofit.create(ApiServices.class);
    }

    // --- For Dynamic URL -----
    @Singleton
    @Provides
    BaseUrlHolder provideBaseUrlHolder() {
        return new BaseUrlHolder(BuildConfig.BASE_URL);
    }
}
