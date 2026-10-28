package com.baox7248.androidassignments;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test for ListItemsActivity.java activity class.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListItemsActivityTest {

    @Rule
    public ActivityScenarioRule<ListItemsActivity> activityRule =
            new ActivityScenarioRule<>(ListItemsActivity.class);    // Start on ListItemsActivity page

    @Test
    public void testRadioButton() {
        onView(withId(R.id.radioButton)).perform(click());  // Click radio button
    }

    @Test
    public void testSwitchAndToast() {
        onView(withId(R.id.switch1)).perform(click());  // Click switch
    }

    @Test
    public void testCheckboxAlertDismiss() {
        // Start from MainActivity to build activity stack for exiting
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            onView(withId(R.id.button)).perform(click()); // Enter MainActivity
            onView(withId(R.id.checkBox)).perform(click()); // Click checkbox

            // Wait for AlertDialog pops up before clicking a button
            onView(withText(R.string.cancel)).check(matches(isDisplayed()));    // Verify AlertDialog pops
            onView(withText(R.string.cancel)).perform(click());    // Click "Cancel"

            // Verify activity stays at ListItemsActivity
            onView(withId(R.id.checkBox)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void testCheckboxAlertAccept() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            onView(withId(R.id.button)).perform(click());
            onView(withId(R.id.checkBox)).perform(click());

            onView(withText(R.string.ok)).check(matches(isDisplayed()));
            onView(withText(R.string.ok)).perform(click());   // Click "OK"

            // Verify activity returned to MainActivity
            onView(withId(R.id.chatButton)).check(matches(isDisplayed())); // Check for a login button
        }
    }
}