package com.example.projetogabriel.login;

import androidx.annotation.StringRes;

public interface LoginContract {

    interface Presenter {
        void login(String email, String password);
    }

    interface View {
        void showError(String message);
        void showError(@StringRes int messageId);
        void loginSuccess();
    }
}
