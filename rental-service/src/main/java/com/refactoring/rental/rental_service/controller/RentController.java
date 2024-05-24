package com.refactoring.rental.rental_service.controller;

import com.refactoring.rental.rental_service.domain.RentRequest;
import com.refactoring.rental.rental_service.service.RentalServiceInterface;
import com.refactoring.rental.rental_service.service.impl.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentController {

    @Autowired
    RentalServiceInterface rentalService;

    @RequestMapping(value="/rent", consumes = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<String> getCustomerRequest(@RequestBody RentRequest rentRequest){
        String rentalSlip = rentalService.rentalSlipService(rentRequest);
        return ResponseEntity.ok(rentalSlip);
    }

}
