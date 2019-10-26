package com.example.bookstore.logic;

import com.example.bookstore.base.BasePresenter;
import com.example.bookstore.logic.local.LocalDataSourceImpl;
import com.example.bookstore.logic.remote.RemoteDataSourceImpl;
import com.example.bookstore.model.Movie;

import java.util.List;

import io.reactivex.Single;

public class RepositoryImpl <T> implements Repository  {
    BasePresenter<T> presenter;
    DataSource localDataSource;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;

        localDataSource = new LocalDataSourceImpl();
        localDataSource.setRepository(this);

        remoteDataSource = new RemoteDataSourceImpl();
        remoteDataSource.setRepository(this);
    }

    @Override
    public Single<List<Movie>> fetchMovies(int pageNum) {
        return remoteDataSource.fetchMovies(pageNum);
    }
}
