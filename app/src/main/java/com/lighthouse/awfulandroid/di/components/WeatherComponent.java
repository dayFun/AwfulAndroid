package com.lighthouse.awfulandroid.di.components;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.di.modules.ForecastApiModule;
import com.lighthouse.awfulandroid.di.scopes.WeatherScope;
import com.lighthouse.awfulandroid.ui.activities.weather.WeatherActivity;

import dagger.Subcomponent;

@WeatherScope
@Subcomponent(modules = {ForecastApiModule.class})
public interface WeatherComponent {

    void inject(@NonNull WeatherActivity target);

}
