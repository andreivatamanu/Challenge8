package com.example.challenge8.interfaces;

import com.example.challenge8.reciclerview.Genre;

import java.util.List;

public interface OnGetGenresCallback {

    void onSuccess(List<Genre> genres);
    void onError();
}
