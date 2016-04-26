package com.lighthouse.awfulandroid.activities.login;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.activities.interview_activities.InterviewActivity;
import com.lighthouse.awfulandroid.bugs.BugButton;
import com.lighthouse.awfulandroid.bugs.BugButtonClickListener;

import java.util.Random;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.login_activity_container)
    FrameLayout layout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.validate_button)
    Button validateButton;
    @Bind(R.id.stuckButton)
    BugButton stuckButton;
    @Bind(R.id.name_edit_text)
    EditText nameEditText;

    @Inject
    RxSharedPreferences rxPreferences;
    @Inject
    SharedPreferences preferences;

    private AlertDialog.Builder dialogBuilder;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        AwfulAndroidApp.get(this).getApplicationComponent().inject(this);

        setSupportActionBar(toolbar);
        createLoginNameObservable();

        BugButtonClickListener bugButtonClickListener = new BugButtonClickListener(this, stuckButton);
        stuckButton.setOnLongClickListener(bugButtonClickListener);

        initDialogBuilder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        subscription.unsubscribe();
    }

    private void initDialogBuilder() {
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Stuck?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(R.string.stuck_hint_text)
                .setCancelable(false)
                .setPositiveButton(R.string.stuck_button_got_it, (dialog, button) -> dialog.cancel());
    }

    @OnClick(R.id.validate_button)
    public void validate() {
        saveUserName();
        InterviewActivity.startInterviewActivity(this);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @OnClick(R.id.stuckButton)
    public void stuckHint() {
        if (!stuckButton.found()) {
            subscription = Observable.just(new Random().nextInt(10))
                    .filter(number -> number >= 3)
                    .subscribe(next -> {
                                layout.setBackgroundColor(getResources().getColor(R.color.accent, null));
                                stuckButton.setFindable(true);
                            },
                            error -> Log.e("TAG", "stuckHint: error!", error));
        }

        AlertDialog stuckDialog = dialogBuilder.create();
        stuckDialog.show();
    }

    public static void startLoginActivity(Context context) {
        Intent loginActivity = new Intent(context, LoginActivity.class);
        context.startActivity(loginActivity);
    }

    private void createLoginNameObservable() {
        RxTextView.textChangeEvents(nameEditText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onTextChangeEvent -> {
                            String enteredName = onTextChangeEvent.text().toString();
                            if (NameValidator.checkName(enteredName)) {
                                validateButton.setEnabled(true);
                            } else {
                                validateButton.setEnabled(false);
                            }
                        }
                );
    }

    private void saveUserName() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("FULL_USER_NAME", nameEditText.getText().toString());
        editor.apply();
    }

}
