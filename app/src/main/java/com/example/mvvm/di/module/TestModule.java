package com.example.mvvm.di.module;

import com.example.mvvm.model.Post;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    @Named("Str_test_module")
    @Provides
    static String provideStringFromTestModule(){
        return "This is a String from Test Module";
    }

    @Named("Post_Test_module")
    @Provides
    static Post providePostFromTestModule(){
        return new Post("100","100","this is post's title","this is post's body");
    }
}
