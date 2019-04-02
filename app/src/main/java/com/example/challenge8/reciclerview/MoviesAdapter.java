package com.example.challenge8.reciclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.challenge8.R;
import com.example.challenge8.TabbedActivity;

import java.text.DecimalFormat;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> mMovieList;
    private Context mContext;


    public MoviesAdapter(List<Movie> movies, Context context) {
        this.mMovieList = movies;
        mContext = context;
    }

    public MoviesAdapter(List<android.graphics.Movie> movies, FragmentActivity fragmentActivity) {
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie,
                viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {

        Movie currentMovie = mMovieList.get(i);
        movieViewHolder.getTextViewTitle().setText(currentMovie.getTitle());
        movieViewHolder.getRatingBar().setRating(currentMovie.getVoteAverage());
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0");
        movieViewHolder.getTextViewVoteCount().setText("Votes: " + String.valueOf(df2.format(currentMovie.getVoteCount())));

        StringBuilder stringBuilder = new StringBuilder("Genres: ");
        int[] list = currentMovie.getGenreIds();

        for (int j = 0; j < list.length; j++) {

            for (Genre k : TabbedActivity.getGenresList()) {
                if (list[j] == k.getId()) {
                    stringBuilder.append(k.getName());
                }
            }

            if (j != list.length - 1) {
                stringBuilder.append(", ");
            }

        }

        movieViewHolder.getTextViewGenres().setText(stringBuilder);

        movieViewHolder.getTextViewReleaseDate().setText("Release date: " + currentMovie.getReleaseDate());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.no_picture)
                .error(R.drawable.no_picture)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .dontAnimate()
                .dontTransform();

        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w342" + currentMovie.getPosterPath())
                .apply(options)
                .into(movieViewHolder.getImageView());


    }


    @Override
    public int getItemCount() {
        return mMovieList.size();
    }


}

