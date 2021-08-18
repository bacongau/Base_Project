package com.example.mvvm.di.module;

import com.example.mvvm.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
