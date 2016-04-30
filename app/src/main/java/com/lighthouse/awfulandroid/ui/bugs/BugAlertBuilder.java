package com.lighthouse.awfulandroid.ui.bugs;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.lighthouse.awfulandroid.R;

public class BugAlertBuilder {

    private final AlertDialog.Builder alertBuilder;
    private Context context;

    public BugAlertBuilder(Context context) {
        this.context = context;
        alertBuilder = new AlertDialog.Builder(context);
    }

    public void showBugFoundAlert() {
        alertBuilder.setTitle(context.getString(R.string.bug_found_text))
                .setIcon(R.drawable.ic_bug_found)
                .setMessage("Congratz! See if you can find more bugs!")
                .setCancelable(false)
                .setPositiveButton(R.string.stuck_button_got_it, (dialog, which) -> dialog.cancel());

        AlertDialog bugFoundAlert = alertBuilder.create();
        bugFoundAlert.show();
    }
}
