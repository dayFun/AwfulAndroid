package com.lighthouse.awfulandroid;

import com.lighthouse.awfulandroid.ui.fragments.ActivityListFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public ActivityListFragment provideActivityListFragment() {
        return new ActivityListFragment();
    }
}
