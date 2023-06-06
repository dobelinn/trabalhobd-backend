package com.trabalhobd.backend.exceptions;

public class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException(final String entityName, final Long id) {
        super("Could not found the specified " + entityName + " id: " + id);
    }
}
