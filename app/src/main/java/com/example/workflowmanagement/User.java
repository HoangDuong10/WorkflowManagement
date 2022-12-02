package com.example.workflowmanagement;

import android.util.Patterns;

public class User {
    private String name;
    private String password;


    public User(String name, String password) {
        this.name = name;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isValiName(){
        return !this.name.isEmpty();
    }
    public boolean isValiPassWord(){
        return !this.password.isEmpty() && this.password.length()>5;
    }

}
