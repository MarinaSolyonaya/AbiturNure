package com.example.marina.abiturnure.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.marina.abiturnure.MainActivity;
import com.example.marina.abiturnure.R;
import com.example.marina.abiturnure.adapter.NewsListAdapter;
import com.example.marina.abiturnure.dto.NewsModel;
import com.example.marina.abiturnure.network.RestService;
import com.example.marina.abiturnure.network.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends AbstractTabFragment{

    private static final int LAYOUT = R.layout.fragment_news;
    List<NewsModel> news;
    private static RestService restService;
    private RecyclerView recyclerView;

    public  static NewsFragment getInstance(Context context){
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_news));
        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container,false);
       /*
       RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new NewsListAdapter(createMockData()));
        */
        restService = ServiceGenerator.getApi();
        news = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        NewsListAdapter adapter = new NewsListAdapter(context,news);
        recyclerView.setAdapter(adapter);

        restService.getNews().enqueue(new Callback<List<NewsModel>>() {
            @Override
            public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                news.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<NewsModel>> call, Throwable t) {
                Toast.makeText(context, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private List<NewsModel> createMockData() {
        List<NewsModel> data = new ArrayList<>();
        data.add(new NewsModel("Item 1"));
        data.add(new NewsModel("Item 2"));
        data.add(new NewsModel("Item 3"));
        data.add(new NewsModel("Item 4"));
        data.add(new NewsModel("Item 5"));
        data.add(new NewsModel("Item 6"));
        return data;
    }
}
