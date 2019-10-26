package com.example.bookstore.main;

import com.example.bookstore.base.BasePresenter;
import com.example.bookstore.base.BaseView;
import com.example.bookstore.model.Movie;

import java.util.List;

public class MainContract {
    public interface View extends BaseView {
        void fetchMoviesDone(List<Movie> movies);
    }

    public interface Presenter extends BasePresenter<View> {
        void fetchMovies(int pageNum);
    }
}
