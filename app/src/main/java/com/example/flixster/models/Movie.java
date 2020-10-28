package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class Movie {
    String posterPath;
    String title;
    String overView;
    double rating;
    int movieId;

    // constructor takes in a json object and construct a movie object
    public Movie(JSONObject jsonObject) throws JSONException {

        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");

    }
    //empty constructor by the parceler library
    public Movie() {}
    public static List<Movie> fromJSONArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i<movieJsonArray.length();i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }


    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w500/%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}