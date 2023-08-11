package com.example.mvvmapplication;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvvmapplication.model.ModelLogin;


public class LoginViewModel extends BaseObservable {
    //This create object of the model class
    private ModelLogin loginModel;

    //String variables for Toast messages
    private String successMessage = "Login Success";
    private String errorMessage = "Entered Email or Password is wrong.";

    @Bindable
    //Toast Message
    private String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getUserEmail() {
        return loginModel.getEmailId();
    }

    public void setUserEmail(String email) {
        loginModel.setEmailId(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserPassword() {
        return loginModel.getPassword();
    }

    public void setUserPassword(String password) {
        loginModel.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    //Creating constructor of ViewModel class
    public LoginViewModel() {
        loginModel = new ModelLogin("", "");
    }

    public void onButtonClicked() {
        if (isValid()) {
            Log.i("Display", "Click event. True");
            setToastMessage(successMessage);
        } else {
            Log.i("Display", "Click event. False");
            setToastMessage(errorMessage);
        }
    }

    private boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail())
                && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }
}
