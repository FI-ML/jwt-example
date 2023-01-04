package com.example.jwtexample.validator;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private EmailValidator() {
    }

    public static boolean isValid(String email){

        if(StringUtils.isEmpty(email)){
            return false;
        }
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
