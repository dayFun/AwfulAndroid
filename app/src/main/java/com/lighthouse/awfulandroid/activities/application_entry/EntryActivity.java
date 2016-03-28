package com.lighthouse.awfulandroid.activities.application_entry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.activities.instructions.InstructionsActivity;
import com.lighthouse.awfulandroid.activities.interview_activities.InterviewActivities;
import com.lighthouse.awfulandroid.activities.login.LoginActivity;

public class EntryActivity extends AppCompatActivity {

    public static final String UNKNOWN_USER_NAME = "Uninitialized";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences awfulAndroidData = getSharedPreferences("AwfulAndroidData", Context.MODE_PRIVATE);
        String userNamePref = awfulAndroidData.getString("FULL_USER_NAME", UNKNOWN_USER_NAME);

        if (userNamePref.equals(UNKNOWN_USER_NAME)) {
            Intent nextActivityIntent = new Intent(this, LoginActivity.class);
            startActivity(nextActivityIntent);
        } else {
            Intent nextActivityIntent = new Intent(this, InterviewActivities.class);
            startActivity(nextActivityIntent);
        }
    }
}
