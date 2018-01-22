package com.github.nisrine.starredreposlisting.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nisrine on 19/01/2018.
 */

public class RepositoryResponse {

    @SerializedName("items")
    private List<Repository> items;
    public List<Repository> getItems() {
        return items;
    }

}
