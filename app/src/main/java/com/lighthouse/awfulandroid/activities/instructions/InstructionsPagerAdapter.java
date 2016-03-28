package com.lighthouse.awfulandroid.activities.instructions;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class InstructionsPagerAdapter extends FragmentPagerAdapter {

    public InstructionsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return InstructionPageFragment.create(0, "page 1", Color.RED);
            default: return InstructionPageFragment.create(-99, "default", android.R.color.darker_gray);
        }
    }

    @Override
    public int getCount() {
        return 1;
    }
}
