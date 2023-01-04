package com.example.jwtexample.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    void isValidTest() {
        String test = "test.test@test-mail.de";
        assertTrue(EmailValidator.isValid(test));
    }

    @Test
    void isNotValidTest() {
        String test = "test.test@test-mail.d2";
        assertFalse(EmailValidator.isValid(test));
    }
}
