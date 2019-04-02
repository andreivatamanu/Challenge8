package com.example.challenge8.interfaces;

import android.graphics.Movie;

import com.example.challenge8.retrofit.GenresResponse;
import com.example.challenge8.retrofit.MoviesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDbApi {

    @GET("discover/movie")
    Call<MoviesResponse> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("sort_by") String shortBy,
            @Query("page") int page
    );

    @GET("genre/movie/list")
    Call<GenresResponse> getAllGenres(
            @Query("api_key") String apiKey
    );



    @GET("movie/upcoming")
    Call<MoviesResponse> getUpcomingMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );

    @GET("discover/movie")
    Call<MoviesResponse> getNowMovies(
            @Query("api_key") String apiKey,
            @Query("primary_release_date.gte") String dateGte,
            @Query("primary_release_date.lte") String dateLte,
            @Query("page") int page
    );

    @GET("/discover/movie?primary_release_date.gte=2019-03-15&primary_release_date.lte=2019-03-26&api_key="+ TheMovieDbApiKey.API_KEY)
    Call<List<Movie>> getNowMovies();


}
