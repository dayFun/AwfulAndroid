package com.lighthouse.awfulandroid;

import com.lighthouse.awfulandroid.activities.application_entry.EntryActivity;
import com.lighthouse.awfulandroid.activities.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = SharedPreferencesModule.class)
public interface SharedPreferencesComponent {

//    void inject(AwfulAndroid target);
    void inject(LoginActivity target);
    void inject(EntryActivity target);
//    void inject(InterviewActivity target);
//    void inject(InstructionsActivity target);

}
