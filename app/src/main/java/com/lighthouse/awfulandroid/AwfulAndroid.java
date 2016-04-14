package com.lighthouse.awfulandroid;

import android.app.Application;
import android.content.Context;

public class AwfulAndroid extends Application {

    private SharedPreferencesComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerSharedPreferencesComponent
                .builder()
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
    }

    public SharedPreferencesComponent getComponent() {
        return component;
    }

    public static AwfulAndroid getContext(Context context) {
        return ((AwfulAndroid) context.getApplicationContext());
    }
}
