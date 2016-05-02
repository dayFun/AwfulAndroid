package com.lighthouse.awfulandroid.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.lighthouse.awfulandroid.http.ForecastService;
import com.lighthouse.awfulandroid.http.ForecastServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module
public class AndroidModule {
    @NonNull
    private final Application application;

    public AndroidModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    public RxSharedPreferences provideRxSharedPreferences() {
        return RxSharedPreferences.create(PreferenceManager.getDefaultSharedPreferences(application));
    }
}
