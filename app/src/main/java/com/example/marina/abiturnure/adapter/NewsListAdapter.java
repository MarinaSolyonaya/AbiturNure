package com.example.marina.abiturnure.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marina.abiturnure.R;
import com.example.marina.abiturnure.dto.NewsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<NewsModel> data;
    Context context;



    public NewsListAdapter(Context context, List<NewsModel> data) {

        this.data = data;
        this.context=context;
    }



    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsModel post = data.get(position);
        Picasso.with(context)
                .load(post.getPhoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .resize(100, 100)
                .into(holder.photoNews);

        holder.title.setText(Html.fromHtml("<a href="+post.getUrl()+">"+post.getTitle()+"</a>"));
        holder.title.setMovementMethod(LinkMovementMethod.getInstance());
        holder.textNews.setText(post.getText());
        holder.dateNews.setText(post.getDate());
        holder.authorNews.setText(post.getAuthor());
    }

    @Override
    public int getItemCount() {

        if (data == null)
            return 0;
        return data.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView title;
        TextView textNews;
        TextView dateNews;
        TextView authorNews;
        ImageView photoNews;

        public NewsViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.titleNews);
            textNews = (TextView) itemView.findViewById(R.id.textNews);
            dateNews = (TextView) itemView.findViewById(R.id.dateNews);
            authorNews = (TextView) itemView.findViewById(R.id.authorNews);
            photoNews = (ImageView) itemView.findViewById(R.id.photoNews);
        }
    }
}
