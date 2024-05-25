package com.refactoring.rental.rental_service.exception;

import com.refactoring.rental.rental_service.util.constants.ConstantsUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * to handle global exception
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnknownException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ConstantsUtil.UNEXPECTED_EXCEPTION_MESSAGE + e.getMessage());
    }

    /**
     * custom exception for invalid customer name
     * @param e
     * @return
     */
    @ExceptionHandler(InvalidCustomerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handleInvalidCustomerException(InvalidCustomerException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstantsUtil.ERROR_MESSAGE + e.getMessage());
    }

    /**
     * custom exception for invalid movie code
     * @param e
     * @return
     */
    @ExceptionHandler(InvalidMovieCodeException.class)
    public ResponseEntity<String> handleInvalidMovieCodeException(InvalidMovieCodeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstantsUtil.ERROR_MESSAGE + e.getMessage());
    }

    /**
     * custom exception for invalid rent period
     * @param e
     * @return
     */
    @ExceptionHandler(InvalidRentPeriodException.class)
    public ResponseEntity<String> handleInvalidMovieException(InvalidRentPeriodException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstantsUtil.ERROR_MESSAGE + e.getMessage());
    }
}
