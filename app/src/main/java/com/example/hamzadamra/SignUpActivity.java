package com.example.hamzadamra;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

import io.github.muddz.styleabletoast.StyleableToast;

public class SignUpActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    AppCompatButton signUpButton;
    EditText editTextTextEmailEnter, editTextTextPasswordEnter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        LayoutInflater inflater = getLayoutInflater();
        Toast toast = new Toast(getApplicationContext());
        final CustomProgressDialog dialog = new CustomProgressDialog(SignUpActivity.this);
        firebaseAuth = FirebaseAuth.getInstance();
        signUpButton = findViewById(R.id.button_signUp);
        editTextTextEmailEnter = findViewById(R.id.editTextTextEmailEnter);
        editTextTextPasswordEnter = findViewById(R.id.editTextTextPasswordEnter);
        signUpButton.setOnClickListener(v -> {
            dialog.cancel();
            String email = editTextTextEmailEnter.getText().toString();
            String password = editTextTextPasswordEnter.getText().toString();
            if (!email.isEmpty() && !password.isEmpty()) {
                dialog.show();
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        StyleableToast.makeText(SignUpActivity.this, "Successful",R.style.mytoast).show();
                        dialog.cancel();
                        Intent intent = new Intent(getBaseContext(),LoginActivity.class);
                        startActivity(intent);
                    } else{
                        dialog.show();
                        StyleableToast.makeText(SignUpActivity.this, Objects.requireNonNull(task.getException()).toString(),R.style.mytoast).show();
                        dialog.cancel();
                    }
                });
            } else {
                dialog.show();
                StyleableToast.makeText(SignUpActivity.this, "Please fill all fields",R.style.mytoast).show();
                dialog.cancel();
            }
        });
    }


}