package com.lighthouse.awfulandroid;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class QualityAssuranceActivities extends Activity {

    ListView interviewActivities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa_activities);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CharSequence userName = getIntent().getCharSequenceExtra("USER_NAME");

        Toast.makeText(QualityAssuranceActivities.this,
                "Hello, " + userName + " \nLet the games begin!", Toast.LENGTH_SHORT).show();
    }
}
