package com.refactoring.rental.rental_service.domain;

import com.refactoring.rental.rental_service.model.MovieRental;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * to build user input
 */
@Getter
@Setter
@AllArgsConstructor
public class CustomerDetails {
    private String customerName;
    private List<MovieRental> movieList;
}
