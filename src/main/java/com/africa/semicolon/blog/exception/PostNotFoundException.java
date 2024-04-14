package com.africa.semicolon.blog.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String string) {
        super(string);
    }
}
