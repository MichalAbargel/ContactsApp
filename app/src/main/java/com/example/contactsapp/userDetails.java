package com.example.contactsapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.contactsapp.adapters.ContactAdapter;
import com.example.contactsapp.datasource.DataSource;
import com.example.contactsapp.models.Contact;
import com.example.contactsapp.viewmodels.ContactViewModel;
import com.example.contactsapp.viewmodels.ContactsViewModelFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class userDetails extends AppCompatActivity {
    private ContactViewModel viewModel;
    private FloatingActionButton fab;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        fab = findViewById(R.id.fab);

        DataSource dataSource = DataSource.getInstance();
        viewModel = new ViewModelProvider(this, new ContactsViewModelFactory(dataSource)).get(ContactViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ContactAdapter adapter = new ContactAdapter();
        // Set the listener for item click events
        adapter.setOnItemClickListener(new ContactAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {
                Toast.makeText(getApplicationContext(), "Edit", Toast.LENGTH_LONG).show();
                viewModel.editContact(position);
            }

            @Override
            public void onDeleteClick(int position) {
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_LONG).show();
                // call viewModel
                viewModel.deleteContact(position);
            }
        });

        recyclerView.setAdapter(adapter);

        viewModel.getContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                adapter.setContacts(contacts);
            }
        });

        // add listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // move to new activity to add contact
                Intent intent = new Intent(userDetails.this,AddNewContact.class);
                intent.putExtra("isEditMode",false);
                startActivity(intent);
            }
        });
    }

}