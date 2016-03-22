package com.lighthouse.awfulandroid;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.android.widget.WidgetObservable;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.validateButton)
    Button validateButton;
    @Bind(R.id.stuck_button)
    Button stuckButton;
    @Bind(R.id.nameEditText)
    EditText nameEditText;
    @Bind(R.id.design_navigation_view)
    NavigationView navigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);


//        setBadTimeZone();
        createEditTextObservable();
    }


//    private void setBadTimeZone() {
//        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
//        alarmManager.setTimeZone("Europe/London");
//    }

    private void createEditTextObservable() {
        WidgetObservable.text(nameEditText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onTextChangeEvent -> {
                            String enteredName = onTextChangeEvent.text().toString();
                            if (checkName(enteredName)) {
                                validateButton.setEnabled(true);
                                updateUsername(enteredName);
                            }
                        }
                );
    }

    private void updateUsername(String enteredName) {
        View header = navigationDrawer.getHeaderView(0);
        TextView userName = (TextView) header.findViewById(R.id.drawer_user_name_text_view);
        userName.setText(enteredName);
    }

    private Boolean checkName(String enteredName) {
        return enteredName.matches("^[A-Za-z]+\\.[A-Za-z]+");
    }

    @OnClick(R.id.validateButton)
    public void validate() {

    }

    @OnClick(R.id.stuck_button)
    public void stuckHint() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Stuck?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(R.string.stuck_hint_text)
                .setCancelable(true)
                .setPositiveButton(R.string.stuck_button_got_it, (dialog, which) -> dialog.cancel());

        AlertDialog stuckDialog = dialogBuilder.create();
        stuckDialog.show();

        stuckButton.setEnabled(false);
    }

}
