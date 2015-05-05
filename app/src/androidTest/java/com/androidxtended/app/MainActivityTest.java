package com.androidxtended.app;

import android.test.ActivityInstrumentationTestCase2;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testEditTextShouldBeClearedAfterClickingSendButton(){
        onView(withId(R.id.numero1)).perform(typeText("1"));
        onView(withId(R.id.numero2)).perform(typeText("2"));

        onView(withId(R.id.calculateButton)).perform(click());

        onView(withId(R.id.result)).check(matches(withText("3")));
    }

}