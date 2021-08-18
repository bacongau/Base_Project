package com.example.mvvm.ui.main.login;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.base.BaseViewModel;
import com.example.mvvm.repository.Repository;
import com.example.mvvm.utils.Utils;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Response;

public class LoginViewModel extends BaseViewModel {

    private Repository repository;


    private MutableLiveData<String> error = new MutableLiveData<>();

    @Inject
    public LoginViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public void login(String username, String password, String fcmToken){
        if(username.isEmpty()){
            //handlerror
            error.setValue("error");
            return;
        }

        //after validate
        RequestBody requestBody = RequestBody.create(fcmToken, MediaType.parse("text/plain"));
        //showLoading
        compositeDisposable.add(repository.login(requestBody)
                .doOnSubscribe(disposable -> {
                    //showloading
                })
                .doFinally(() -> {
                    //hideloading
                })
                .subscribe(
                        response->{
                            //ok
                        },
                        throwable -> {
                            //error
                        }
                ));

    }
}
