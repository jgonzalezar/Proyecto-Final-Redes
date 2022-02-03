package com.example.ciberseguridadparatodos;

import android.app.Application;
//import android.arch.persistence.room.Room;

import androidx.room.Room;

import com.example.ciberseguridadparatodos.DbUtils.LocalDB;

public class ciberseguridadparatodos extends Application {
    private static ciberseguridadparatodos mInstance;
    private LocalDB dbInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        dbInstance = Room.databaseBuilder(getApplicationContext(), LocalDB.class, "LocalDB").build();
    }

    public static ciberseguridadparatodos getmInstance(){
        return mInstance;
    }

    public LocalDB getDbInstance (){
        return dbInstance;
    }
}
