package com.lighthouse.awfulandroid.di.components;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.di.modules.ActivityModule;
import com.lighthouse.awfulandroid.di.modules.AndroidModule;
import com.lighthouse.awfulandroid.di.modules.AppModule;
import com.lighthouse.awfulandroid.di.modules.ForecastApiModule;
import com.lighthouse.awfulandroid.ui.activities.EntryActivity;
import com.lighthouse.awfulandroid.ui.activities.LoginActivity;
import com.lighthouse.awfulandroid.ui.activities.interview.ActivityListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AndroidModule.class})
public interface ApplicationComponent {

    /* Subcomponents */

    WeatherComponent plus(ForecastApiModule forecastApiModule);

    /* App */

    void inject(@NonNull AwfulAndroidApp target);

    /* Activities */

    void inject(@NonNull LoginActivity target);

    void inject(@NonNull EntryActivity target);
}
