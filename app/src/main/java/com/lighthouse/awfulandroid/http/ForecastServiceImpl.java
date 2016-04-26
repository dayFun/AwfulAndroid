package com.lighthouse.awfulandroid.http;

import android.os.AsyncTask;

import com.lighthouse.awfulandroid.models.Forecast;

import retrofit.RestAdapter;

public class ForecastServiceImpl implements ForecastService {

    private RestAdapter restAdapter;

    public ForecastServiceImpl(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    @Override
    public void getForecastFor(final String latitude, final String longitude, final ForecastListener forecastListener) {
        new AsyncTask<Void, Void, Forecast>() {

            public Exception e;

            @Override
            protected Forecast doInBackground(Void... params) {
                return restAdapter.create(ForecastApiService.class).getForecast(latitude, longitude);
            }

            @Override
            protected void onPostExecute(Forecast forecast) {
                super.onPostExecute(forecast);
                if(forecastListener != null) {
                    forecastListener.onForecastLoaded(forecast);
                }
            }
        }.execute();
    }
}
