package com.refactoring.rental.rental_service.exception;

public class InvalidRentPeriodException extends RuntimeException{
    public InvalidRentPeriodException(String message){
        super(message);
    }
}
