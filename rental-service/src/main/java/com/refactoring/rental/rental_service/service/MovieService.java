package com.refactoring.rental.rental_service.service;

import com.refactoring.rental.rental_service.entity.MovieEntity;
import com.refactoring.rental.rental_service.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieEntity findById(String movieId){
        return movieRepository.findById(movieId).orElse(null);
    }
}
