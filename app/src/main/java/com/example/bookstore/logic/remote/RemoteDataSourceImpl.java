package com.example.bookstore.logic.remote;

import android.util.Log;

import com.example.bookstore.logic.DataSource;
import com.example.bookstore.logic.Repository;
import com.example.bookstore.logic.remote.service.MovieApiService;
import com.example.bookstore.model.Movie;
import com.example.bookstore.model.ResponseMovie;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;

public class RemoteDataSourceImpl implements DataSource {
    final static private String _TAG = "Remote";

    Repository repository;
    Retrofit retrofit;

    @Override
    public void setRepository(Repository repository) {

    }

    @Override
    public Single<List<Movie>> fetchMovies(int pageNum) {
        MovieApiService movieApiService = NetRetrofit.getInstance().getRetrofit()
                .create(MovieApiService.class);

        return movieApiService.fetchMovies(pageNum)
                .map(new Function<ResponseMovie, List<Movie>>() {
                    @Override
                    public List<Movie> apply(ResponseMovie responseMovie) throws Exception {
                        Log.d(_TAG, "responseMovie " + responseMovie.toString());
                        return responseMovie.getData().getMovies();
                    }
                });

    }
}
