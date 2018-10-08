package com.example.cdu_nb.bus_it.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.Toast;

import com.example.cdu_nb.bus_it.MainActivity;
import com.example.cdu_nb.bus_it.R;
import com.example.cdu_nb.bus_it.RegisterActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPresenter {
//    private EditText inputEmail, inputPassword;
//    private FirebaseAuth auth;
//    private ProgressBar progressBar;
//    private Button btnSignup, btnLogin, btnReset;

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private final LoginView loginView;
    private int loginAttempt;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }


    public int incrementLoginAttempt() {
        loginAttempt = loginAttempt + 1;
        return loginAttempt;
    }
    public boolean isLoginAttemptExceeded() {
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }
    public boolean isLoginSuccess() {
        return false;
    }
    public void resetLoginAttempt() {
        loginAttempt = 0;
    }

    public void doLogin(String userName, String password) {
        if (isLoginAttemptExceeded()) {
            loginView.showErrorMessageForMaxLoginAttempt();
            return;
        }

        if (userName.equals("black@gmail.com") && password.equals("tdd123")) {
            loginView.showLoginSuccessMessage();
            resetLoginAttempt();
            return;
        }


        // increment login attempt only if it's fail
        incrementLoginAttempt();
        loginView.showErrorMessageForPassword();
    }


}

