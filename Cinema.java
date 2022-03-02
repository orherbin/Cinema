package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Cinema {
    private String cinemaName;
    private ArrayList<Employee> listOfEmployees;
    private ArrayList<Customer> listOfCustomers;
    private Movie movies[];
    private int moviesCounter;
    private MovieTheater theaters[];
    private int theatersCounter;
    public static final int smallPopcornPrice = 10;
    public static final int mediumPopcornPrice = 15;
    public static final int bigPopcornPrice = 20;


    public Cinema(String cinemaName, ArrayList<Employee> listOfEmployees, ArrayList<Customer> listOfCustomers, int numberOfMovies, int numberOfTheaters) {
        this.cinemaName = cinemaName;
        this.listOfEmployees = listOfEmployees;
        this.listOfCustomers = listOfCustomers;
        this.movies = new Movie[numberOfMovies];
        this.moviesCounter = 0;
        this.theaters = new MovieTheater[numberOfTheaters];
        for (int i = 0; i < numberOfTheaters; i++) {
            Random rand = new Random();
            int num = rand.nextInt(3);
            switch (num) {
                case 0 -> theaters[i] = new SmallMovieTheater(num, true);
                case 1 -> theaters[i] = new BigMovieTheater(num, true);
                case 2 -> theaters[i] = new VipMovieTheater(num);
            }
        }
    }


    public void addMovie(Movie newMovie) {
        for (Movie movie : movies) {
            if (newMovie.equals(movie)) {
                System.out.println("The requested movie is already in theaters.");
                return;
            }
        }
        if (moviesCounter == movies.length) {
            System.out.println("There is no more place for new movies.");
            return;
        }
        int numberOfAvailableTheaters = 0;
        for (MovieTheater theater : theaters) {
            if (theater.getPresentedMovie() == null) {
                numberOfAvailableTheaters++;
            }
        }
        if (numberOfAvailableTheaters == 0) {
            System.out.println("All theaters present movies.");
            return;
        }
        movies[moviesCounter] = newMovie;
        moviesCounter++;

        int maxNumberOfInsertionTheaters = movies.length / theaters.length;

        int numberOfNextInsertion = Math.min(maxNumberOfInsertionTheaters, numberOfAvailableTheaters);
        for (int i = 0; i < theaters.length && numberOfNextInsertion > 0; i++) {
            if (theaters[i].getPresentedMovie() == null) {
                theaters[i].movieUpdate(newMovie);
                numberOfNextInsertion--;
            }
        }
    }

    public void updateMovie(String oldMovie, Movie newMovie) {
        boolean isMovieFound = false;
        for (int i = 0; i < movies.length && !isMovieFound; i++) {
            Movie movie = movies[i];
            if (movie != null && oldMovie.equals(movie.getMovieName())) {
                isMovieFound = true;
                movies[i] = newMovie;
                for (MovieTheater theater : theaters) {
                    if (theater != null && theater.getPresentedMovie() != null && oldMovie.equals(theater.getPresentedMovie().getMovieName())) {
                        theater.movieUpdate(newMovie);
                    }
                }
            }

        }
        if (!isMovieFound) {
            System.out.println("The requested movie is not presented in the cinema");
        }
    }

    public void addEmployee(Employee newEmployee) {
        for (Employee listOfEmployee : listOfEmployees) {
            if (newEmployee.equals(listOfEmployee)) {
                System.out.println("The employee already exists.");
                return;
            }
        }
        listOfEmployees.add(newEmployee);
    }

    public void removeEmployee(int employeeId) {
        for (int i = 0; i < listOfEmployees.size(); i++) {
            if (listOfEmployees.get(i).getId() == employeeId) {
                listOfEmployees.remove(i);
                return;
            }
        }
        System.out.println("The employee doesn't exists in our records.");
    }

    public void ticketSell(Movie requestedMovie) {
        Random customerNumber = new Random();
        Random employeeNumber = new Random();
        int customerIndex = customerNumber.nextInt(listOfCustomers.size());
        int employeeIndex = employeeNumber.nextInt(listOfEmployees.size());

        Employee employee = this.listOfEmployees.get(employeeIndex);
        Customer customer = this.listOfCustomers.get(customerIndex);
        Order order = employee.ticketSell(customer, requestedMovie, this.theaters);

        if (order == null) {
            System.out.println("The requested movie could not be found on our theaters at the moment.");
            return;
        }

        System.out.println(employee);
        System.out.println(customer);
        System.out.println(order);
    }

    public void popcornSell() {
        Random customerNumber = new Random();
        Random employeeNumber = new Random();
        int customerIndex = customerNumber.nextInt(listOfCustomers.size());
        int employeeIndex = employeeNumber.nextInt(listOfEmployees.size());

        String customerPopcornType = listOfCustomers.get(customerIndex).popcornSelection();

        if (customerPopcornType.contains("Small")) {
            listOfEmployees.get(employeeIndex).popcornSell("Small", smallPopcornPrice, listOfCustomers.get(customerIndex));
            System.out.println(listOfEmployees.get(employeeIndex));
            System.out.println(listOfCustomers.get(customerIndex));
            System.out.println("The chosen popcorn size is small, and the price is " + smallPopcornPrice);
        } else if (customerPopcornType.contains("Medium")) {
            listOfEmployees.get(employeeIndex).popcornSell("Medium", mediumPopcornPrice, listOfCustomers.get(customerIndex));
            System.out.println(listOfEmployees.get(employeeIndex));
            System.out.println(listOfCustomers.get(customerIndex));
            System.out.println("The chosen popcorn size is medium, and the price is " + mediumPopcornPrice);
        } else {
            listOfEmployees.get(employeeIndex).popcornSell("Big", bigPopcornPrice, listOfCustomers.get(customerIndex));
            System.out.println(listOfEmployees.get(employeeIndex));
            System.out.println(listOfCustomers.get(customerIndex));
            System.out.println("The chosen popcorn size is big, and the price is " + bigPopcornPrice);
        }

    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Cinema) {
            return ((Cinema) object).cinemaName.equals(cinemaName);
        }
        return false;
    }

    @Override
    public String toString() {
        return "The cinema name is " + cinemaName + ", it has " + theaters.length + " movie theaters and " + moviesCounter + " movies presented. ";
    }
}
