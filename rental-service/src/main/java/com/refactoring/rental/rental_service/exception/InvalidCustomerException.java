package com.refactoring.rental.rental_service.exception;
/**
Initialize invalid customer exception class
 */
public class InvalidCustomerException extends RuntimeException{
    public InvalidCustomerException(String message){
        super(message);
    }
}
