package com.example.bookstore.logic.remote.service;

import com.example.bookstore.model.ResponseMovie;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

//Retrofit
public interface MovieApiService {
    @POST("api/v2/list_movies.json")
    Single<ResponseMovie> fetchMovies(@Body int pageNum);
}
