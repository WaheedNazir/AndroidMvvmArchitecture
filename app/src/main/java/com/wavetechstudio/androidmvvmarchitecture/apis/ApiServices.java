package com.wavetechstudio.androidmvvmarchitecture.apis;

import com.wavetechstudio.androidmvvmarchitecture.BuildConfig;
import com.wavetechstudio.androidmvvmarchitecture.ui.fragments.dummy.DummyContent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET(BuildConfig.RANMDOME_USER_API)
    Call<DummyContent> getRandomUsers(@Path("results") String resultCount);

}
