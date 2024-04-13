package com.africa.semicolon.blog.exception;

public class ExistingUserException extends RuntimeException {
    public ExistingUserException(String string) {
        super(string);
    }
}
