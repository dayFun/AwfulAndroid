package com.lighthouse.awfulandroid.ui.activities.login;

import com.lighthouse.awfulandroid.util.NameValidator;

import junit.framework.TestCase;

public class NameValidatorTest extends TestCase {

    public void testCheckNameReturnsTrueWhenNameEnteredFirstDotLast() throws Exception {
        assertTrue(NameValidator.checkName("william.do"));
    }

    public void testCheckNameReturnsFalseWhenNameEnteredFirstLast() throws Exception {
        assertFalse(NameValidator.checkName("williamDo"));
    }

    public void testCheckNameReturnsFalseWhenNameEnteredContainsExtraWhiteSpace() throws Exception {
        assertFalse(NameValidator.checkName("     william.do    "));
    }

    public void testCheckNameReturnsFalseWhenMiddleNameAlsoEntered() throws Exception {
        assertFalse(NameValidator.checkName("tom.will.go"));
    }
}