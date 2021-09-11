package com.example.projetogabriel.login;

import android.util.Patterns;

import com.example.projetogabriel.R;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    public void login(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            view.showError(R.string.email_password_field_required);
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.showError(R.string.email_invalid);
            return;
        }
        view.loginSuccess();
    }
}
