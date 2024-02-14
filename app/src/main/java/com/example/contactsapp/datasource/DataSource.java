package com.example.contactsapp.datasource;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.contactsapp.models.Contact;
import com.example.contactsapp.models.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSource {

    private static DataSource instance;
    private DaoUser daoUser;
    private DaoContacts daoContacts;

    private DataSource(DaoUser daoUser, DaoContacts daoContacts) {
        this.daoUser = daoUser;
        this.daoContacts = daoContacts;
    }

    public static synchronized DataSource getInstance(DaoUser daoUser, DaoContacts daoContacts) {
        if (instance == null) {
            instance = new DataSource(daoUser, daoContacts);
        }
        return instance;
    }

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            throw new IllegalStateException("DataSource has not been initialized. Call getInstance(DaoUser, DaoContacts) first.");
        }
        return instance;
    }

    public User loginUser(User userToSave) {
        MutableLiveData<User> data = new MutableLiveData<>();
        return data.getValue();
    }

    public LiveData<List<Contact>> getAllContacts() {
        return daoContacts.getContacts();
    }

    public void addContact(Contact data) {
        new Thread(() -> daoContacts.insertContact(data)).start();
    }
}
