package com.example.cdu_nb.bus_it;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> lActivityTestRule= new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity lActivity = null;

    @Before
    public void setUp() throws Exception {

        lActivity=lActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view=lActivity.findViewById(R.id.etLoginPassword);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        lActivity=null;
    }
}