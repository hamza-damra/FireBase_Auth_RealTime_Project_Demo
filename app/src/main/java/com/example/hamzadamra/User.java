package com.example.hamzadamra;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private String email;
    private String age;
    private String name;

    public User(){}

    public User(String email, String age, String name) {
        this.email = email;
        this.age = age;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
