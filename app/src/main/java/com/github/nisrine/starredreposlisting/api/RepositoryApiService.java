package com.github.nisrine.starredreposlisting.api;

import com.github.nisrine.starredreposlisting.model.RepositoryResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by nisrine on 19/01/2018.
 */

public interface RepositoryApiService {

   @GET("/search/repositories")
   Call<RepositoryResponse> getRepositoryList(@QueryMap(encoded = false)  Map<String,String> filter );



}
