package com.company;

public class CapacityLimitException extends RuntimeException {
    public CapacityLimitException(String message) {
        super(message);
    }
}
