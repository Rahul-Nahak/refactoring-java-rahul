package com.refactoring.rental.rental_service.exception;
/**
 Initialize invalid rent duration exception class
 */
public class InvalidRentPeriodException extends RuntimeException{
    public InvalidRentPeriodException(String message){
        super(message);
    }
}
