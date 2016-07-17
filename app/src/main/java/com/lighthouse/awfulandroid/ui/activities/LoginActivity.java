package com.lighthouse.awfulandroid.ui.activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.databinding.LoginBinding;
import com.lighthouse.awfulandroid.ui.activities.interview.InterviewActivity;
import com.lighthouse.awfulandroid.ui.bugs.BugButtonClickListener;
import com.lighthouse.awfulandroid.util.NameValidator;

import java.util.Random;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class LoginActivity extends BaseActivity {

    //    @Bind(R.id.login_activity_container)
    //    private FrameLayout layout;
    //    @Bind(R.id.toolbar)
    //    private Toolbar toolbar;
    //    @Bind(R.id.validate_button)
    //    private Button validateButton;
    //    @Bind(R.id.stuckButton)
    //    private BugButton stuckButton;
    //    @Bind(R.id.name_edit_text)
    //    private EditText nameEditText;

    @Inject
    RxSharedPreferences rxPreferences;
    @Inject
    SharedPreferences preferences;

    private AlertDialog.Builder dialogBuilder;
    private Subscription subscription;
    private LoginBinding binding;

    private BugButtonClickListener bugButtonClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding = LoginBinding.inflate(getLayoutInflater());

        applicationComponent().inject(this);
        activityComponent(this).inject(this);

        setSupportActionBar(binding.toolbarLayout.toolbar);
        createLoginNameObservable();

        bugButtonClickListener = new BugButtonClickListener(this,
                                                            binding.contentLogin.stuckButton);
        //        binding.set

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
                     .setPositiveButton(R.string.stuck_button_got_it,
                                        (dialog, button) -> dialog.cancel());
    }

    ////    @BindingAdapter("app:onClick")
    public void validate() {
        saveUserName();
        InterviewActivity.startActivity(this);
    }

    //    @OnClick(R.id.stuckButton)
    @TargetApi(Build.VERSION_CODES.M)
    public void stuckHint() {
        if (!binding.contentLogin.stuckButton.found()) {
            subscription = Observable.just(new Random().nextInt(10))
                                     .filter(number -> number >= 3)
                                     .subscribe(next -> {
                                                    binding.loginActivityContainer.setBackgroundColor(
                                                            getResources().getColor(R.color.accent, null));
                                                    binding.contentLogin.stuckButton.setFindable(true);
                                                },
                                                error -> Log.e("TAG", "stuckHint: error!", error));
        }

        AlertDialog stuckDialog = dialogBuilder.create();
        stuckDialog.show();
    }

    public static void startActivity(Context context) {
        Intent loginActivity = new Intent(context, LoginActivity.class);
        context.startActivity(loginActivity);
    }

    private void createLoginNameObservable() {
        RxTextView.textChangeEvents(binding.contentLogin.nameEditText)
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(onTextChangeEvent -> {
                                 String enteredName = onTextChangeEvent.text().toString();
                                 if (NameValidator.checkName(enteredName)) {
                                     binding.contentLogin.validateButton.setEnabled(true);
                                 } else {
                                     binding.contentLogin.validateButton.setEnabled(false);
                                 }
                             }
                            );
    }

    private void saveUserName() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("FULL_USER_NAME", binding.contentLogin.nameEditText.getText().toString());
        editor.apply();
    }

}
