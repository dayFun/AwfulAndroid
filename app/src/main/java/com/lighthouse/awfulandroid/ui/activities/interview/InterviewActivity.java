package com.lighthouse.awfulandroid.ui.activities.interview;


import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.R;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InterviewActivity extends AppCompatActivity {

    @Inject
    ActivityListFragment activityListFragment;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout navigationDrawerLayout;
    @Bind(R.id.options_drawer)
    NavigationView navigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
        ButterKnife.bind(this);
        AwfulAndroidApp.get(this).getComponent().inject(this);

        initToolbar();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.list_container, activityListFragment)
                .commit();

//        greetUser();
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

    private void greetUser() {
        if (getIntent().getStringExtra("USER_NAME") != null) {
            String userName = getFormattedUserName();

            Toast.makeText(InterviewActivity.this,
                    "Hello, " + userName + "\nLet the games begin!", Toast.LENGTH_SHORT).show();
        }
    }

    public String getFormattedUserName() {
        String userName = getIntent().getCharSequenceExtra("USER_NAME").toString();
        String[] splitName = userName.split("\\.");

        String formatted = splitName[0].substring(0, 1).toUpperCase() + splitName[0].substring(1);
        return formatted;
    }

    public static void startActivity(Context context) {
        Intent loginActivity = new Intent(context, InterviewActivity.class);
        context.startActivity(loginActivity);
    }
}