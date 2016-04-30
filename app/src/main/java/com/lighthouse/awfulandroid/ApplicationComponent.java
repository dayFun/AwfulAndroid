package com.lighthouse.awfulandroid;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.ui.activities.EntryActivity;
import com.lighthouse.awfulandroid.ui.fragments.ActivityListFragment;
import com.lighthouse.awfulandroid.ui.activities.InterviewActivity;
import com.lighthouse.awfulandroid.ui.activities.LoginActivity;
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

    void inject(@NonNull ActivityListFragment target);
}
