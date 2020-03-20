package com.saidur.paharadar.ui.home.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saidur.paharadar.R;
import com.saidur.paharadar.ui.home.model.Post;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private Context context;
    private List<Post> posts = new ArrayList<>();

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model_post_show,null);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Post post = posts.get(position);

        holder.title.setText(post.getTitle());
        holder.details.setText(post.getDescription());

        if(post.getType().equals("Type_Normal"))
        {
            holder.type.setImageResource(R.drawable.ic_post_type_green);
            holder.title.setTextColor(Color.parseColor("#0AC411"));

        }else if(post.getType().equals("Type_Urgent")){
            holder.type.setImageResource(R.drawable.ic_post_type_red);
            holder.title.setTextColor(Color.RED);
        }else{
            holder.type.setImageResource(R.drawable.ic_post_type_yellow);
         //   holder.title.setTextColor(Color.parseColor("#DD9A0C"));
            holder.title.setTextColor(Color.parseColor("#FDBA12"));
        }



    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,details;
        ImageView type;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.model_post_title_id);
            details = itemView.findViewById(R.id.model_post_details_id);
            type = itemView.findViewById(R.id.model_post_types_id);
        }
    }
}
