package com.lighthouse.awfulandroid.ui.activities.instructions;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return InstructionPageFragment.create(0, "page 1", Color.RED);
            case 1: return InstructionPageFragment.create(0, "page 2", Color.GRAY);
            default: return InstructionPageFragment.create(-99, "default", android.R.color.darker_gray);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "First Tab";
            case 1:
                return "Second Tab";
        }
        return null;
    }
}
