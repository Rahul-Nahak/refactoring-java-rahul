package com.refactoring.rental.rental_service.service;

import com.refactoring.rental.rental_service.domain.RentRequest;
import com.refactoring.rental.rental_service.model.Movie;
import com.refactoring.rental.rental_service.util.BuildStatementUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    BuildStatementUtil buildStatementUtil;

    public void rentalSlipService(RentRequest rentRequest) {
        String customerName = rentRequest.getCustomerName();
        List<Movie> movieList = rentRequest.getMovieList();
        System.out.println(buildStatementUtil.generateRentStatement(customerName, movieList));
    }
}
