package com.example.bookstore.logic.local;

import android.content.Context;

import androidx.room.Room;

public class AppDataBaseProvider {

    private volatile static AppDataBase INSTANCE = null;

    private AppDataBaseProvider(){}

    // LocalDataSourceImpl
    public static AppDataBase getINSTANCE() throws Exception {
        if(INSTANCE == null) {
            throw new Exception("INSTANCE MUST BE NOT NULL");
        }
        return INSTANCE;
    }

    // Application
    public static AppDataBase getINSTANCE(Context context) {

        if(INSTANCE == null) {
            synchronized (AppDataBase.class) {
                INSTANCE = Room.databaseBuilder(context,
                        AppDataBase.class, "db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }

        return INSTANCE;
    }

}
