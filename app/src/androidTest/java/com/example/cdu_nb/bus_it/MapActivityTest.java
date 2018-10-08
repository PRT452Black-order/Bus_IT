package com.example.cdu_nb.bus_it;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapActivityTest {

    @Rule
    public ActivityTestRule<MapActivity> mapActivityTestRule= new ActivityTestRule<MapActivity>(MapActivity.class);

    private MapActivity mapActivity = null;

    @Before
    public void setUp() throws Exception {

        mapActivity=mapActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view=mapActivity.findViewById(R.id.mapView1);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mapActivity=null;
    }
}