package com.androidxtended.app;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static final String DEFAULT_USER_NAME = "Pepe";
    public static final String A_RANDOM_OPINION = "a random opinion";
    public static final String DEFAULT_OPINION = "Tu nombre es Pepe y opinas que #AndroidXtended es a random opinion";

    @Rule
    public IntentsTestRule<MainActivity> activityRule = new IntentsTestRule<MainActivity>(MainActivity.class) {

        @Override
        protected Intent getActivityIntent() {
            Intent intent = new Intent();
            intent.putExtra(MainActivity.USER_EXTRA, DEFAULT_USER_NAME);
            return intent;
        }
    };

    @Test
    public void shouldShowTheUserNameFromTheIntent(){
        onView(withId(R.id.userName)).check(matches(withText(DEFAULT_USER_NAME)));
    }

    @Test
    public void inputShouldBeEmpty(){
        onView(withId(R.id.opinion)).check(matches(withText("")));
    }

    @Test
    public void shouldNotShowShareMenuOptionBeforeSendTheOpinion(){
        onView(withId(R.id.action_settings)).check(doesNotExist());
    }

    @Test
    public void shouldShowShareMenuOptionAfterSendTheOpinion(){
        onView(withId(R.id.opinion)).perform(typeText(A_RANDOM_OPINION));

        onView(withId(R.id.sendOpinionButton)).perform(click());

        onView(withId(R.id.action_settings)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldShowTheCompleteOpinionAfterSendIt(){
        onView(withId(R.id.opinion)).perform(typeText(A_RANDOM_OPINION));

        onView(withId(R.id.sendOpinionButton)).perform(click());

        onView(withId(R.id.result)).check(matches(withText(DEFAULT_OPINION)));
    }

    @Test
    public void shouldShareTheOpinion(){
        intending(hasAction(Intent.ACTION_SEND))
            .respondWith(new ActivityResult(Activity.RESULT_OK, null));
        onView(withId(R.id.opinion)).perform(typeText(A_RANDOM_OPINION));
        onView(withId(R.id.sendOpinionButton)).perform(click());

        onView(withId(R.id.action_settings)).perform(click());

        intended(allOf(
            hasAction(Intent.ACTION_SEND),
            hasExtra(Intent.EXTRA_TEXT, MainActivity.TESTEANDO_EN_ANDROID_XTENDED)
        ));
    }
}