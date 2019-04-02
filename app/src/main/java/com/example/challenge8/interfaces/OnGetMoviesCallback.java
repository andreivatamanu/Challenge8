package com.example.challenge8.interfaces;

import android.graphics.Movie;

import java.util.List;

public interface OnGetMoviesCallback {

    void onSuccess(List<Movie> movies);
    void onError();
}
