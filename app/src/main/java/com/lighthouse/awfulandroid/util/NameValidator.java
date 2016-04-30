package com.lighthouse.awfulandroid.util;

public class NameValidator {

    public static boolean checkName(String name) {
        return name.matches("^[A-Za-z]+\\.[A-Za-z]+\\z");
    }
}
