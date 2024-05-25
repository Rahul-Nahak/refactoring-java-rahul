package com.refactoring.rental.rental_service.exception;
/**
 Initialize wrong movie code exception class
 */
public class InvalidMovieCodeException extends RuntimeException{
    public InvalidMovieCodeException(String message){
        super(message);
    }
}
