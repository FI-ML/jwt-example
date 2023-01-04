package com.example.jwtexample.validator;

import com.example.jwtexample.exception.EmailNotExistException;
import com.example.jwtexample.exception.EmailNotValidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailValidatorTest {

    @Test
    void isValidTest() {
        String test = "test.test@test-mail.de";
        assertDoesNotThrow(() -> {
            EmailValidator.isValid(test);
        });
    }

    @Test
    void isNotValidExpectedEmailNotValidExceptionTest() {
        String test = "test.test@test-mail.d2";
        assertThrows(EmailNotValidException.class, () -> {
            EmailValidator.isValid(test);
        });
    }

    @Test
    void isNotValidExpectedEmailNotExistExceptionTest() {
        String test = "";
        assertThrows(EmailNotExistException.class, () -> {
            EmailValidator.isValid(test);
        });
    }
}
