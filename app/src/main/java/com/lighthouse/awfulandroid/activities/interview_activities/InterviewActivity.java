package com.lighthouse.awfulandroid.activities.interview_activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.lighthouse.awfulandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InterviewActivity extends AppCompatActivity {

    private final String[] activities = {"Lorem Ipsum"};

    @Bind(R.id.activities_list)
    ListView activitiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_activities);
        ButterKnife.bind(this);

        greetUser();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, activities);
        activitiesList.setAdapter(adapter);
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
}
