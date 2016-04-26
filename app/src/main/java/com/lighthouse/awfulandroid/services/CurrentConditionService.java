package com.lighthouse.awfulandroid.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.http.ForecastListener;
import com.lighthouse.awfulandroid.http.ForecastService;
import com.lighthouse.awfulandroid.models.Forecast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

public class CurrentConditionService extends Service {

    private static final String TAG = CurrentConditionService.class.getSimpleName();

    @Inject
    ForecastService forecastService;

    @Override
    public void onCreate() {
        super.onCreate();
        AwfulAndroidApp.get(this).getComponent().inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("***DEBUG***", "Attempting to get current conditions");

        forecastService.getForecastFor("38.6270", "90.1994", new ForecastListener() {
            @Override
            public void onForecastLoaded(Forecast forecast) {
                if (forecast != null) {
                    Log.d(TAG, "onForecastLoaded: forecast not null");
                }

                if(forecast != null && forecast.getCurrently() != null && forecast.getCurrently().getIcon() != null) {
                    // icon options: clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night
                    String icon = forecast.getCurrently().getIcon();

                    String dateFormat = "MM/dd/yyyy";
                    SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat, Locale.US);

                    Toast.makeText(CurrentConditionService.this, "Current Condition Server: " +
                            dateFormatter.format(Calendar.getInstance().getTime()) +
                            forecast.getCurrently().getIcon(), Toast.LENGTH_SHORT).show();
                }
                stopSelf();
            }

            @Override
            public void onForecastFailed(Exception e) {
                Log.e(TAG, e.getMessage(), e);
                stopSelf();
            }
        });

        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
