package model;

import util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Customer {
    /** Customer's name. */
    private String name;
    /** Customer's rentals for current billing period. */
    private List<MovieRental> rentals;

    /** Initialize a new customer. */
    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<MovieRental>();
    }

    public String getName() {
        return name;
    }

    public List<MovieRental> getRentals() {
        return rentals;
    }

    public void addRentals(MovieRental rental){
        if(!rentals.contains(rental)){
            rentals.add(rental);
        }
    }

    /** Print all the rentals in current period,
     * along with total charges and reward points.
     * @return the statement as a String
     */
    public String statement() {

        double totalAmount = 0; // total charges
        int frequentRenterPoints = 0; // frequent renter points
        StringBuilder rentSlip = new StringBuilder("Rental Report for "+getName()).append("\n\n");
        // header for details section
        rentSlip.append(String.format("%-40.40s %4s %-8s\n", "Movie Title", "Days", "Price"));
        for (MovieRental rental : getRentals()) {
            double thisAmount = 0;

            // determine amount for each movie
            switch( rental.getMovie().getPriceCode() ) {
                case Constants.REGULAR:
                    thisAmount += 2;
                    if (rental.getDays() > 2) thisAmount += 1.5*(rental.getDays()-2);
                    break;
                case Constants.CHILDRENS:
                    thisAmount = 1.5;
                    if (rental.getDays() > 3) thisAmount += 1.5*(rental.getDays()-3);
                    break;
                case Constants.NEW_RELEASE:
                    thisAmount = 3*rental.getDays();
                    break;
                default:
                    getLogger().warning("Movie "+rental.getMovie()+" has unrecognized priceCode "+rental.getMovie().getPriceCode());
            }


            // add bonus for a two days or more new release rental
            if ((rental.getMovie().getPriceCode() == Constants.NEW_RELEASE) && rental.getDays() >= 2) frequentRenterPoints += rental.getDays();
            else frequentRenterPoints++;

            //print figures for this rental
            rentSlip.append(String.format("%-40.40s %3d %8.2f\n", rental.getMovie().getTitle(), rental.getDays(), thisAmount));
            totalAmount = totalAmount + thisAmount;
        }
        // add footer lines
        rentSlip.append( String.format("%-44.44s %8.2f\n", "Total Charges", totalAmount));
        rentSlip.append( String.format("%-44.44s %5d\n","Frequent Renter Points earned", frequentRenterPoints) );

        return rentSlip.toString();
    }

    /** Get a logger object. */
    private static Logger getLogger() {
        return Logger.getLogger(Customer.class.getName());
    }
}
