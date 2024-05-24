package com.refactoring.rental.rental_service.controller;

import com.refactoring.rental.rental_service.domain.CustomerDetails;
import com.refactoring.rental.rental_service.service.RentalServiceInterface;
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
    public ResponseEntity<String> getCustomerRequest(@RequestBody CustomerDetails customerDetails){
        String rentalSlip = rentalService.rentalSlipService(customerDetails);
        return ResponseEntity.ok(rentalSlip);
    }

}
