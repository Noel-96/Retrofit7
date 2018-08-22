package com.noel201296gmail.retrofit7.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.noel201296gmail.retrofit7.R;
import com.noel201296gmail.retrofit7.activities.MovieDetailActivity;
import com.noel201296gmail.retrofit7.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by OMOSEFE NOEL OBASEKI on 22/02/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Result> movies;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView movieTitle;
        TextView data;
        TextView rating;
        ImageView pic;


        public ViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            data = (TextView) itemView.findViewById(R.id.subtitle);
            rating = (TextView) itemView.findViewById(R.id.rating);
            pic = (ImageView) itemView.findViewById(R.id.image_view_pic);
        }


        @Override
        public void onClick(View view) {
            int itemPosition = getAdapterPosition();
            Result movie = movies.get(itemPosition);
            Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
            intent.putExtra("movieDetails",movie);
            view.getContext().startActivity(intent);
        }
    }



    public MovieAdapter(List<Result> movies, Context context){
        this.movies = movies;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        String PictureString = movies.get(position).getPosterPath();
        Picasso.with(context)
                .load(PictureString)
                .placeholder(R.color.colorAccent)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
