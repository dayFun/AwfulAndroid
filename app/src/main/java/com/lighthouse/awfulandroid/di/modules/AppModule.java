package com.lighthouse.awfulandroid.di.modules;

import com.lighthouse.awfulandroid.ui.activities.interview.ActivityListFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    public ActivityListFragment provideActivityListFragment() {
        return new ActivityListFragment();
    }
}
