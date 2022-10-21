package com.capg.nutritionapp.exception;

public class UserApiRequestException extends RuntimeException{
    public UserApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserApiRequestException(String message) {
        super(message);
    }
}
