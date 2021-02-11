package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
   private  RecyclerView recyclerView;
   private  Adaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.main_recyclerView);



        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsApi newsApi=retrofit.create(NewsApi.class);

   newsApi.getNewsWithParametars("eg","sports").enqueue(new Callback<NewsResponse>() {
       @Override
       public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {

           if(response.isSuccessful()&&response.body()!=null&&response.body().getStatus().equals("ok"))
           {
               NewsResponse newsResponse=response.body();
               Log.i(TAG, "onResponse:  " + newsResponse.getArticles().size());
              adaptor=new Adaptor(newsResponse.getArticles(),MainActivity.this);
             //  recyclerView.setAdapter(adaptor);
               LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
               linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
               recyclerView.setLayoutManager(linearLayoutManager);
               recyclerView.setAdapter( adaptor );

           }
       }

       @Override
       public void onFailure(Call<NewsResponse> call, Throwable t) {

           Log.i(TAG, "onResponse: "+t.getLocalizedMessage());



       }
   });


    }
}