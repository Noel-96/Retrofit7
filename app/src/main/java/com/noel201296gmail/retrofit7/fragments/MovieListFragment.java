package com.noel201296gmail.retrofit7.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.noel201296gmail.retrofit7.R;
import com.noel201296gmail.retrofit7.adapter.MovieAdapter;
import com.noel201296gmail.retrofit7.data.Api;
import com.noel201296gmail.retrofit7.model.Result;
import com.noel201296gmail.retrofit7.model.ServerTime;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  MovieListFragment  extends Fragment {

    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_movie_list, container, false);
        recyclerView =  view.findViewById(R.id.movie_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetchTime();
        return view;
    }

    void fetchTime() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<ServerTime> serverTimeCall = api.getServerTime();
        serverTimeCall.enqueue(new Callback<ServerTime>() {
            @Override
            public void onResponse(Call<ServerTime> call, Response<ServerTime> response) {
                if (response.isSuccessful()) {
                    ServerTime serverTime = response.body();
                    List<Result> movies = response.body().getResults();
                    recyclerView.setAdapter(new MovieAdapter(movies ,getActivity().getApplicationContext()));


                } else{
                    Log.v("response error", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<ServerTime> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Error while fetching time", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

