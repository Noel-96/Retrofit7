package com.noel201296gmail.retrofit7.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.noel201296gmail.retrofit7.R;
import com.noel201296gmail.retrofit7.model.Result;
import com.squareup.picasso.Picasso;

import java.util.UUID;

public class MovieDetailFragment extends Fragment {

    private static final String ARG_MOVIE_BUNDLE = "MovieBundle";

    ImageView mIvBackDrop;
     private  Result mMovie;


    public static MovieDetailFragment newInstance(Result movie) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_MOVIE_BUNDLE, movie);
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_movie_detail, container, false);
        mIvBackDrop = (ImageView) view.findViewById(R.id.iv_backdrop);
        mMovie =  getArguments().getParcelable(ARG_MOVIE_BUNDLE);
        Picasso.with(getActivity())
                  .load(mMovie.getPosterPath())
                  .placeholder(R.color.colorAccent)
                  .into(mIvBackDrop);

        return view;
    }

}
