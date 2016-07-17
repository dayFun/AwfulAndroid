package com.lighthouse.awfulandroid.http;

import retrofit.Endpoint;

public class ForecastApiEndpoint implements Endpoint {

    private static final String BASE = "https://api.forecast.io/forecast/";

    private String url;

    public ForecastApiEndpoint setApiKey(String apiKey) {
        url = BASE + apiKey;
        return this;
    }

    @Override
    public String getUrl() {
        if(url == null) {
            throw new IllegalStateException("API key not set");
        }
        return url;
    }

    @Override
    public String getName() {
        return "default Forecast.io endpoint";
    }
}
