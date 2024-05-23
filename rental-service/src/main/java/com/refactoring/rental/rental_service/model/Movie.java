package com.refactoring.rental.rental_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Movie {
    /** the title of movie */
    private String title;

    /** movie price code based on classification */
    private int priceCode;

    /** Duration of rent */
    private int rentPeriod;
}
