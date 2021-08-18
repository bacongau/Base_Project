package com.example.mvvm.ui.main;

import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.R;
import com.example.mvvm.adapter.PostAdapter;
import com.example.mvvm.base.BaseActivity;
import com.example.mvvm.databinding.ActivityMainBinding;


/**
 * Created by Kidd on 12/03/2018.
 */

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    private static final String TAG = "MainActivity";

    private PostAdapter postAdapter;
    private DemoViewModel demoViewModel;


    @NonNull
    @Override
    protected MainViewModel createViewModel() {
        MainViewModelFactory factory = new MainViewModelFactory();
        return new ViewModelProvider(this, factory).get(MainViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        demoViewModel = new ViewModelProvider(this).get(DemoViewModel.class);

        demoViewModel.test.observe(this, s -> {
            Log.v("myLog", "str " + s);
        });

        new Handler().postDelayed(() -> {
            demoViewModel.test.postValue("this is change value string after 4s");
        }, 4000);

        postAdapter = new PostAdapter();
        binding.rcvPost.setAdapter(postAdapter);
        viewModel.getListPost();

        viewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                if (isLoading) {
                    loadingDialog.show();
                } else {
                    loadingDialog.hide();
                }
            }
        });
        viewModel.getListPostData().observe(this, posts -> {
            postAdapter.setPosts(posts);
        });
    }

    @Override
    protected void initData() {
        //todo st
    }

    @Override
    protected void initListener() {
        postAdapter.setOnItemClickListener(position -> {
            postAdapter.getPosts().get(position).getTitle();
            Log.d(TAG, "initListener: " + postAdapter.getPosts().get(position).getTitle());
        });
    }
}
