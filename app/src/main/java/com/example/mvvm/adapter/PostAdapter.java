package com.example.mvvm.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.R;
import com.example.mvvm.base.BaseAdapter;
import com.example.mvvm.databinding.ItemPostBinding;
import com.example.mvvm.model.Post;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends BaseAdapter<ItemPostBinding> {     // da fix
    private List<Post> posts = new ArrayList<>();
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_post;
    }

    @Override
    protected BaseViewHolder solvedOnCreateViewHolder(ItemPostBinding binding) {
        return new PostViewHolder(binding,mListener);
    }

    @Override
    protected void solvedOnBindViewHolder(BaseViewHolder holder, int position) {
        ((PostViewHolder) holder).bind(posts.get(position));
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    private class PostViewHolder extends BaseViewHolder<Post>{

        ItemPostBinding binding;

        public PostViewHolder(ItemPostBinding binding,OnItemClickListener mListener) {
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(v -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            });
        }

        @Override
        protected void bind(Post data) {
            binding.setPost(data);
            binding.container.setBackgroundColor(data.getColor());
        }
    }
}
