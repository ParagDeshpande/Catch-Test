package com.parag.catchtest;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.parag.catchtest.Activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;

//import static android.support.test.espresso.Espresso.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private Activity activity;
    private RecyclerView rv;

//    @Test
//    public void clickSignUpButton_opensSignUpScreen() {
//        //locate and click on the login button
//        Espresso.onView(withId(R.id.button_sign_up)).perform(click());
//
//        //check if the sign up screen is displayed by asserting that the first name edittext is displayed
//        onView(withId(R.id.edit_text_first_name)).check(matches(allOf(isDescendantOfA(withId(R.id.layout_sign_up)), isDisplayed())));
//    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

//    @Test
//    public static void tapRecyclerViewItem(int recyclerViewId, int position) {
//        assertNotNull(MainActivity.class);
//        assertNotNull(R.id.my_recycler_view);
//    }
}