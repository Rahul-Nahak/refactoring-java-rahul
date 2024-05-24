package com.refactoring.rental.rental_service.util;

import com.refactoring.rental.rental_service.entity.MovieEntity;
import com.refactoring.rental.rental_service.model.MovieRental;
import com.refactoring.rental.rental_service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class BuildStatementUtil {

    private static MovieRepository movieRepository;

    @Autowired
    public BuildStatementUtil(MovieRepository movieRepository) {
        BuildStatementUtil.movieRepository = movieRepository;
    }
    public static String generateRentStatement(String customerName, List<MovieRental> movieList){

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder rentSlip = new StringBuilder("Rental Report for "+customerName).append("\n\n");
        // header for details section
        rentSlip.append(String.format("%-40.40s %4s %-8s\n", "Movie Title", "Days", "Price"));
        for (MovieRental rental : movieList) {
            double thisAmount = 0;

            String movieId = rental.getMovieId();
            MovieEntity movieDetails = movieRepository.findById(movieId).orElseThrow();;

            String priceCode = movieDetails.getPriceCode();

            // determine amount for each movie
            switch( priceCode.toLowerCase()) {
                case "regular":
                    thisAmount = 2;
                    if (rental.getRentPeriod() > 2) thisAmount += 1.5*(rental.getRentPeriod()-2);
                    break;
                case "children":
                    thisAmount = 1.5;
                    if (rental.getRentPeriod() > 3) thisAmount += 1.5*(rental.getRentPeriod()-3);
                    break;
                case "new release":
                    thisAmount = 3*rental.getRentPeriod();
                    break;
                default:
                    getLogger().warning("Movie "+movieDetails.getMovieName()+" has unrecognized priceCode "+movieDetails.getPriceCode());
            }


            // add bonus for a two days or more new release rental
            if ((movieDetails.getPriceCode().equals(priceCode.toLowerCase()) ) && rental.getRentPeriod() >= 2) frequentRenterPoints += rental.getRentPeriod();
            else frequentRenterPoints++;

            //print figures for this rental
            rentSlip.append(String.format("%-40.40s %3d %8.2f\n", movieDetails.getMovieName(), rental.getRentPeriod(), thisAmount));
            totalAmount = totalAmount + thisAmount;
        }
        // add footer lines
        rentSlip.append( String.format("%-44.44s %8.2f\n", "Total Charges", totalAmount));
        rentSlip.append( String.format("%-44.44s %5d\n","Frequent Renter Points earned", frequentRenterPoints) );

        return rentSlip.toString();
    }

    public static Logger getLogger() {
        return Logger.getLogger(BuildStatementUtil.class.getName());
    }
}
