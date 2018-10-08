package com.example.cdu_nb.bus_it;

import android.app.Fragment;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelpFragTest {

    @Rule
    public ActivityTestRule<TestActivity> mActivityTestRule= new ActivityTestRule<TestActivity>(TestActivity.class);

    private TestActivity mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity=mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view=mActivity.findViewById(R.id.image);
        assertNotNull(view);

        mActivity.getFragmentManager().beginTransaction().add(rlContainer.getId(),new HelpFrag()).commitAllowingStateLoss();
    }

    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}