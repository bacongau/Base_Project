package com.example.mvvm;

import android.app.Activity;
import android.app.Application;

import com.example.mvvm.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


/**
 * Created by Kidd on 10/03/2018.
 */
public class App extends Application implements HasActivityInjector {

    private static App sInstance;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    public static App getInstance() {
        return sInstance;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
