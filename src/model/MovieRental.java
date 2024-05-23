package model;
/**
 * A rental of a movie by customer.
 *
 * Rental should have fields and methods for the days
 * that the movie was rented and returned.
 */

public class MovieRental {
    private Movie movie;
    private int days;

    /** Initialize a new movie rental object for
     * a movie with known rental period .
     */
    public MovieRental(Movie movie, int days) {
        this.movie = movie;
        this.days = days;
    }

    /**
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * @return the rental period
     */
    public int getDays() {
        return days;
    }
}
