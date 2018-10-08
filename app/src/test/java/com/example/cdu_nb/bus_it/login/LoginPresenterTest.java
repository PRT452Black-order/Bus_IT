package com.example.cdu_nb.bus_it.login;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import android.view.LayoutInflater;

import com.example.cdu_nb.bus_it.R;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class LoginPresenterTest {

    @Test
    public void checkIfLoginAttemptIsExceeded() {
//        LoginView loginView= (LoginView) LayoutInflater.from(getContext()).inflate(R.layout.activity_login, null);
//        LoginView loginView = (LoginView) getView().
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }
    @Test
    public void checkUsernameAndPasswordIsCorrect()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("black@gmail.com","tdd123");
        verify(loginView).showLoginSuccessMessage();
    }

    @Test
    public void checkUsernameAndPasswordIsInCorrect()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz","tdd");
        verify(loginView).showErrorMessageForPassword();
//
    }

}