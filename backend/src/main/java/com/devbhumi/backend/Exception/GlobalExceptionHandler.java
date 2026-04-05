package com.devbhumi.backend.Exception;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    //fields validation handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    //Supplier not found handler
    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<String> handleSupplierNotFound(SupplierNotFoundException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());

    }

    //Milk collection not found handler
    @ExceptionHandler(MilkCollectionNotFoundException.class)
    public ResponseEntity<String> handleMilkCollectionNotFound(MilkCollectionNotFoundException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    //Daily summary not found handler
    @ExceptionHandler(DailySummaryNotFoundException.class)
    public ResponseEntity<String> handleDailySummaryNotFound(DailySummaryNotFoundException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    //Milk collection already exists handler (for unique constraint)
    @ExceptionHandler(MilkCollectionAlreadyExistsException.class)
    public ResponseEntity<String> handleMilkCollectionAlreadyExists(MilkCollectionAlreadyExistsException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    //Daily summary already exists handler
    @ExceptionHandler(DailySummaryAlreadyExistsException.class)
    public ResponseEntity<String> handleDailySummaryAlreadyExists(DailySummaryAlreadyExistsException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    //Invalid data handler
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> handleInvalidData(InvalidDataException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    //Database integrity violation handler (e.g., unique constraints)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex){
        return ResponseEntity.badRequest().body("Data integrity violation: " + ex.getMostSpecificCause().getMessage());
    }

    //General exception handler for unexpected errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }

}
