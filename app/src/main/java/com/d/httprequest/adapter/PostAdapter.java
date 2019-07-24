package com.d.httprequest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.ImageView;
import android.widget.TextView;

import com.d.httprequest.R;
import com.d.httprequest.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private Context context;
    private List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_post, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Post mPost = postList.get(position);
        //   String imagerUrl = mPost.getTitle();
        String date = mPost.getDate();
        String title = mPost.getDate();
        int id = mPost.getId();

        viewHolder.tvId.setText("Id: " + id);
        viewHolder.tvDate.setText("Date: " + date);
        viewHolder.tvTitle.setText("Title: " + title);

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //   public ImageView imageView;
        public TextView tvId;
        public TextView tvDate;
        public TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // imageView = itemView.findViewById(R.id.image_view);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvId = itemView.findViewById(R.id.tvId);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}
