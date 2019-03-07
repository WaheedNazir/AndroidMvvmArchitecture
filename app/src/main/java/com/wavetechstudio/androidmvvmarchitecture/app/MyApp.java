package com.wavetechstudio.androidmvvmarchitecture.app;

import android.app.Activity;
import android.app.Application;

import com.wavetechstudio.androidmvvmarchitecture.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    // ---
    private void initDagger() {
        DaggerAppComponent.builder().application(this).build().inject(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }
}
