package com.refactoring.rental.rental_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Movie Rental class contains the movieId and rent duration
 * selected by the customer.
 */
@Getter
@Setter
@AllArgsConstructor
public class MovieRental {
    /** Id of the movie for rent */
    String movieId;
    /** Duration of rent */
    private int rentPeriod;
}
