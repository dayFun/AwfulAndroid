package com.lighthouse.awfulandroid.di.components;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.di.modules.AndroidModule;
import com.lighthouse.awfulandroid.di.modules.AppModule;
import com.lighthouse.awfulandroid.di.modules.ForecastApiModule;
import com.lighthouse.awfulandroid.di.scopes.WeatherScope;
import com.lighthouse.awfulandroid.ui.activities.EntryActivity;
import com.lighthouse.awfulandroid.ui.activities.LoginActivity;
import com.lighthouse.awfulandroid.ui.activities.interview.ActivityListFragment;
import com.lighthouse.awfulandroid.ui.activities.interview.InterviewActivity;
import com.lighthouse.awfulandroid.ui.activities.lorem_ipsum.LoremIpsumActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AndroidModule.class, AppModule.class})
public interface ApplicationComponent {

    /* Subcomponents */

    WeatherComponent plus(ForecastApiModule forecastApiModule);

    /* App */

    void inject(@NonNull AwfulAndroidApp target);

    /* Activities */

    void inject(@NonNull LoginActivity target);

    void inject(@NonNull EntryActivity target);

    void inject(@NonNull InterviewActivity target);

    // Moved to Subcomponent WeatherComponent
    // void inject(@NonNull WeatherActivity target);

    void inject(@NonNull LoremIpsumActivity target);

    /* Other stuff */

    void inject(@NonNull ActivityListFragment target);
}
