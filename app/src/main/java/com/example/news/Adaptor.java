package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adaptor extends RecyclerView.Adapter<Adaptor.NewsHolder>  {
    List<Article>articles;
    Context context;

    public Adaptor(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        NewsHolder newsHolder= new NewsHolder(view);
        return newsHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        Article article=articles.get(position);
        holder.textView.setText(article.getTitle());
        Picasso.get().load(article.getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{
ImageView imageView;
TextView textView;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_imageview_news);
            textView=itemView.findViewById(R.id.item_textView_news);

        }
    }

}
