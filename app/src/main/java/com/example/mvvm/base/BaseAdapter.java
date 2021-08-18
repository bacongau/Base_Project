package com.example.mvvm.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public abstract class BaseAdapter<T extends ViewDataBinding> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {   // fixed
    protected abstract int getLayoutId();

    protected abstract BaseViewHolder solvedOnCreateViewHolder(T binding);
    protected abstract void solvedOnBindViewHolder(BaseViewHolder holder,int position);

    @NonNull
    @NotNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        T binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), parent, false);
        return solvedOnCreateViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BaseViewHolder holder, int position) {
        solvedOnBindViewHolder(holder,position);
    }

    protected static abstract class BaseViewHolder<U> extends RecyclerView.ViewHolder {
        public BaseViewHolder(View view) {
            super(view);
        }

        protected abstract void bind(U data);

    }
}
