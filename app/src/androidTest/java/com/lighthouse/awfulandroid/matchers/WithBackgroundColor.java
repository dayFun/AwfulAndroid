package com.lighthouse.awfulandroid.matchers;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class WithBackgroundColor extends TypeSafeDiagnosingMatcher<View> {
    private ColorDrawable color;

    private WithBackgroundColor(ColorDrawable color) {
        this.color = color;
    }

    public static WithBackgroundColor withBackgroundColor(ColorDrawable color) {
        return new WithBackgroundColor(color);
    }


    @Override
    protected boolean matchesSafely(View view, Description mismatchDescription) {
        if (view != null) {
            ColorDrawable background = (ColorDrawable) view.getBackground();
            Log.d("**DEBUG**", "Actual: " + background.getColor());
            Log.d("**DEBUG**", "Expected: " + color);

            return color.equals(background);
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {

    }
}
