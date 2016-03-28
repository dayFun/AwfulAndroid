package com.lighthouse.awfulandroid.activities.instructions;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InstructionsActivity extends AppCompatActivity {

    @Bind(R.id.instructions_viewpager)
    ViewPager instructionsViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_pager);
        ButterKnife.bind(this);

        instructionsViewpager.setAdapter(new InstructionsPagerAdapter(getSupportFragmentManager()));
    }
}
