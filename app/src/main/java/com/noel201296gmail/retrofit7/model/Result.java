package com.noel201296gmail.retrofit7.model;

/**
 * Created by OMOSEFE NOEL OBASEKI on 22/02/2018.
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Result implements Parcelable {

        public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";

        @SerializedName("vote_count")
        @Expose
        private Integer voteCount;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("video")
        @Expose
        private Boolean video;
        @SerializedName("vote_average")
        @Expose
        private Double voteAverage;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("popularity")
        @Expose
        private Double popularity;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("genre_ids")
        @Expose
        private JsonArray genreIds = null;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;



        public Result(Integer voteCount, Integer id, Boolean video,Double voteAverage ,
                      String title ,Double popularity,String posterPath, String originalLanguage,
                      String originalTitle, JsonArray genreIds,String backdropPath,Boolean adult, String overview,String releaseDate){

            this.voteCount = voteCount;
            this.id = id;
            this.video = video;
            this.voteAverage = voteAverage;
            this.title = title;
            this.popularity = popularity;
            this.posterPath = posterPath;
            this.originalLanguage = originalLanguage;
            this.originalTitle = originalTitle;
            this.genreIds = genreIds;
            this.backdropPath = backdropPath;
            this.adult = adult;
            this.overview = overview;
            this.releaseDate = releaseDate;
        }

        private  Result(Parcel source) {
            this.voteCount = source.readInt();
            this.id = source.readInt();
            this.video = source.readByte() != 0;
            this.voteAverage = source.readDouble();
            this.title = source.readString();
            this.popularity = source.readDouble();
            this.posterPath = source.readString();
            this.originalLanguage = source.readString();
            this.originalTitle = source.readString();
            this.backdropPath = source.readString();
            this.adult = source.readByte() != 0;
            this.overview = source.readString();
            this.releaseDate = source.readString();
        }

        public Integer getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getVideo() {
            return video;
        }

        public void setVideo(Boolean video) {
            this.video = video;
        }

        public Double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public String getPosterPath() {
            return TMDB_IMAGE_PATH + posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public JsonArray getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(JsonArray genreIds) {
            this.genreIds = genreIds;
        }

        public String getBackdropPath() {
            return TMDB_IMAGE_PATH +backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public Boolean getAdult() {
            return adult;
        }

        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }


        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
            public Result createFromParcel(Parcel source) {
                Result movie = new Result(source);
                return movie;
            }

            public Result[] newArray(int size) {
                return new Result[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int i) {
            dest.writeInt(voteCount);
            dest.writeInt(id);
            dest.writeByte((byte) (video ? 1 : 0));
            dest.writeDouble(voteAverage);
            dest.writeString(title);
            dest.writeDouble(popularity);
            dest.writeString(posterPath);
            dest.writeString(originalLanguage);
            dest.writeString(originalTitle);
            dest.writeString(backdropPath);
            dest.writeByte((byte) (adult ? 1 : 0));
            dest.writeString(overview);
            dest.writeString(releaseDate);

        }
    }

