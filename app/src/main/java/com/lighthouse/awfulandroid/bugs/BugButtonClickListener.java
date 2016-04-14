package com.lighthouse.awfulandroid.bugs;

import android.content.Context;
import android.view.View;

public class BugButtonClickListener implements View.OnLongClickListener {

    private final BugAlertBuilder alertBuilder;
    private Context context;
    private BugButton bugButton;

    public BugButtonClickListener(Context context, BugButton bugButton) {
        this.context = context;
        this.bugButton = bugButton;
        this.alertBuilder = new BugAlertBuilder(context);
    }

    @Override
    public boolean onLongClick(View v) {
        if((bugButton.isFindable()) && !bugButton.found()) {
            alertBuilder.showBugFoundAlert();
            bugButton.setFound(true);
            return true;
        }
        return false;
    }
}
