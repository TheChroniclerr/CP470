package com.baox7248.androidassignments;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test for ChatWindow.java activity class.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChatWindowTest {

    @Rule
    public ActivityScenarioRule<ChatWindow> activityRule =
            new ActivityScenarioRule<>(ChatWindow.class); // Start on ChatWindow page

    @Test
    public void testChatWorkflow() {
        String testMessage = "Hello World!";

        // Use replaceText() instead of typeText() to prevent misinput from keyboard stutter
        onView(withId(R.id.chatBox)).perform(replaceText(testMessage), closeSoftKeyboard());   // Type a message into the EditText
        onView(withId(R.id.sendButton)).perform(click());   // Click Send

        // Validate
        onView(withText(testMessage)).check(matches(isDisplayed()));    // Check if message populates
        onView(withId(R.id.chatBox)).check(matches(withText(""))); // Check if EditText clears
    }
}