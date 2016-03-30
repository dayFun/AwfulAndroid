package com.lighthouse.awfulandroid.matchers;

import android.graphics.Color;
import android.view.View;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class Matchers {

//    public static Matcher<View> withButtonBackgroundColor(final int color) {
//        Checks.checkNotNull(color);
//        return new BoundedMatcher<View, BugButton>(BugButton.class) {
//            private Color color;
//            @Override
//            public boolean matchesSafely(BugButton bugButton) {
//                ColorDrawable background = (ColorDrawable) bugButton.getBackground();
//                return color == background.getColor();
//                return false;
//            }
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("with background color: ");
//            }
//        };
//    }
//
//    @Factory
//    public static Matcher<View> matchesBackgound(View view) {
//        return view == null ?
//                nullValue(View.class) :
//                new MatchesBackground(view);
//    }
//
//    private MatchesBackground(Color color) {
//        this.color = color;
//    }
//    public class WithButtonBackground extends TypeSafeDiagnosingMatcher<? extends View> {
//        private final Color color;
//
//        public WithButtonBackground(Color color) {
//            this.color = color;
//        }
//
//        @Override
//        protected boolean matchesSafely(Object item, Description mismatchDescription) {
//            return false;
//        }
//
//        @Override
//        public void describeTo(Description description) {
//
//        }
//    }
}
