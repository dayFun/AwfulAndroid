package com.lighthouse.awfulandroid.http;

import com.lighthouse.awfulandroid.models.Forecast;

public interface ForecastListener {

    void onForecastLoaded(Forecast forecast);

    void onForecastFailed(Exception e);

}
