package com.example.jwtexample.exception;

public class EmailNotValidException extends RuntimeException{
    public EmailNotValidException() {
        super("Your email is not valid" +"\n" + " Example: test@mail.com");
    }
}
