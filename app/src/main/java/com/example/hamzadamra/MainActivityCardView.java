package com.example.hamzadamra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityCardView extends AppCompatActivity {
    Button buttonInsert, buttonView;
    EditText edtName, edtAge, edtEmail;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_card_view);
        buttonInsert = findViewById(R.id.btnInsert);
        buttonView = findViewById(R.id.btnView);
        edtName = findViewById(R.id.edtname);
        edtAge = findViewById(R.id.edtage);
        edtEmail = findViewById(R.id.edtemail);


        buttonInsert.setOnClickListener(view -> InsertData());
        buttonView.setOnClickListener(view -> {
            startActivity(new Intent(MainActivityCardView.this, Userlist.class));
            finish();
        });


    }


    private void InsertData() {


        String userName = edtName.getText().toString();
        String Email = edtEmail.getText().toString();
        String Age = edtAge.getText().toString();
        String id = databaseReference.push().getKey();
        User user = new User(Email, Age, userName);

        assert id != null;
        databaseReference.child("users").child(id).setValue(user).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(MainActivityCardView.this, "User Details Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}