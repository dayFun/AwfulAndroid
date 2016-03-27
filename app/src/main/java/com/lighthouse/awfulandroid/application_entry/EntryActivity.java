package com.lighthouse.awfulandroid.application_entry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.login.LoginActivity;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent nextActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(nextActivityIntent);
    }
}
