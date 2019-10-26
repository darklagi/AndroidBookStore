package com.example.bookstore.logic.local;

import com.example.bookstore.logic.DataSource;
import com.example.bookstore.logic.Repository;
import com.example.bookstore.model.Movie;

import java.util.List;

import io.reactivex.Single;

public class LocalDataSourceImpl implements DataSource {
    Repository repository;
    AppDataBase appDatabase;

    public LocalDataSourceImpl() {
        try {
            appDatabase = AppDataBaseProvider.getINSTANCE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<Movie>> fetchMovies(int pageNum) {
        return null;
    }
}
