package com.example.bookstore.logic.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bookstore.model.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract MovieDao getMovieDao();
}
