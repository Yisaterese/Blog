package com.africa.semicolon.blog.exception;

public class InvalidEmailException extends ExistingUserException {
    public InvalidEmailException(String string) {
        super(string);
    }
}
