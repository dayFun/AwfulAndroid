package com.lighthouse.awfulandroid.ui.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.ui.fragments.ScreenSlidePageFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoremIpsumActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;

    @Bind(R.id.text_pager)
    ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorem_ipsum);
        ButterKnife.bind(this);

        viewPager.setAdapter(new ScreenSlideAdapter(getFragmentManager()));
    }

    public static void startActivity(Context context) {
        Intent loremIpsumActivity = new Intent(context, LoremIpsumActivity.class);
        context.startActivity(loremIpsumActivity);
    }

    private class ScreenSlideAdapter extends FragmentPagerAdapter {

        public ScreenSlideAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
