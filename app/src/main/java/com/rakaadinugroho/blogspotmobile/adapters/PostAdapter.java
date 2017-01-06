package com.rakaadinugroho.blogspotmobile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Raka Adi Nugroho on 1/6/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class PostHolder extends RecyclerView.ViewHolder{
        TextView post_subject;
        TextView post_created;
        public PostHolder(View itemView) {
            super(itemView);
        }
    }
}
