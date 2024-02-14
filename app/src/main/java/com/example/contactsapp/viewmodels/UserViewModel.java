package com.example.contactsapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactsapp.datasource.DataSource;
import com.example.contactsapp.models.Contact;
import com.example.contactsapp.models.User;

import java.util.List;

public class UserViewModel extends ViewModel{

    private DataSource dataSource;
    private MutableLiveData<User> user;

    public UserViewModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Boolean loginUser(User userToSave) {
        if (userToSave != null) {
            this.user = new MutableLiveData<>();
            User user = dataSource.loginUser(userToSave);
            if (userToSave != null) {
                this.user.setValue(user);
                return true;
            }
            return false;
        }
        return false;
    }

}
