package com.lighthouse.awfulandroid.ui.activities.lorem_ipsum;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.ui.activities.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoremIpsumActivity extends BaseActivity {

    @Inject
    ScreenSlidePagerAdapter pagerAdapter;

    @Bind(R.id.text_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorem_ipsum);

        activityComponent(this).inject(this);
        ButterKnife.bind(this);

        viewPager.setAdapter(pagerAdapter);
    }

    public static void startActivity(Context context) {
        Intent loremIpsumActivity = new Intent(context, LoremIpsumActivity.class);
        context.startActivity(loremIpsumActivity);
    }
}
