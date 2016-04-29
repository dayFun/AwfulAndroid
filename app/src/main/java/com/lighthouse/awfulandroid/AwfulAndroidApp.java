package com.lighthouse.awfulandroid;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.Stetho.DefaultDumperPluginsBuilder;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.FilesDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

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

        initializeStetho(this);

        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    private void initializeStetho(final Context context) {
        Stetho.initialize(Stetho.newInitializerBuilder(context)
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                .enableDumpapp(() -> new DefaultDumperPluginsBuilder(context)
                        .provide(new SharedPreferencesDumperPlugin(context))
                        .provide(new CrashDumperPlugin())
                        .provide(new FilesDumperPlugin(context))
                        .finish())
                .build());
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
