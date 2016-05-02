package com.lighthouse.awfulandroid.di.components;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.di.modules.ActivityModule;
import com.lighthouse.awfulandroid.di.scopes.PerActivity;
import com.lighthouse.awfulandroid.ui.activities.EntryActivity;
import com.lighthouse.awfulandroid.ui.activities.LoginActivity;
import com.lighthouse.awfulandroid.ui.activities.interview.ActivityListFragment;
import com.lighthouse.awfulandroid.ui.activities.interview.InterviewActivity;
import com.lighthouse.awfulandroid.ui.activities.lorem_ipsum.LoremIpsumActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    /* Activities */

    void inject(@NonNull LoginActivity target);

    void inject(@NonNull EntryActivity target);

    void inject(@NonNull InterviewActivity target);

    void inject(@NonNull LoremIpsumActivity target);

    /* Other stuff */

    void inject(@NonNull ActivityListFragment target);
}