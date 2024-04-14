package com.africa.semicolon.blog.exception;

public class ExistingPostException extends RuntimeException {
    public ExistingPostException(String string) {
        super(string);
    }
}
