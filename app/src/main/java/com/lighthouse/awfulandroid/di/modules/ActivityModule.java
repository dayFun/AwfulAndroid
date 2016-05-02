package com.lighthouse.awfulandroid.di.modules;

import android.app.Activity;
import android.content.Context;

import com.lighthouse.awfulandroid.ui.activities.lorem_ipsum.ScreenSlidePagerAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return activity;
    }

    @Provides
    public ScreenSlidePagerAdapter provideScreenSlidePagerAdapter(Activity activity) {
        return new ScreenSlidePagerAdapter(activity.getFragmentManager());
    }

//    @Provides
//    @ActivityContext
//    Context providesContext() {
//        return activity;
//    }
}
