package com.example.mvvm.ui.main.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mvvm.R;
import com.example.mvvm.base.BaseActivity;
import com.example.mvvm.databinding.ActivityLogin2Binding;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLogin2Binding> {

    @NonNull
    @NotNull
    @Override
    protected LoginViewModel createViewModel() {
        return new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_login2;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(viewModel);
        binding.btnLogin.setOnClickListener(v->{
            viewModel.login(binding.edtUsername.getText().toString(),"","");
        });
    }

    @Override
    protected void initListener() {

    }


}