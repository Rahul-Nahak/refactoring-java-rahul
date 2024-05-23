package model;

/**
 * A movie available for rent.
 */
public class Movie {

    /** the title of movie */
    private String title;

    /** movie price code based on classification */
    private int priceCode;

    /** Initialize a new movie. */
    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    /**
     * @return the movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the price code
     */
    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
