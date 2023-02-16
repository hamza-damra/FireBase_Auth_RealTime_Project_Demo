package com.example.hamzadamra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.github.muddz.styleabletoast.StyleableToast;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText editTextLoginEmail, editTextPassword;
    AppCompatButton button_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final CustomProgressDialog dialog = new CustomProgressDialog(LoginActivity.this);
        editTextLoginEmail = findViewById(R.id.editTextTextEmail);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        button_login = findViewById(R.id.button_login);
        mAuth = FirebaseAuth.getInstance();
        dialog.cancel();

        Intent intent = new Intent(getBaseContext(),MainActivityCardView.class);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edtLoginEmail = editTextLoginEmail.getText().toString();
                String edtLoginPassword = editTextPassword.getText().toString();
                mAuth.signInWithEmailAndPassword(edtLoginEmail,edtLoginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            dialog.show();
                            startActivity(intent);
                            dialog.cancel();
                        }else {
                            dialog.show();
                            StyleableToast.makeText(LoginActivity.this, "Please check your email and password", R.style.mytoast).show();
                            dialog.cancel();
                        }
                    }
                });
            }
        });

    }
}