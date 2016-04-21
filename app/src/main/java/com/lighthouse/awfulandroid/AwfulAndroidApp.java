package com.lighthouse.awfulandroid;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.lighthouse.awfulandroid.activities.application_entry.EntryActivity;
import com.lighthouse.awfulandroid.activities.login.LoginActivity;

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

        RxJavaPlugins.getInstance().registerObservableExecutionHook(new DebugHook(new DebugNotificationListener() {
            public Object onNext(DebugNotification n) {
                Log.v(TAG, "onNext on " + n);
                return super.onNext(n);
            }


            public Object start(DebugNotification n) {
                Log.v(TAG, "start on " + n);
                return super.start(n);
            }


            public void complete(Object context) {
                Log.v(TAG, "complete on " + context);
            }

            public void error(Object context, Throwable e) {
                Log.e(TAG, "error on " + context);
            }
        }));
    }

    @NonNull
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static AwfulAndroidApp getContext(Context context) {
        return ((AwfulAndroidApp) context.getApplicationContext());
    }

    @NonNull
    protected DaggerApplicationComponent.Builder prepareApplicationComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this));
    }

}
