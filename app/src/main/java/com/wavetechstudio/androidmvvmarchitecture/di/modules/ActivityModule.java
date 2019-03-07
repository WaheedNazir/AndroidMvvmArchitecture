package com.wavetechstudio.androidmvvmarchitecture.di.modules;

import com.wavetechstudio.androidmvvmarchitecture.ui.activities.RandomUsersActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract interface ActivityModule {

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract RandomUsersActivity contributesRandomUsersActivity();

}
