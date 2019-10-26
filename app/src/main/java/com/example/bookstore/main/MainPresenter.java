package com.example.bookstore.main;

import android.util.Log;

import com.example.bookstore.base.BasePresenterImpl;
import com.example.bookstore.logic.Repository;
import com.example.bookstore.logic.RepositoryImpl;
import com.example.bookstore.model.Movie;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter
        extends BasePresenterImpl<MainContract.View>
        implements MainContract.Presenter {
    Repository repository;

    MainPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void fetchMovies(int pageNum) {
        Disposable disposable = this.repository.fetchMovies(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Movie>>() {
                    @Override
                    public void accept(List<Movie> movies) throws Exception {
                        Log.d("SUCCESS", "onSuccess Movies = " + movies.toString());
                        view.fetchMoviesDone(movies);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        bag.add(disposable);
    }
}

