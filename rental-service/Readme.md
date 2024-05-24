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

## Solution Added :

Converted the simple java application into a springboot Application.
Added maven and spring boot dependencies to the pom.xml.
Rest Controller has been implemented to get a POST request through RestAPI.
Implemented service class to generate movie rental slip.
Implemented logic in util class.
All the constant values will be stored in Constants class of the constant pakage.
Added spring Data JPA and dependency in pom.xml file.
Implemented H2 database in the project as runtime database and initialze the database in data.sql file.
Implemented entity and repository class for Movie details
URL to send Post request : "http://localhost:8080/rent" Default port is 8080, if you are running in different port change accordingly.
Example of RestAPI request body :
{"customerName": "Rahul","movieList": [{"movieId": "F001","rentPeriod": 30}]}

## TO DO:
Implementation of database.
Implementation of data jpa concept in the application to build communication with database.
Exception handling
Movie Validation, Price Code Validation and Customer validation