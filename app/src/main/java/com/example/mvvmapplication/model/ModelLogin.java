package com.example.mvvmapplication.model;

import android.util.Log;

import androidx.annotation.Nullable;

public class ModelLogin {
    @Nullable
    private String emailId, password;

    public ModelLogin(@Nullable String emailId, @Nullable String password){
        this.emailId = emailId;
        this.password = password;
    }
    @Nullable
    public String getEmailId() {
        Log.i("Display", "Get Email: "+ emailId);
        return emailId;
    }
    @Nullable
    public String getPassword() {
        Log.i("Display", "Get Password: "+ password);
        return password;
    }
    public void setEmailId(@Nullable String emailId) {
        this.emailId = emailId;
    }
    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}
