package com.example.cdu_nb.bus_it.login;

public interface LoginView {

    void showErrorMessageForPassword();

    void showErrorMessageForMaxLoginAttempt();

    void loginSuccess();

    void showLoginSuccessMessage();
}
