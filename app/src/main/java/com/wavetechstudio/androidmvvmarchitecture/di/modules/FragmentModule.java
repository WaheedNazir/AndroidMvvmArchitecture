package com.wavetechstudio.androidmvvmarchitecture.di.modules;

import com.wavetechstudio.androidmvvmarchitecture.ui.fragments.RandomUsersFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract interface FragmentModule {

    @ContributesAndroidInjector
    abstract RandomUsersFragment contributesRandomUsersFragment();
}
