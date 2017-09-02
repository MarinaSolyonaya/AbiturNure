package com.example.marina.abiturnure.network;

import com.example.marina.abiturnure.dto.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Marina on 02.09.2017.
 */

public interface RestService {

    @GET(".")
    Call<List<NewsModel>> getNews();
}
