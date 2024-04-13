package com.africa.semicolon.blog.exception;

public class InvalidPasswordException extends ExistingUserException{
    public InvalidPasswordException(String string){
        super(string);
    }
}
