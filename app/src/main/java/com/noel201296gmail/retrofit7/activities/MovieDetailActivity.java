package com.noel201296gmail.retrofit7.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.noel201296gmail.retrofit7.R;
import com.noel201296gmail.retrofit7.fragments.MovieDetailFragment;
import com.noel201296gmail.retrofit7.model.Result;



public class MovieDetailActivity extends FragmentActivity {

    private static final String MovieParcel =
            "com.noel201296gmail.retrofit7.model.Result";

        RecyclerView recyclerView;






        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fragment);
            Intent intent = getIntent();
            Result films = intent.getParcelableExtra("movieDetails");
            FragmentManager fm  = getSupportFragmentManager();

            Fragment fragment = fm.findFragmentById(R.id.fragment_container);
            if (fragment == null) {
                fragment = MovieDetailFragment.newInstance(films);
                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }
        }
}
