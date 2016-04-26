package com.lighthouse.awfulandroid.http;

import com.lighthouse.awfulandroid.models.Forecast;

import retrofit.http.GET;
import retrofit.http.Path;

public interface ForecastApiService {
    @GET("/{latitude},{longitude}")
    Forecast getForecast(@Path("latitude") String latitude, @Path("longitude") String longitude);
}
