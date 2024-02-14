package com.example.contactsapp.viewmodels;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactsapp.datasource.DataSource;
import com.example.contactsapp.datasource.RetrofitClient;
import com.example.contactsapp.models.Contact;
import com.example.contactsapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class ContactViewModel extends ViewModel {

    private DataSource dataSource;
    private MutableLiveData<User> user;
    private LiveData<List<Contact>> contacts;

    public ContactViewModel(DataSource dataSource) {
        this.dataSource = dataSource;
        this.contacts = dataSource.getAllContacts();
    }

    public LiveData<List<Contact>> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact){
        if(contact != null){
            dataSource.addContact(contact);
        }
    }

    public void deleteContact(int position) {
        List<Contact> currentContacts = contacts.getValue();

        if (currentContacts != null && position >= 0 && position < currentContacts.size()) {
            currentContacts.remove(position);
//            contacts.setValue(currentContacts);

            // TODO Update the database by deleting the contact
        }
    }

    public void editContact(int position) {
    }
}
