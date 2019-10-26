package com.example.bookstore.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.base.BaseActivity;
import com.example.bookstore.model.Movie;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {

    public MainContract.Presenter setPresenter() {
        return new MainPresenter();
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    List<Movie> gridMovies = new ArrayList<>();
    MainAdapter adapter;

    int startPageNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.fetchMovies(startPageNum);

        initRecyclerView();
    }

    public void initRecyclerView(){
        adapter = new MainAdapter(gridMovies, mPresenter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fetchMoviesDone(List<Movie> movies) {
        progressBar.setVisibility(View.GONE);
        gridMovies.addAll(movies);
        adapter.notifyDataSetChanged();

        mPresenter.fetchMovies(startPageNum + 1);
    }
}
