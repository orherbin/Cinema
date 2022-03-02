package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Customer {
    protected String name;
    protected int id;
    protected String email;
    protected String phoneNumber;
    protected int age;

    public Customer(String name, int id, String email, String phoneNumber, int age) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Movie chooseMovie(ArrayList<Movie> listOfMovies) {
        ArrayList<Movie> availableMovies = new ArrayList<>();
        for (Movie movie : listOfMovies) {
            if (movie.getMinAge() <= age) {
                availableMovies.add(movie);
            }
        }
        Random rand = new Random();
        if (availableMovies.size() == 0) {
            System.out.println("You are underage.");
            return null;

        }
        int movieIndex = rand.nextInt(availableMovies.size());
        System.out.println("The selected movie is: " + listOfMovies.get(movieIndex).getMovieName());

        return listOfMovies.get(movieIndex);
    }

    public String popcornSelection() {
        Random num = new Random();
        int popcornIndex = num.nextInt(3);
        if (popcornIndex == 0) return ("Small popcorn");
        if (popcornIndex == 1) return ("Medium popcorn");
        return ("Big popcorn");
    }

    public int discount(int totalPrice) {
        return totalPrice;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Customer) {
            return ((Customer) object).getId() == id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "The customer name is " + name + ", he is " + age + " years old, and his phone number is: " + phoneNumber;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
