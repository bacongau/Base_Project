package com.example.mvvm.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract Context provideContext(Application application);

    @Named("Str_app_module")
    @Provides
    static String str(){
        return "This is a string from app module";
    }
}
