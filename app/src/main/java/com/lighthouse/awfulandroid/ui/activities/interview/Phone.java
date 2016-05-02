package com.lighthouse.awfulandroid.ui.activities.interview;

public class Phone {

    private String myPhoneNumber;

    public Phone(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    public void call(String phoneNumber) {
        System.out.println("Calling: " + phoneNumber);
    }
}
