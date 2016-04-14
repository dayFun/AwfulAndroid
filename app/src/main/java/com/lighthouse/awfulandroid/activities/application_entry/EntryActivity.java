package com.lighthouse.awfulandroid.activities.application_entry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.AwfulAndroid;
import com.lighthouse.awfulandroid.activities.login.LoginActivity;

import javax.inject.Inject;

public class EntryActivity extends AppCompatActivity {

    public static final String UNKNOWN_USER_NAME = "Uninitialized";

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AwfulAndroid) this.getApplicationContext()).getComponent().inject(this);

        String userNamePref = sharedPreferences.getString("FULL_USER_NAME", UNKNOWN_USER_NAME);

//        if (userNamePref.equals(UNKNOWN_USER_NAME)) {
        Intent nextActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(nextActivityIntent);
//        } else {
//            Intent nextActivityIntent = new Intent(this, InterviewActivity.class);
//            startActivity(nextActivityIntent);
//        }
    }
}
