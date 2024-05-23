import model.Customer;
import model.Movie;
import model.MovieRental;
import util.Constants;

public class Main {

  public static void main(String[] args) {

    Movie[] movies = new Movie[] {
            new Movie("You've Got Mail", Constants.REGULAR),
            new Movie("Matrix", Constants.REGULAR),
            new Movie("Cars", Constants.CHILDRENS),
            new Movie("Fast & Furious X", Constants.NEW_RELEASE)
    };

    Customer customer = new Customer("C. U. Stomer");
    for(Movie m : movies){
      customer.addRentals(new MovieRental(m, Constants.RENTAL_PERIOD));
    }
    System.out.println( customer.statement());
  }
}
