package com.lighthouse.awfulandroid.activities.application_entry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.f2prateek.rx.preferences.Preference;
import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.activities.login.LoginActivity;
import com.lighthouse.awfulandroid.util.DevHelper;
import com.lighthouse.awfulandroid.util.DevHelperImpl;

import javax.inject.Inject;

public class EntryActivity extends AppCompatActivity {

    public static final String UNKNOWN_USER_NAME = "Uninitialized";

    @Inject
    RxSharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AwfulAndroidApp.get(this).getApplicationComponent().inject(this);

        DevHelper devHelper = new DevHelperImpl();
        Toast.makeText(EntryActivity.this, "Is dev? " + Boolean.toString(devHelper.isDev()), Toast.LENGTH_SHORT).show();

        Preference<String> userNamePref = sharedPreferences.getString("FULL_USER_NAME", UNKNOWN_USER_NAME);

//        if (userNamePref.equals(UNKNOWN_USER_NAME)) {
        Intent nextActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(nextActivityIntent);
//        } else {
//            Intent nextActivityIntent = new Intent(this, InterviewActivity.class);
//            startActivity(nextActivityIntent);
//        }
    }

}
