package com.example.contactsapp.datasource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.contactsapp.models.User;

import java.util.List;

@Dao
public interface DaoUser {
    @Insert
    void insertUser(User data);

    @Query("SELECT * FROM users")
    List<User> getAllUser();
}
