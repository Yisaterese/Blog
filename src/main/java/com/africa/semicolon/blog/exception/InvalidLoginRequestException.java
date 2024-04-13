package com.africa.semicolon.blog.exception;

public class InvalidLoginRequestException extends ExistingUserException{
    public InvalidLoginRequestException(String message){
        super(message);
    }
}
