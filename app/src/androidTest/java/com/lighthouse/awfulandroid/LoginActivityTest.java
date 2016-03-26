package com.lighthouse.awfulandroid;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertButtonDisplayed;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertButtonEnabled;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertStuckDialogDisplayed;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertWelcomeMessageDisplayed;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.clickStuckButton;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.closeStuckDialog;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.enterName;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    private final int stuckButton = R.id.stuckButton;
    private final int validateButton = R.id.validate_button;

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testWelcomeTextIsDisplayed() throws Exception {
        assertWelcomeMessageDisplayed();
    }

    @Test
    public void testValidateButtonDisplayedAndDisabledByDefault() throws Exception {
        assertButtonDisplayed(validateButton, true);
        assertButtonEnabled(validateButton, false);
    }

    @Test
    public void testStuckButtonDisplayedAndEnabledByDefault() throws Exception {
        assertButtonDisplayed(stuckButton, true);
        assertButtonEnabled(stuckButton, true);
    }

    @Test
    public void testStuckButtonDisplaysHelpDialog() throws Exception {
        assertButtonEnabled(stuckButton, true);
        clickStuckButton();

        assertStuckDialogDisplayed(true);
    }

    @Test
    public void testStuckButtonDisabledAfterFirstClick() throws Exception {
        assertButtonEnabled(stuckButton, true);
        clickStuckButton();
        closeStuckDialog();

        assertButtonEnabled(stuckButton, false);
    }

    @Test
    public void testValidateButtonDisabledWhenNameEnteredIncorrectly() throws Exception {
        enterName("Homer Hickum");
        assertButtonEnabled(validateButton, false);
    }

    @Test
    public void testValidateButtonEnabledWhenNameEnteredCorrectly() throws Exception {
        enterName("rocket.boy");
        assertButtonEnabled(validateButton, true);
    }

    //TODO: Fix me!
//    @Test
//    public void testStuckButtonHelpDialogIsModal() throws Exception {
//        assertButtonDisplayed(R.id.stuckButton, true);
//        clickStuckButton();
//
//        assertStuckDialogDisplayed(true);
//
//        clickToolbar();
//        assertStuckDialogDisplayed(true);
//
//        onView(withId(R.id.welcome_text_view)).perform(click());
//        assertStuckDialogDisplayed(true);
//
//        closeStuckDialog();
//        assertStuckDialogDisplayed(false);
//    }

}
