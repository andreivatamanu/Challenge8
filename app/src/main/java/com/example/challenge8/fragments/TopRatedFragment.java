package com.example.challenge8.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.challenge8.R;
import com.example.challenge8.interfaces.OnGetMoviesCallback;
import com.example.challenge8.reciclerview.Movie;
import com.example.challenge8.reciclerview.MoviesAdapter;
import com.example.challenge8.retrofit.MoviesRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedFragment extends Fragment {

    private MoviesRepository mMoviesRepository;
    private RecyclerView mRecyclerViewMovies;
    private MoviesAdapter mAdapter;
    private FragmentActivity fragmentActivity;
    private List<Movie> mMovieList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_top_rated, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        fragmentActivity = getActivity();
        mMoviesRepository = MoviesRepository.getInstance();
        mRecyclerViewMovies = view.findViewById(R.id.recyclerview_movies);
        mRecyclerViewMovies.setLayoutManager(new LinearLayoutManager(fragmentActivity));
        mMovieList = new ArrayList<>();
        mAdapter = new MoviesAdapter(mMovieList,fragmentActivity);
        mRecyclerViewMovies.setAdapter(mAdapter);
        mMoviesRepository.getTopRatedMovies(new OnGetMoviesCallback() {

            @Override
            public void onSuccess(List<android.graphics.Movie> movies) {
                mAdapter = new MoviesAdapter(movies,fragmentActivity);
                mRecyclerViewMovies.setAdapter(mAdapter);

            }

            @Override
            public void onError() {
                Toast.makeText(fragmentActivity, "Check internet connection", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
