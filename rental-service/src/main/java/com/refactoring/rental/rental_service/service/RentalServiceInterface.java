package com.refactoring.rental.rental_service.service;

import com.refactoring.rental.rental_service.domain.CustomerDetails;

public interface RentalServiceInterface {
    String rentalSlipService(CustomerDetails customerDetails);
}
