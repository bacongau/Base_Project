package com.example.mvvm.di;


import android.app.Application;

import com.example.mvvm.App;
import com.example.mvvm.di.module.ActivityBindingModule;
import com.example.mvvm.di.module.AppModule;
import com.example.mvvm.di.module.NetworkModule;
import com.example.mvvm.di.module.TestModule;
import com.example.mvvm.di.module.ViewModelModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        ViewModelModule.class,
        NetworkModule.class,
        TestModule.class
})
public interface AppComponent {

    void inject(App baseApplication);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }
}
