package com.lighthouse.awfulandroid.instructions;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class InstructionsPagerAdapter extends FragmentPagerAdapter {

    public InstructionsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("**DEBUG**", "InstructionsPagerAdapter.getItem() called with: " + "position = [" + position + "]");
        switch (position) {
            case 0:
                Log.d("**DEBUG**", "getItem case0: page 1 red");
                return InstructionPageFragment.create(0, "page 1", Color.RED);
            case 1:
                Log.d("**DEBUG**", "getItem case1: page 2 white");
                return InstructionPageFragment.create(1, "page 2", Color.GRAY);
            default:
                Log.d("**DEBUG**", "getItem default: default gray");
                return InstructionPageFragment.create(-99, "default", android.R.color.darker_gray);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
