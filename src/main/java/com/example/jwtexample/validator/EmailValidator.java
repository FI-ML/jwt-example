package com.example.jwtexample.validator;

import com.example.jwtexample.exception.EmailNotExistException;
import com.example.jwtexample.exception.EmailNotValidException;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private EmailValidator() {
    }

    public static void isValid(String email) throws EmailNotValidException, EmailNotExistException {
        if (StringUtils.isEmpty(email)) {
            throw new EmailNotExistException();
        }

        if (!isMailValid(email)) {
            throw new EmailNotValidException();
        }
    }


    private static boolean isMailValid(String email) {


        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
