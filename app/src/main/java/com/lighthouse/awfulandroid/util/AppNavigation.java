package com.lighthouse.awfulandroid.util;

import android.content.Context;
import android.content.Intent;

import com.lighthouse.awfulandroid.activities.application_entry.EntryActivity;
import com.lighthouse.awfulandroid.activities.instructions.InstructionsActivity;
import com.lighthouse.awfulandroid.activities.interview_activities.InterviewActivity;
import com.lighthouse.awfulandroid.activities.login.LoginActivity;

public class AppNavigation {

    public static void goToLoginActivity(Context context) {
        Intent login = new Intent(context, LoginActivity.class);
        context.startActivity(login);
    }

    public static void goToEntryActivity(Context context) {
        Intent login = new Intent(context, EntryActivity.class);
        context.startActivity(login);
    }

    public static void goToInstructionsActivity(Context context) {
        Intent login = new Intent(context, InstructionsActivity.class);
        context.startActivity(login);
    }

    public static void goToInterviewActivity(Context context) {
        Intent login = new Intent(context, InterviewActivity.class);
        context.startActivity(login);
    }


}
