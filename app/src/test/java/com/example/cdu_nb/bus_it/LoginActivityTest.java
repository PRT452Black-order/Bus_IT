<<<<<<< HEAD
package com.example.cdu_nb.bus_it;

import android.view.View;
import android.support.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
=======
package com.example.cdu_nb.bus_it.login;

import org.junit.After;
import org.junit.Before;
>>>>>>> 293cc360b31d169f418b95b7c73499e9c28ca4d3
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginActivityTest {

<<<<<<< HEAD
    @Rule
    public ActivityTestRule<LoginActivity> lActivityTestRule= new ActivityTestRule<loginActivity>(LoginActivity.class);

    private MapActivity mapActivity = null;

    @Before
    public void setUp() throws Exception {

        mapActivity=mapActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view=mapActivity.findViewById(R.id.mapView1);
        assertNotNull(view);
=======
    @Test
    public void invalidEmailError(){

    }

    @Before
    public void setUp() throws Exception {
>>>>>>> 293cc360b31d169f418b95b7c73499e9c28ca4d3
    }

    @After
    public void tearDown() throws Exception {
<<<<<<< HEAD
        mapActivity=null;
=======
>>>>>>> 293cc360b31d169f418b95b7c73499e9c28ca4d3
    }
}