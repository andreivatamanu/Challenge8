package com.example.challenge8.retrofit;

import android.support.annotation.NonNull;

import com.example.challenge8.BuildConfig;
import com.example.challenge8.interfaces.OnGetGenresCallback;
import com.example.challenge8.interfaces.OnGetMoviesCallback;
import com.example.challenge8.interfaces.TheMovieDbApi;
import com.example.challenge8.interfaces.TheMovieDbApiKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRepository {

    private static MoviesRepository sRepository;

    private TheMovieDbApi mTheMovieDbApi;

    public MoviesRepository(TheMovieDbApi api) {
        this.mTheMovieDbApi = api;
    }

    public static MoviesRepository getInstance() {
        if (sRepository == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_MOVIES_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            sRepository = new MoviesRepository(retrofit.create(TheMovieDbApi.class));
        }

        return sRepository;
    }

    public void getTopRatedMovies(final OnGetMoviesCallback callback) {
        mTheMovieDbApi.getTopRatedMovies(TheMovieDbApiKey.API_KEY, "vote_count.desc", 1).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call,
                                   @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getMovies() != null) {
                        callback.onSuccess(moviesResponse.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getUpcomingMovies(final OnGetMoviesCallback callback) {
        mTheMovieDbApi.getUpcomingMovies(TheMovieDbApiKey.API_KEY,1).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call,
                                   @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getMovies() != null) {
                        callback.onSuccess(moviesResponse.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getNowMovies(final OnGetMoviesCallback callback) {
        mTheMovieDbApi.getNowMovies(TheMovieDbApiKey.API_KEY,"2019-03-15","2019-03-26",1).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call,
                                   @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getMovies() != null) {
                        callback.onSuccess(moviesResponse.getMovies());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getAllGenres(final OnGetGenresCallback callback) {

        mTheMovieDbApi.getAllGenres(TheMovieDbApiKey.API_KEY).enqueue(new Callback<GenresResponse>() {
            @Override
            public void onResponse(Call<GenresResponse> call, Response<GenresResponse> response) {
                if (response.isSuccessful()) {
                    GenresResponse genresResponse = response.body();
                    if (genresResponse != null && genresResponse.getGenres() != null) {
                        callback.onSuccess(genresResponse.getGenres());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<GenresResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
