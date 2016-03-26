package com.lighthouse.awfulandroid.login;

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
}