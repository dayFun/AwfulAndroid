package com.lighthouse.awfulandroid.activities.login;


import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import com.lighthouse.awfulandroid.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertButtonColor;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertButtonDisplayed;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertButtonEnabled;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertStuckDialogDisplayed;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.assertWelcomeMessageDisplayed;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.clickStuckButton;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.closeStuckDialog;
import static com.lighthouse.awfulandroid.util.LoginActivityHelper.enterName;

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
    public void testStuckButtonAppearsDisabledAfterFirstClick() throws Exception {
//        Thread.sleep(3000L);
        ColorDrawable expectedDrawable = (ColorDrawable) ContextCompat.getDrawable(mActivityRule.getActivity(), R.color.button_default);
        Log.d("**DEBUG**", "expected Color: " + expectedDrawable);
        assertButtonColor(stuckButton, expectedDrawable);
        clickStuckButton();
        closeStuckDialog();

        assertButtonColor(stuckButton, expectedDrawable);
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
