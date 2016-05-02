package com.lighthouse.awfulandroid.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.f2prateek.rx.preferences.Preference;
import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.ui.activities.interview.InterviewActivity;

import javax.inject.Inject;

public class EntryActivity extends BaseActivity {

    public static final String UNKNOWN_USER_NAME = "Uninitialized";

//    @Inject
//    RxSharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AwfulAndroidApp.get(this).getComponent().inject(this);
        activityComponent().inject(this);

//        Preference<String> userNamePref = sharedPreferences.getString("FULL_USER_NAME", UNKNOWN_USER_NAME);

//        if (userNamePref.equals(UNKNOWN_USER_NAME)) {
        Intent nextActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(nextActivityIntent);
//        } else {
//            Intent nextActivityIntent = new Intent(this, InterviewActivity.class);
//            startActivity(nextActivityIntent);
//        }
    }

}
