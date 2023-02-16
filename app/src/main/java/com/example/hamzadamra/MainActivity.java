package com.example.hamzadamra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton button_signin, button_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_signin = findViewById(R.id.button_login);
        button_signup = findViewById(R.id.button_signup);
        button_signin.setOnClickListener(this);
        button_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_login)
        {
            Intent signInActivity = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(signInActivity);
        }else {
            Intent signUpActivity = new Intent(MainActivity.this, SignUpActivity.class);

            startActivity(signUpActivity);
        }
    }
}