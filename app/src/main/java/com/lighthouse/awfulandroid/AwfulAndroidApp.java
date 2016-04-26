package com.lighthouse.awfulandroid;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import rx.plugins.DebugHook;
import rx.plugins.DebugNotification;
import rx.plugins.DebugNotificationListener;
import rx.plugins.RxJavaPlugins;

public class AwfulAndroidApp extends Application {

    private ApplicationComponent applicationComponent;

    // Prevent need in a singleton (global) reference to the application object.
    @NonNull
    public static AwfulAndroidApp get(@NonNull Context context) {
        return (AwfulAndroidApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = prepareApplicationComponent().build();
        applicationComponent.inject(this);
    }

    @NonNull
    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    public static AwfulAndroidApp getContext(Context context) {
        return ((AwfulAndroidApp) context.getApplicationContext());
    }

    @NonNull
    protected DaggerApplicationComponent.Builder prepareApplicationComponent() {
        return DaggerApplicationComponent.builder()
                    .androidModule(new AndroidModule(this));
    }

}
