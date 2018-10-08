package com.example.cdu_nb.bus_it;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<RegisterActivity> rActivityTestRule= new ActivityTestRule<RegisterActivity>(RegisterActivity.class);

    private RegisterActivity rActivity = null;

    @Before
    public void setUp() throws Exception {

        rActivity=rActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view=rActivity.findViewById(R.id.textView);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        rActivity=null;
    }
}