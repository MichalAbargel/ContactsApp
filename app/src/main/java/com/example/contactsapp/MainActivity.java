package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.contactsapp.datasource.ContactsDatabase;
import com.example.contactsapp.datasource.DaoContacts;
import com.example.contactsapp.datasource.DaoUser;
import com.example.contactsapp.datasource.DataSource;
import com.example.contactsapp.models.User;
import com.example.contactsapp.viewmodels.ContactViewModel;
import com.example.contactsapp.viewmodels.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private ContactViewModel viewModel;

    //view
    private Button signIn;
    private Button login;
    private DataSource dataSource;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DB
        DaoContacts daoContacts = ContactsDatabase.getInstance(getApplicationContext()).daoContacts();
        DaoUser daoUser = ContactsDatabase.getInstance(getApplicationContext()).daoUser();
        this.dataSource = DataSource.getInstance(daoUser, daoContacts);

        //initialization
        signIn = findViewById(R.id.signup_button);
        login = findViewById(R.id.login_button);

        // Check if the user is logged in
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String username = prefs.getString("username", null);
        String password = prefs.getString("password", null);

//        if(username != null && password != null) {
//            userViewModel = new UserViewModel(this.dataSource);
//            boolean success = userViewModel.loginUser(new User(username, password));
//            if (success) {
//                Intent intent = new Intent(MainActivity.this, userDetails.class);
//                intent.putExtra("isEditMode", false);
//                startActivity(intent);
//            }
//        } else {
//            // User is not logged in
//            Intent intent = new Intent(MainActivity.this, login.class);
//            startActivity(intent);
//        }

        // TODO
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // TODO
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // move to new activity to add contact
                Intent intent = new Intent(MainActivity.this,login.class);
                intent.putExtra("isEditMode",false);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences =
                getApplicationContext().getSharedPreferences("ContactsPrefs", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();  // Clear all key-value pairs
        editor.apply();  // Apply the changes
    }
}