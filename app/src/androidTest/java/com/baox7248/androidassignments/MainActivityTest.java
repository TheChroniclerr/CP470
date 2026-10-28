package com.baox7248.androidassignments;

import androidx.test.espresso.Espresso;
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

/**
 * Instrumented test for MainActivity.java activity class.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class); // Start on MainActivity page

    @Test
    public void testActivityNavigations() {
        // --- Navigation 1: Main -> ChatWindow -> Back ---
        onView(withId(R.id.chatButton)).perform(click());  // Click start chat button
        onView(withId(R.id.sendButton)).check(matches(isDisplayed()));  // Check if we are in ChatWindow
        Espresso.pressBack();   // Press Android Back button to return to Main
        onView(withId(R.id.chatButton)).check(matches(isDisplayed()));  // Check we returned to MainActivity

        // --- Navigation 2: Main -> ListItems -> Back ---
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.radioButton)).check(matches(isDisplayed()));  // Check if we are in ListItemsActivity
        Espresso.pressBack();
        onView(withId(R.id.chatButton)).check(matches(isDisplayed()));
    }
}