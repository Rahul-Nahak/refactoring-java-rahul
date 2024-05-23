# Refactoring Java

The code creates an information slip about movie rentals.
Rewrite and improve the code after your own liking.

Think: you are responsible for the solution, this is a solution you will have to put your name on.


## Handing in the assignment

Reason how you have been thinking and the decisions you took. 
You can hand in the result any way you feel (git patch, pull-request or ZIP-file).
Note: the Git history must be included.


## To run the test:

```
javac src/*.java
java -cp src Main
```
## Refactor Changes:

Create package for each class type for readability.
In customer class, replace the if else clause with Switch to separate the rent calculation for each type of movie.
Added getLogger() to log if the given price code is not recognized.
Created a class called Constants to keep all the constant values in it.
In main method providing the customer name and movie details as hardcoded.

## More Enhancements:
Adding maven build to the project.
Building springboot application with Rest API
Configure database to store the data such as movie details
Adding test cases to the application