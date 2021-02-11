package com.example.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
@GET("v2/top-headlines?country=eg&category=business&apiKey=5deda0267f2249a78a48ea54974074ea&5deda0267f2249a78a48ea54974074ea=5deda0267f2249a78a48ea54974074ea")
    Call<NewsResponse>getNews();



    @GET("v2/top-headlines?apiKey=5deda0267f2249a78a48ea54974074ea&5deda0267f2249a78a48ea54974074ea=5deda0267f2249a78a48ea54974074ea")
Call<NewsResponse> getNewsWithParametars(@Query("country") String country,@Query("category") String category );



}






