package com.lighthouse.awfulandroid.ui.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.di.components.ActivityComponent;
import com.lighthouse.awfulandroid.di.components.ApplicationComponent;
import com.lighthouse.awfulandroid.di.modules.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    public ActivityComponent activityComponent(Activity activity) {
        if (activityComponent == null) {
            activityComponent = applicationComponent().activityComponentBuilder()
                    .activityModule(new ActivityModule(activity))
                    .build();
        }
        return activityComponent;
    }

    protected ApplicationComponent applicationComponent() {
        return AwfulAndroidApp.get(this).getComponent();
    }
}
