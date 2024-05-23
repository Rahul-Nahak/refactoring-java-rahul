package com.refactoring.rental.rental_service.domain;

import com.refactoring.rental.rental_service.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RentRequest {
    private String customerName;
    private List<Movie> movieList;
}
