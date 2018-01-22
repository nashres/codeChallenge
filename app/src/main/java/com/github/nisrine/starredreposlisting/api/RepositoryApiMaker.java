package com.github.nisrine.starredreposlisting.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nisrine on 2018-01-19.
 */

public class RepositoryApiMaker {

    public static final String BASE_URL = "https://api.github.com";

    private Retrofit retrofit;

    public RepositoryApiMaker() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RepositoryApiService getService() {

        return retrofit.create(RepositoryApiService.class);
    }
}
