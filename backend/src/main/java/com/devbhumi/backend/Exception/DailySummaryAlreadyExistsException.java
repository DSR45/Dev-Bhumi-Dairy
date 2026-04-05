package com.devbhumi.backend.Exception;

public class DailySummaryAlreadyExistsException extends RuntimeException {
    public DailySummaryAlreadyExistsException(String message) {
        super(message);
    }
}
