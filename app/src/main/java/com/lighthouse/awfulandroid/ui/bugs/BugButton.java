package com.lighthouse.awfulandroid.ui.bugs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.lighthouse.awfulandroid.R;

public class BugButton extends Button {
    private boolean found = false;
    private boolean camouflage = false;
    private boolean findable = false;

    public BugButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BugButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setFound(boolean found) {
        this.found = found;
        this.setEnabled(false);
    }

    public void setFindable(boolean canFind) {
        this.findable = canFind;
    }

    public boolean isFindable() {
        return findable;
    }

    public boolean found() {
        return found;
    }

    public boolean isCamouflaged() {
        return camouflage;
    }

    public void setCamouflage(boolean isCamouflage) {
        this.camouflage = isCamouflage;
        this.setBackground(getResources().getDrawable(R.color.button_camouflage, null));
    }

}
