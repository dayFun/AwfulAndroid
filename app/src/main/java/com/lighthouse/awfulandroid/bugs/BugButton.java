package com.lighthouse.awfulandroid.bugs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.lighthouse.awfulandroid.R;

public class BugButton extends Button {
    private boolean found = false;
    private boolean camouflage = false;

    public BugButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BugButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
        this.setEnabled(false);
    }

    public boolean isCamouflaged() {
        return camouflage;
    }

    public void setCamouflage(boolean isCamouflage) {
        this.camouflage = isCamouflage;
        this.setBackground(getResources().getDrawable(R.color.button_camouflage, null));
    }
}
