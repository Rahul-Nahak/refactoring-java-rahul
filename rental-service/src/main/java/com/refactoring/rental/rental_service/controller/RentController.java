package com.refactoring.rental.rental_service.controller;

import com.refactoring.rental.rental_service.domain.RentRequest;
import com.refactoring.rental.rental_service.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentController {

    @Autowired
    RentalService rentalService;

    @RequestMapping(value="/rent", consumes = {"application/json"}, method = RequestMethod.POST)
    public void getCustomerRequest(@RequestBody RentRequest rentRequest){
        rentalService.rentalSlipService(rentRequest);
    }

}
