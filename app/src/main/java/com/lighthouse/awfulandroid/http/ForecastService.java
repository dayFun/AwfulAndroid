package com.lighthouse.awfulandroid.http;

public interface ForecastService {

    void getForecastFor(String latitude, String longitude, ForecastListener forecastListener);
}
