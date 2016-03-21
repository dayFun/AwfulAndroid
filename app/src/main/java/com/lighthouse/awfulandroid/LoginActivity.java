package com.lighthouse.awfulandroid;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.android.widget.WidgetObservable;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
//    @Bind(R.id.fab)
//    FloatingActionButton fab;
    @Bind(R.id.validateButton)
    Button validateButton;
    @Bind(R.id.stuck_button)
    Button stuckButton;
    @Bind(R.id.nameEditText)
    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


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
                            if (checkName(onTextChangeEvent.text().toString())) {
                                validateButton.setEnabled(true);
                            }
                        }
                );
    }

    private Boolean checkName(String enteredName) {
        return enteredName.matches("^[A-Za-z]+\\.[A-Za-z]+");
    }

    @OnClick(R.id.validateButton)
    public void validate() {
        Intent startReadTextActivity = new Intent(this, ReadTextActivity.class);
        startActivity(startReadTextActivity);
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
