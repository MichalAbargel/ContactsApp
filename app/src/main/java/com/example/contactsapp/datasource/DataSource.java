package com.example.contactsapp.datasource;

import androidx.lifecycle.MutableLiveData;

import com.example.contactsapp.models.Contact;
import com.example.contactsapp.models.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSource {
    final RetrofitClient retrofitClient;

    public DataSource(RetrofitClient retrofitClient) {
        this.retrofitClient = retrofitClient;
    }
    public User loginUser(User userToSave){

        MutableLiveData<User> data =  new MutableLiveData<>();
        return data.getValue();
    }

    public List<Contact> getContacts(String id) {

        MutableLiveData<List<Contact>> data = new MutableLiveData<>();
        return data.getValue();
    }


}
