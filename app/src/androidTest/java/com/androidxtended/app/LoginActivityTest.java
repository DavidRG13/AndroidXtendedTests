package com.androidxtended.app;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.Visibility.GONE;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    public static final String USER_NAME = "Pepe";

    @Rule
    public IntentsTestRule<LoginActivity> activityRule = new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void shouldHaveTheInputEmpty(){
        onView(withId(R.id.userName)).check(matches(withText("")));
    }

    @Test
    public void shouldHaveTheInvalidUserNameHidden(){
        onView(withId(R.id.userNameInvalid)).check(matches(withEffectiveVisibility(GONE)));
    }

    @Test
    public void shouldShowWarningIfNameIsEmpty(){
        onView(withId(R.id.userName)).perform(clearText());

        onView(withId(R.id.loginButton)).perform(click());

        onView(withId(R.id.userNameInvalid)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldLaunchAnIntentWithTheUserName(){
        onView(withId(R.id.userName)).perform(typeText(USER_NAME));

        onView(withId(R.id.loginButton)).perform(click());

        intended(allOf(
            isInternal(),
            hasComponent(hasClassName(MainActivity.class.getName())),
            hasExtra(MainActivity.USER_EXTRA, USER_NAME)
        ));
    }

    @Test
    public void mainActivityShouldBeVisibleIfUserNameIsValid(){
        onView(withId(R.id.userName)).perform(typeText(USER_NAME));

        onView(withId(R.id.loginButton)).perform(click());

        onView(withId(R.id.sendOpinionButton)).check(matches(isDisplayed()));
    }

}