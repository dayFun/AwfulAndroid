package com.lighthouse.awfulandroid.instructions;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lighthouse.awfulandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InstructionsActivity extends AppCompatActivity {

    @Bind(R.id.instructions_viewpager)
    ViewPager instructionsViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "InstructionsActivity onCreate() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
        setContentView(R.layout.activity_instructions_pager);
        ButterKnife.bind(this);

        instructionsViewpager.setAdapter(new InstructionsPagerAdapter(getSupportFragmentManager()));
        Log.d("TAG", "setAdapter on viewPager. Pager shown? " + instructionsViewpager.isShown());
    }
}
