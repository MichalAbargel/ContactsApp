package com.example.contactsapp.datasource;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.contactsapp.models.Contact;
import com.example.contactsapp.models.User;

@Database(entities = {User.class, Contact.class}, version = 1)
public abstract class ContactsDatabase extends RoomDatabase {

     private static ContactsDatabase instance;

     public abstract DaoUser daoUser();
     public abstract DaoContacts daoContacts();

     public static synchronized ContactsDatabase getInstance(Context context) {
          if (instance == null) {
               instance = Room.databaseBuilder(context.getApplicationContext(),
                               ContactsDatabase.class, "contactsDatabase")
                       .fallbackToDestructiveMigration()
                       .build();
          }
          return instance;
     }

}
