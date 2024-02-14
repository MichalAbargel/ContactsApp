package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contactsapp.viewmodels.ContactViewModel;

public class AddNewContact extends AppCompatActivity {
    private ContactViewModel viewModel;
    private Button saveContactBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        saveContactBtn = findViewById(R.id.save_contact_btn);

        saveContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView name = findViewById(R.id.nameEt);
                String nameText = name.getText().toString();

                TextView phone = findViewById(R.id.phoneEt);
                String phoneText = phone.getText().toString();

                TextView email = findViewById(R.id.emailEt);
                String emailText = email.getText().toString();

                if (!nameText.isEmpty() && !phoneText.isEmpty() && !emailText.isEmpty()) {
                    // TODO Save new Contact
                    //show successes message, return back
                    Toast.makeText(getApplicationContext(), "Saving success", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Missing Details...", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}