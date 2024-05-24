package com.refactoring.rental.rental_service.service;

import com.refactoring.rental.rental_service.domain.RentRequest;

public interface RentalServiceInterface {
    String rentalSlipService(RentRequest rentRequest);
}
