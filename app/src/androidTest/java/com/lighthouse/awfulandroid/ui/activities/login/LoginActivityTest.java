package com.lighthouse.awfulandroid.ui.activities.login;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.ui.activities.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.lighthouse.awfulandroid.ui.bugs.LoginActivityHelper.assertButtonDisplayed;
import static com.lighthouse.awfulandroid.ui.bugs.LoginActivityHelper.assertButtonEnabled;
import static com.lighthouse.awfulandroid.ui.bugs.LoginActivityHelper.assertStuckDialogDisplayed;
import static com.lighthouse.awfulandroid.ui.bugs.LoginActivityHelper.assertWelcomeMessageDisplayed;
import static com.lighthouse.awfulandroid.ui.bugs.LoginActivityHelper.clickStuckButton;
import static com.lighthouse.awfulandroid.ui.bugs.LoginActivityHelper.closeStuckDialog;
import static com.lighthouse.awfulandroid.ui.bugs.LoginActivityHelper.enterName;

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
