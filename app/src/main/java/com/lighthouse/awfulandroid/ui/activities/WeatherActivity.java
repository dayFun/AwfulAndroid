package com.lighthouse.awfulandroid.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.http.ForecastListener;
import com.lighthouse.awfulandroid.http.ForecastService;
import com.lighthouse.awfulandroid.models.Forecast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity {

    @Inject
    ForecastService forecastService;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout navigationDrawerLayout;
    @Bind(R.id.options_drawer)
    NavigationView navigationDrawer;
    @Bind(R.id.latitude_value)
    EditText latitudeText;
    @Bind(R.id.longitude_value)
    EditText longitudeText;
    @Bind(R.id.get_forecast_button)
    Button getForecastButton;
    @Bind(R.id.forecast_result)
    TextView forecastResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        AwfulAndroidApp.get(this).getComponent().inject(this);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        initToolbar();

        getForecastButton.setOnClickListener(button -> {
            String latitude = latitudeText.getText().toString();
            String longitude = longitudeText.getText().toString();
            forecastService.getForecastFor(latitude, longitude, new ForecastListener() {
                @Override
                public void onForecastLoaded(Forecast forecast) {
                    forecastResult.setText(forecast.getCurrently().getIcon());
                }

                @Override
                public void onForecastFailed(Exception e) {

                }
            });
        });
    }

    @SuppressWarnings("ConstantConditions")
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(item -> {
            navigationDrawerLayout.openDrawer(navigationDrawer);
        });
    }

    public static void startActivity(Context context) {
        Intent forecastActivity = new Intent(context, WeatherActivity.class);
        context.startActivity(forecastActivity);
    }
}
