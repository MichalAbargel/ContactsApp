package com.example.contactsapp.viewmodels;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.contactsapp.datasource.DaoContacts;
import com.example.contactsapp.datasource.DataSource;

public class ContactsViewModelFactory implements ViewModelProvider.Factory {

    private DataSource dataSource;

    public ContactsViewModelFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ContactViewModel.class)) {
            return (T) new ContactViewModel(dataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
