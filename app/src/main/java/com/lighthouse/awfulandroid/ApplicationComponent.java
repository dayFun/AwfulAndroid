package com.lighthouse.awfulandroid;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.activities.application_entry.EntryActivity;
import com.lighthouse.awfulandroid.activities.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AndroidModule.class)
public interface ApplicationComponent {


    void inject(@NonNull LoginActivity target);

    void inject(@NonNull EntryActivity target);

    void inject(@NonNull AwfulAndroidApp target);

}
