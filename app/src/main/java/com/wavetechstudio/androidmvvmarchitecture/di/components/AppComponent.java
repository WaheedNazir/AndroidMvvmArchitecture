package com.wavetechstudio.androidmvvmarchitecture.di.components;

import android.app.Application;

import com.wavetechstudio.androidmvvmarchitecture.app.MyApp;
import com.wavetechstudio.androidmvvmarchitecture.di.modules.ActivityModule;
import com.wavetechstudio.androidmvvmarchitecture.di.modules.AppModule;
import com.wavetechstudio.androidmvvmarchitecture.di.modules.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityModule.class, FragmentModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MyApp app);
}
