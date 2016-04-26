package com.lighthouse.awfulandroid;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.activities.application_entry.EntryActivity;
import com.lighthouse.awfulandroid.activities.interview_activities.InterviewActivity;
import com.lighthouse.awfulandroid.activities.login.LoginActivity;
import com.lighthouse.awfulandroid.services.CurrentConditionService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AndroidModule.class, ForecastApiModule.class})
public interface ApplicationComponent {

    void inject(@NonNull AwfulAndroidApp target);

    void inject(@NonNull LoginActivity target);

    void inject(@NonNull EntryActivity target);

    void inject(@NonNull CurrentConditionService target);

    void inject(@NonNull InterviewActivity target);
}
