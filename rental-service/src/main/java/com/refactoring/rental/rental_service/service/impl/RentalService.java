package com.refactoring.rental.rental_service.service.impl;

import com.refactoring.rental.rental_service.domain.CustomerDetails;
import com.refactoring.rental.rental_service.model.MovieRental;
import com.refactoring.rental.rental_service.service.RentalServiceInterface;
import com.refactoring.rental.rental_service.util.BuildStatementUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService implements RentalServiceInterface {

    BuildStatementUtil buildStatementUtil;

    public String rentalSlipService(CustomerDetails rentRequest) {
        String customerName = rentRequest.getCustomerName();
        List<MovieRental> movieList = rentRequest.getMovieList();
        String rentalSlip = buildStatementUtil.generateRentStatement(customerName, movieList);
        return rentalSlip;
    }
}
