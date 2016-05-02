package com.lighthouse.awfulandroid;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.Stetho.DefaultDumperPluginsBuilder;
import com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.FilesDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.lighthouse.awfulandroid.di.components.ApplicationComponent;
import com.lighthouse.awfulandroid.di.components.DaggerApplicationComponent;
import com.lighthouse.awfulandroid.di.components.WeatherComponent;
import com.lighthouse.awfulandroid.di.modules.AndroidModule;
import com.lighthouse.awfulandroid.di.modules.ForecastApiModule;

public class AwfulAndroidApp extends Application {

    private ApplicationComponent applicationComponent;
//    private ActivityComponent activityComponent;
    private WeatherComponent weatherComponent;

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
    }

    @NonNull
    protected DaggerApplicationComponent.Builder prepareApplicationComponent() {
        return DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(this));
    }

    @NonNull
    public ApplicationComponent getComponent() {
        return applicationComponent;
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

    public WeatherComponent createWeatherComponent() {
        weatherComponent = applicationComponent.plus(new ForecastApiModule());
        return weatherComponent;
    }

    public void releaseWeatherComponent() {
        weatherComponent = null;
    }

//    public static AwfulAndroidApp getContext(Context context) {
//        return ((AwfulAndroidApp) context.getApplicationContext());
//    }

}
