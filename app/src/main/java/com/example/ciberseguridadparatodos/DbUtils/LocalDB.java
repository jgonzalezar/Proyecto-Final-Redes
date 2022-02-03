package com.example.ciberseguridadparatodos.DbUtils;

//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class LocalDB extends RoomDatabase {
    public abstract UserDao userDao();
}
