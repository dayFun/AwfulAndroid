package com.lighthouse.awfulandroid;

import android.content.Context;

import com.lighthouse.awfulandroid.http.ForecastApiEndpoint;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;

@Module
public class ForecastApiModule {

    @Provides
    @Named(Constants.Injection.Named.FORECAST_API_KEY)
    public String provideForecastApiKey() {
        return "c0fa0bdb67350273874f71526c6bbc91";
    }

    @Provides
    public Endpoint provideEndpoint(@Named(Constants.Injection.Named.FORECAST_API_KEY) String apiKey) {
        return new ForecastApiEndpoint().setApiKey(apiKey);
    }

    @Provides
    @Singleton
    public RestAdapter provideRestAdapter(Endpoint endpoint) {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(endpoint)
                .build();

    }

}
