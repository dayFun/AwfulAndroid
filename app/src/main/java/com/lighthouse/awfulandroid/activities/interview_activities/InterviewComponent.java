package com.lighthouse.awfulandroid.activities.interview_activities;

import android.support.annotation.NonNull;

import com.lighthouse.awfulandroid.services.CurrentConditionService;

import dagger.Subcomponent;

@InterviewScope
@Subcomponent(modules = {ForecastApiModule.class})
public interface InterviewComponent {
    void inject(@NonNull CurrentConditionService target);

    void inject(@NonNull InterviewActivity target);
}
