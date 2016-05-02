package com.lighthouse.awfulandroid.di;

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

//    @Provides
//    @Singleton
//    public WeatherActivity provideWeatherActivity() {
//        return new WeatherActivity();
//    }
//
//    @Provides
//    @Singleton
//    public ScreenSlidePagerAdapter provideScreenSlidePagerAdapter(WeatherActivity weatherActivity) {
//        return new ScreenSlidePagerAdapter(weatherActivity.getFragmentManager());
//    }
}
