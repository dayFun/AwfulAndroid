package com.lighthouse.awfulandroid.di.modules;

import android.content.Context;

import com.lighthouse.awfulandroid.Constants;
import com.lighthouse.awfulandroid.R;
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
    public String provideForecastApiKey(Context context) {
        return context.getString(R.string.forecastKey);
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
