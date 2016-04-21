package com.lighthouse.awfulandroid;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.f2prateek.rx.preferences.RxSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    @NonNull
    private final Application application;

    public ApplicationModule(@NonNull Application application) {
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
