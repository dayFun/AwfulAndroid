package com.lighthouse.awfulandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
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
    @Bind(R.id.validate_button)
    Button validateButton;
    @Bind(R.id.stuckButton)
    Button stuckButton;
    @Bind(R.id.name_edit_text)
    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        createEditTextObservable();
    }

    private void createEditTextObservable() {
        WidgetObservable.text(nameEditText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onTextChangeEvent -> {
                            String enteredName = onTextChangeEvent.text().toString();
                            if (checkName(enteredName)) {
                                validateButton.setEnabled(true);
                            }
                        }
                );
    }

    private Boolean checkName(String enteredName) {
        return NameValidator.checkName(enteredName);
    }

    @OnClick(R.id.validate_button)
    public void validate() {
        Intent intent = new Intent(this, QualityAssuranceActivities.class);
        intent.putExtra("USER_NAME", nameEditText.getText());
        startActivity(intent);
    }

    @OnClick(R.id.stuckButton)
    public void stuckHint() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Stuck?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(R.string.stuck_hint_text)
                .setCancelable(false)
                .setPositiveButton(R.string.stuck_button_got_it, (dialog, which) -> dialog.cancel());

        AlertDialog stuckDialog = dialogBuilder.create();
        stuckDialog.show();

        stuckButton.setEnabled(false);
    }

}
