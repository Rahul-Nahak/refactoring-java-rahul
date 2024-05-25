package com.refactoring.rental.rental_service.controller;

import com.refactoring.rental.rental_service.domain.CustomerDetails;
import com.refactoring.rental.rental_service.model.MovieRental;
import com.refactoring.rental.rental_service.service.RentalServiceInterface;
import com.refactoring.rental.rental_service.util.ValidateDetailsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(RentController.class)
public class RentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RentalServiceInterface rentalServiceInterface;
    @MockBean
    private ValidateDetailsTest validateDetails;
    @InjectMocks
    private RentController rentController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rentController).build();
    }

    @Test
    public void testGetCustomerRequest_ValidInput() throws Exception {
        String customerName = "Rahul";
        List<MovieRental> movieList = List.of(
                new MovieRental("F001", 2)
        );
        CustomerDetails customerDetails = new CustomerDetails(customerName,movieList);
        ResponseEntity<String> actualValue =rentController.getCustomerRequest(customerDetails);
        assertEquals("200 OK",actualValue.getStatusCode().toString());
    }
}
