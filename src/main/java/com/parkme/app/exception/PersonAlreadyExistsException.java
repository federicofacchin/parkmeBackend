package com.parkme.app.exception;

public class PersonAlreadyExistsException extends RuntimeException{
    public PersonAlreadyExistsException(String msg) {super(msg);}
}
