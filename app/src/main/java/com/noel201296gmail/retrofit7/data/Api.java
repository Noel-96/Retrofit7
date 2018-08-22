package com.noel201296gmail.retrofit7.data;

/**
 * Created by OMOSEFE NOEL OBASEKI on 22/02/2018.
 */

import com.noel201296gmail.retrofit7.model.ServerTime;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by OMOSEFE NOEL OBASEKI on 20/02/2018.
 */

public interface Api {

    @GET("movie/popular?api_key=b7a6da7f6401f0bad741c3d311b15234")
public Call<ServerTime> getServerTime();
}