package com.lighthouse.awfulandroid.activities.instructions;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.R;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_pager);

        FragmentManager fm = getSupportFragmentManager();
        DemoInstructionPageDialog overlay = new DemoInstructionPageDialog();
        overlay.show(fm, "InstructionsDialog");
    }
}
