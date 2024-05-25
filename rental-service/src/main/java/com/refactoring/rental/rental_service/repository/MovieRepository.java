package com.refactoring.rental.rental_service.repository;

import com.refactoring.rental.rental_service.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * store movie details such as movie id, movie name and price code
 */
@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, String> {
}
