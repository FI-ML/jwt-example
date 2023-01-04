package com.example.jwtexample.exception;

public class EmailNotExistException extends RuntimeException {
    public EmailNotExistException() {
        super("Please write your e-mail address");
    }
}
