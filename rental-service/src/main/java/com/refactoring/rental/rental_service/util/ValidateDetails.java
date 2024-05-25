package com.refactoring.rental.rental_service.util;

import com.refactoring.rental.rental_service.domain.CustomerDetails;
import com.refactoring.rental.rental_service.exception.InvalidCustomerException;
import com.refactoring.rental.rental_service.exception.InvalidMovieCodeException;
import com.refactoring.rental.rental_service.exception.InvalidRentPeriodException;
import com.refactoring.rental.rental_service.model.MovieRental;
import com.refactoring.rental.rental_service.repository.MovieRepository;
import com.refactoring.rental.rental_service.util.constants.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ValidateDetails {


    private static MovieRepository movieRepository;

    @Autowired
    public ValidateDetails(MovieRepository movieRepository) {
        ValidateDetails.movieRepository = movieRepository;
    }

    public void validateUserInput(CustomerDetails customerDetails){
        String customerName = customerDetails.getCustomerName();
        if (isInvalidCustomer(customerName)) {
            throw new InvalidCustomerException(ConstantsUtil.INVALID_CUSTOMER_EXCEPTION_MESSAGE);
        }
        isValidMovieDetails(customerDetails.getMovieList());
    }
    public boolean isInvalidCustomer(String customerName){
        return customerName.isEmpty() || customerName.equals(" ");
    }

    public void isValidMovieDetails(List<MovieRental> movieList){
        for(MovieRental movie : movieList){
            String movieId = movie.getMovieId();
            if(movieId.isBlank() || movieId.isEmpty()){
                throw new InvalidMovieCodeException(ConstantsUtil.EMPTY_MOVIE_CODE_EXCEPTION_MESSAGE);
            }
            movieRepository.findById(movieId).orElseThrow(()->
                 new InvalidMovieCodeException(ConstantsUtil.INVALID_MOVIE_CODE_EXCEPTION_MESSAGE + movieId));
            if(movie.getRentPeriod() <= 0){
                throw new InvalidRentPeriodException(movie.getRentPeriod() + ConstantsUtil.INVALID_RENT_PERIOD_EXCEPTION_MESSAGE + movie.getMovieId());
            }

        }
    }
}
