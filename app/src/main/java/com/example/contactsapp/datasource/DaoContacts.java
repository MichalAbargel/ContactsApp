package com.example.contactsapp.datasource;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.contactsapp.models.Contact;
import com.example.contactsapp.models.User;

import java.util.List;


@Dao
public interface DaoContacts {

    @Insert
    void insertContact(Contact data);

//    @Query("SELECT * FROM contacts WHERE userid = :id")
//    LiveData<List<Contact>> getAllContacts(Long id);

    @Query("SELECT * FROM contacts")
    LiveData<List<Contact>> getContacts();

}
