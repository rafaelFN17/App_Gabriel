package com.example.projetogabriel.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.projetogabriel.MainActivity;
import com.example.projetogabriel.R;

public class LoginActivity extends AppCompatActivity  implements LoginContract.View {

    private LoginContract.Presenter presenter = new LoginPresenter(this);

    private EditText email;
    private EditText password;

    private final View.OnClickListener clickListener = view -> {
        presenter.login(email.getText().toString(), password.getText().toString());
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);

        findViewById(R.id.btnEnter).setOnClickListener(clickListener);
    }

    @Override
    public void showError(String message) {
        showDialogError(message);
    }

    @Override
    public void showError(int messageId) {
        showDialogError(getResources().getString(messageId));
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void showDialogError(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atenção").setMessage(message);
        builder.setPositiveButton("Ok", null);
        builder.show();
    }
}