package com.example;

public class InvalidStatusCodeException extends Exception{
    public InvalidStatusCodeException(String message) {
        super(message);
    }
}
