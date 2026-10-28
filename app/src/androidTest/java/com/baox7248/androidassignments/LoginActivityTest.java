package com.baox7248.androidassignments;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test for LoginActivity.java activity class.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);    // Starts on LoginActivity page

    @Test
    public void testLoginFailure() {
        String testEmail = "improper email format";
        String testPassword = "12345678";

        onView(withId(R.id.editLoginName)).perform(clearText(), replaceText(testEmail), closeSoftKeyboard());  // Clear SharedPreference & enter email
        onView(withId(R.id.editLoginPassword)).perform(replaceText(testPassword), closeSoftKeyboard());    // Enter password
        onView(withId(R.id.loginButton)).perform(click());  // // Click submit

        // Validation staying in LoginActivity page
        onView(withId(R.id.loginButton)).check(matches(isDisplayed()));  // Check if login button exists
    }

    @Test
    public void testLoginSuccess() {
        String testEmail = "student@mylaurier.ca";
        String testPassword = "12345678";

        onView(withId(R.id.editLoginName)).perform(clearText(), replaceText(testEmail), closeSoftKeyboard());
        onView(withId(R.id.editLoginPassword)).perform(replaceText(testPassword), closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());

        // Validation transition to MainActivity
        onView(withId(R.id.chatButton)).check(matches(isDisplayed()));  // Check if send button exists
    }
}