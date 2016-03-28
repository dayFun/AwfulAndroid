package com.lighthouse.awfulandroid.activities.login;

public class NameValidator {

    public static boolean checkName(String name) {
        return name.matches("^[A-Za-z]+\\.[A-Za-z]+");
    }
}
