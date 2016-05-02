package com.lighthouse.awfulandroid.di;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.services.CurrentConditionService;
import com.lighthouse.awfulandroid.ui.activities.EntryActivity;
import com.lighthouse.awfulandroid.ui.activities.LoginActivity;
import com.lighthouse.awfulandroid.ui.activities.interview.ActivityListFragment;
import com.lighthouse.awfulandroid.ui.activities.interview.InterviewActivity;
import com.lighthouse.awfulandroid.ui.activities.lorem_ipsum.LoremIpsumActivity;
import com.lighthouse.awfulandroid.ui.activities.weather.WeatherActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AndroidModule.class, AppModule.class, ForecastApiModule.class})
public interface ApplicationComponent {

    /* App */

    void inject(@NonNull AwfulAndroidApp target);

    /* Activities */

    void inject(@NonNull LoginActivity target);

    void inject(@NonNull EntryActivity target);

    void inject(@NonNull InterviewActivity target);

    void inject(@NonNull WeatherActivity target);

    void inject(@NonNull LoremIpsumActivity target);

    /* Other stuff */

    void inject(@NonNull CurrentConditionService target);

    void inject(@NonNull ActivityListFragment target);
}
