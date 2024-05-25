package com.refactoring.rental.rental_service.exception;

public class InvalidMovieCodeException extends RuntimeException{
    public InvalidMovieCodeException(String message){
        super(message);
    }
}
