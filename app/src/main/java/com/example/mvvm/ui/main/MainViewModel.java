package com.example.mvvm.ui.main;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.model.Post;
import com.example.mvvm.repository.Repository;
import com.example.mvvm.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Kidd on 18/12/2018.
 */
public class MainViewModel extends BaseViewModel {

    private final Repository repository;

    private MutableLiveData<List<Post>> listPost = new MutableLiveData<>();

    public MutableLiveData<List<Post>> getListPostData(){
        return listPost;
    }

    MainViewModel() {
        this.repository = new Repository();
    }

    public void getListPost(){
        compositeDisposable.add(repository.getPost()
                .doOnSubscribe(disposable -> {
                    //showLoading
                    loading.setValue(true);
                })
                .doFinally(()->{
                    //hideLoading
                    loading.setValue(false);
                })
                .subscribe(
                        res->{
                            //handleReponse
                            Random random = new Random();
                            for(Post p : res){
                                p.setColor(Color.argb(random.nextInt(255),
                                        random.nextInt(255),
                                        random.nextInt(255),
                                        random.nextInt(255)));
                            }
                            listPost.setValue(res);
                        },
                        throwable -> {
                            //handleError
                        }
                ));
    }



}
