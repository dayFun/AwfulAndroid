package com.lighthouse.awfulandroid.activities.interview_activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.http.ForecastListener;
import com.lighthouse.awfulandroid.http.ForecastService;
import com.lighthouse.awfulandroid.models.Forecast;
import com.lighthouse.awfulandroid.services.CurrentConditionService;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InterviewActivity extends AppCompatActivity {

    private final String[] activities = {"Lorem Ipsum", "Weather"};

    @Inject
    ForecastService forecastService;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.options_drawer)
    NavigationView navigationDrawer;
    @Bind(R.id.activities_list)
    ListView activitiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_activities);
        ButterKnife.bind(this);

        AwfulAndroidApp.get(this).getComponent().inject(this);

        greetUser();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, activities);
        activitiesList.setAdapter(adapter);
        activitiesList.setOnItemClickListener((parent, view, position, id) -> {
            if(position == 1) {
                forecastService.getForecastFor("22.2", "90.0", new ForecastListener() {
                    @Override
                    public void onForecastLoaded(Forecast forecast) {
                        Toast.makeText(InterviewActivity.this, forecast.getCurrently().getIcon() + "\r", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onForecastFailed(Exception e) {

                    }
                });
            }
        });
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu., menu);
        return true;
    }

    private void greetUser() {
        if(getIntent().getStringExtra("USER_NAME") != null) {
            String userName = getFormattedUserName();

            Toast.makeText(InterviewActivity.this,
                    "Hello, " + userName + "\nLet the games begin!", Toast.LENGTH_SHORT).show();
        }
    }

    public String getFormattedUserName() {
        String userName = getIntent().getCharSequenceExtra("USER_NAME").toString();
        String[] splitName = userName.split("\\.");

        String formatted = splitName[0].substring(0,1).toUpperCase() + splitName[0].substring(1);
        return formatted;
    }

    public static void startInterviewActivity(Context context) {
        Intent loginActivity = new Intent(context, InterviewActivity.class);
        context.startActivity(loginActivity);
    }
}
