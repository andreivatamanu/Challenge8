package com.example.challenge8.reciclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.challenge8.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;
    private RatingBar mRatingBar;
    private TextView mTextViewTitle;
    private TextView mTextViewVoteCount;
    private TextView mTextViewGenres;
    private TextView mTextViewReleaseDate;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView_itemMovie);
        mTextViewTitle = itemView.findViewById(R.id.textView_titleMovie);
        mTextViewVoteCount = itemView.findViewById(R.id.textView_voteCount);
        mTextViewGenres = itemView.findViewById(R.id.textView_genres);
        mTextViewReleaseDate = itemView.findViewById(R.id.textView_releaseDate);
        mRatingBar = itemView.findViewById(R.id.ratingBar);
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView imageView) {
        mImageView = imageView;
    }

    public RatingBar getRatingBar() {
        return mRatingBar;
    }

    public void setRatingBar(RatingBar ratingBar) {
        mRatingBar = ratingBar;
    }

    public TextView getTextViewTitle() {
        return mTextViewTitle;
    }

    public void setTextViewTitle(TextView textViewTitle) {
        mTextViewTitle = textViewTitle;
    }

    public TextView getTextViewVoteCount() {
        return mTextViewVoteCount;
    }

    public void setTextViewVoteCount(TextView textViewVoteCount) {
        mTextViewVoteCount = textViewVoteCount;
    }

    public TextView getTextViewGenres() {
        return mTextViewGenres;
    }

    public void setTextViewGenres(TextView textViewGenres) {
        mTextViewGenres = textViewGenres;
    }

    public TextView getTextViewReleaseDate() {
        return mTextViewReleaseDate;
    }

    public void setTextViewReleaseDate(TextView textViewReleaseDate) {
        mTextViewReleaseDate = textViewReleaseDate;
    }
}
