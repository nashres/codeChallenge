package com.github.nisrine.starredreposlisting.utils;

/**
 * Created by nisrine on 2018-01-19.
 */

public class APIError {
    private int statusCode;
    private String message;

    public APIError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}
