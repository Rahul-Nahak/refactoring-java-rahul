package com.refactoring.rental.rental_service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="movie_table")
public class MovieEntity {
    @Id
    @Column(name = "movie_id")
    private String movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "price_code")
    private String priceCode;

}
