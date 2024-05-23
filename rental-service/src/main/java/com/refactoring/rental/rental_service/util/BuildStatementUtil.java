package com.refactoring.rental.rental_service.util;

import com.refactoring.rental.rental_service.domain.RentRequest;
import com.refactoring.rental.rental_service.model.Movie;
import com.refactoring.rental.rental_service.util.constants.Constants;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.logging.Logger;

@UtilityClass
public class BuildStatementUtil {

    public String generateRentStatement(String customerName, List<Movie> movieList){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder rentSlip = new StringBuilder("Rental Report for "+customerName).append("\n\n");
        // header for details section
        rentSlip.append(String.format("%-40.40s %4s %-8s\n", "Movie Title", "Days", "Price"));
        for (Movie rental : movieList) {
            double thisAmount = 0;

            // determine amount for each movie
            switch( rental.getPriceCode() ) {
                case Constants.REGULAR:
                    thisAmount += 2;
                    if (rental.getRentPeriod() > 2) thisAmount += 1.5*(rental.getRentPeriod()-2);
                    break;
                case Constants.CHILDRENS:
                    thisAmount = 1.5;
                    if (rental.getRentPeriod() > 3) thisAmount += 1.5*(rental.getRentPeriod()-3);
                    break;
                case Constants.NEW_RELEASE:
                    thisAmount = 3*rental.getRentPeriod();
                    break;
                default:
                    getLogger().warning("Movie "+rental.getTitle()+" has unrecognized priceCode "+rental.getPriceCode());
            }


            // add bonus for a two days or more new release rental
            if ((rental.getPriceCode() == Constants.NEW_RELEASE) && rental.getRentPeriod() >= 2) frequentRenterPoints += rental.getRentPeriod();
            else frequentRenterPoints++;

            //print figures for this rental
            rentSlip.append(String.format("%-40.40s %3d %8.2f\n", rental.getTitle(), rental.getRentPeriod(), thisAmount));
            totalAmount = totalAmount + thisAmount;
        }
        // add footer lines
        rentSlip.append( String.format("%-44.44s %8.2f\n", "Total Charges", totalAmount));
        rentSlip.append( String.format("%-44.44s %5d\n","Frequent Renter Points earned", frequentRenterPoints) );

        return rentSlip.toString();
    }

    private static Logger getLogger() {
        return Logger.getLogger(BuildStatementUtil.class.getName());
    }
}
