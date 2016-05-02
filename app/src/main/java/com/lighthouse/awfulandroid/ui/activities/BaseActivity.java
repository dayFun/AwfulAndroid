package com.lighthouse.awfulandroid.ui.activities;

import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.di.components.ActivityComponent;
import com.lighthouse.awfulandroid.di.components.DaggerActivityComponent;
import com.lighthouse.awfulandroid.di.modules.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    public ActivityComponent activityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(AwfulAndroidApp.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

//    protected ApplicationComponent applicationComponent() {
//        return AwfulAndroidApp.get(this).getComponent();
//    }
}
