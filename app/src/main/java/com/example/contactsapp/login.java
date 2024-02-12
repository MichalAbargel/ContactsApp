package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView userName = findViewById(R.id.userName);
                String userNameText = userName.getText().toString();

                TextView password = findViewById(R.id.userName);
                String passwordText = password.getText().toString();

                if(! userNameText.isEmpty() && ! passwordText.isEmpty()){
                    // TODO LOGIN
                    //open userDetails
                    // move to new activity to add contact
                    Intent intent = new Intent(login.this,userDetails.class);
                    intent.putExtra("isEditMode",false);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Missing Details...", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}