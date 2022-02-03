package com.example.ciberseguridadparatodos.DbUtils;

//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.Query;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void createUser(User user);

    @Query("SELECT * FROM user WHERE username LIKE :strusername")
    User getUserByUsername(String strusername);
}
