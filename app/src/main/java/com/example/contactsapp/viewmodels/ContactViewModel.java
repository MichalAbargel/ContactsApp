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
    private MutableLiveData<List<Contact>> contacts;

    public ContactViewModel() {
        dataSource = new DataSource(new RetrofitClient());
    }

    public Boolean loginUser(User userToSave){
        if(userToSave != null && this.user == null){
            this.user = new MutableLiveData<>();
            User user = dataSource.loginUser(userToSave);
            if(userToSave != null){
                this.user.setValue(user);
                return true;
            }
            return false;
        }
        return false;
    }

    public MutableLiveData<List<Contact>> getContacts() {
        if (contacts == null) {
            contacts = new MutableLiveData<>();
            // TODO replace with this.user.id
            // List<Contact> data = dataSource.getContacts("123");
            List<Contact> data = loadContacts();
            contacts.setValue(data);
        }
        return contacts;
    }

    private List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("John Doe"));
        contacts.add(new Contact("Jane Smith"));
        contacts.add(new Contact("Alice Johnson"));
        return contacts;
    }


    public void deleteContact(int position) {
        List<Contact> currentContacts = contacts.getValue();

        if (currentContacts != null && position >= 0 && position < currentContacts.size()) {
            currentContacts.remove(position);
            contacts.setValue(currentContacts);

            // TODO Update the database by deleting the contact
        }
    }

    public void editContact(int position) {
    }
}
