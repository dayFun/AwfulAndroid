package com.lighthouse.awfulandroid.ui.activities.instructions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.ui.activities.BaseActivity;

public class InstructionsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        FragmentManager fm = getSupportFragmentManager();
        InstructionPageDialog overlay = new InstructionPageDialog();
        overlay.show(fm, "InstructionsDialog");
    }

    public static void startActivity(Context context) {
        Intent instructionsActivity = new Intent(context, InstructionsActivity.class);
        context.startActivity(instructionsActivity);
    }
}
