package com.refactoring.rental.rental_service.service.impl;

import com.refactoring.rental.rental_service.domain.CustomerDetails;
import com.refactoring.rental.rental_service.model.MovieRental;
import com.refactoring.rental.rental_service.service.RentalServiceInterface;
import com.refactoring.rental.rental_service.util.BuildStatementUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements rental service interface
 * service to process user input and generate slip
 */

@Service
public class RentalService implements RentalServiceInterface {

    BuildStatementUtil buildStatementUtil;

    public String rentalSlipService(CustomerDetails rentRequest) {
        String customerName = rentRequest.getCustomerName(); //get name of the user from json
        List<MovieRental> movieList = rentRequest.getMovieList(); // get list of movie details
        String rentalSlip = buildStatementUtil.generateRentStatement(customerName, movieList);
        return rentalSlip;
    }
}
