package com.trabalhobd.backend.exceptions;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not found the specified user id: " + id);
    }
}
