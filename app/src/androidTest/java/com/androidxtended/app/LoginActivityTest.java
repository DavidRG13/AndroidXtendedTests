package com.androidxtended.app;

import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    public static final String VALID_USER_NAME = "Xtended";
    @Rule
    public IntentsTestRule<LoginActivity> rule = new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void notValidUserNmaeWarningShouldNotAppearsIfTheNameIsValid() {

        // given
        onView(withId(R.id.userName))
            .perform(typeText(VALID_USER_NAME));

        // when
        onView(withId(R.id.loginButton))
            .perform(click());

        // then
        onView(withId(R.id.userNameInvalid))
            .check(doesNotExist());

    }

    @Test
    public void shouldOpenMainScreenIfTheNameIsValid() {

        // given
        onView(withId(R.id.userName))
            .perform(typeText(VALID_USER_NAME));

        // when
        onView(withId(R.id.loginButton))
            .perform(click());

        // then
        intended(allOf(
            IntentMatchers.hasComponent(MainActivity.class.getName()),
            hasExtra(MainActivity.USER_EXTRA, VALID_USER_NAME)
        ));

    }

}