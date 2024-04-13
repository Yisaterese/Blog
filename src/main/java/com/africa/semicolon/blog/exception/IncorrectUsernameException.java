package com.africa.semicolon.blog.exception;

public class IncorrectUsernameException extends ExistingUserException{
    public IncorrectUsernameException(String message){
        super(message);
    }
}
