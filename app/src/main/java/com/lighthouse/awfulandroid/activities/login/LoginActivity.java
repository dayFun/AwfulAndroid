package com.lighthouse.awfulandroid.activities.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lighthouse.awfulandroid.AwfulAndroid;
import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.activities.interview_activities.InterviewActivity;
import com.lighthouse.awfulandroid.bugs.BugButton;
import com.lighthouse.awfulandroid.bugs.BugButtonClickListener;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.android.widget.WidgetObservable;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.validate_button)
    Button validateButton;
    @Bind(R.id.stuckButton)
    BugButton stuckButton;
    @Bind(R.id.name_edit_text)
    EditText nameEditText;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        ((AwfulAndroid) this.getApplicationContext()).getComponent().inject(this);
        setSupportActionBar(toolbar);


        String userNamePref = sharedPreferences.getString("FULL_USER_NAME", "Unknown");
        Toast.makeText(LoginActivity.this, "Username: " + userNamePref, Toast.LENGTH_SHORT).show();

        createEditTextObservable();

        BugButtonClickListener bugButtonClickListener = new BugButtonClickListener(this, stuckButton);
        stuckButton.setOnLongClickListener(bugButtonClickListener);
    }

    @OnClick(R.id.validate_button)
    public void validate() {
        saveUserName();
        Intent intent = new Intent(this, InterviewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.stuckButton)
    public void stuckHint() {
        if(!stuckButton.isCamouflaged()) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setTitle("Stuck?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage(R.string.stuck_hint_text)
                    .setCancelable(false)
                    .setPositiveButton(R.string.stuck_button_got_it, (dialog, button) -> dialog.cancel());

            AlertDialog stuckDialog = dialogBuilder.create();
            stuckDialog.show();
            stuckButton.setCamouflage(true);
        }
    }

    private void createEditTextObservable() {
        WidgetObservable.text(nameEditText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onTextChangeEvent -> {
                            String enteredName = onTextChangeEvent.text().toString();
                            if (checkName(enteredName)) {
                                validateButton.setEnabled(true);
                            } else {
                                validateButton.setEnabled(false);
                            }
                        }
                );
    }

    private Boolean checkName(String enteredName) {
        return NameValidator.checkName(enteredName);
    }

    private void saveUserName() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("FULL_USER_NAME", nameEditText.getText().toString());
        editor.apply();
    }

}
