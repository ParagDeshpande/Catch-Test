package com.parag.catchtest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.parag.catchtest.Activity.Description;
import com.parag.catchtest.Activity.MainActivity;

import static android.support.test.espresso.Espresso.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsAnything.anything;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    private MainActivity mainActivity;
    private Description description;

    @Before
    public void setActivity() {
        // Declaration in @Before
        mainActivity = mActivityRule.getActivity();
    }

    @Test
    public void checkRefresh() {
        // First refresh to load the data
        onView(withId(R.id.swiperefresh)).perform(swipeDown());
    }

    @Test
    public void lastItem_NotDisplayed() {
        // Last item should not exist if the list wasn't scrolled down.
        onView(withText("id: 150")).check(doesNotExist());
    }

    @Test
    public void row_Click() {
        // Click on one of the rows.
        onData(anything()).inAdapterView(withId(R.id.my_recycler_view)).atPosition(30).perform(click());
    }
}