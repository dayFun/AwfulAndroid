package com.lighthouse.awfulandroid.ui.bugs;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.util.AttributeSet;
import android.widget.Button;

import com.lighthouse.awfulandroid.R;

public class BugButton extends Button {
    private ObservableBoolean found = new ObservableBoolean();
    private ObservableBoolean camouflage = new ObservableBoolean();
    private ObservableBoolean findable = new ObservableBoolean();

    public BugButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BugButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setFound(boolean found) {
        this.found.set(found);
        this.setEnabled(false);
    }

    public void setFindable(boolean canFind) {
        findable.set(canFind);
    }

    public boolean isFindable() {
        return findable.get();
    }

    public boolean found() {
        return found.get();
    }

    public boolean isCamouflaged() {
        return camouflage.get();
    }

    public void setCamouflage(boolean isCamouflage) {
        camouflage.set(isCamouflage);
        this.setBackground(getResources().getDrawable(R.color.button_camouflage, null));
    }

}
