package com.techbank.cqrs.core.exceptions;

/**
 * @author csgear
 */
public class AggregateNotFoundException extends RuntimeException {
    public AggregateNotFoundException(String message) {
        super(message);
    }
}
