package com.company;

import java.util.Arrays;

public abstract class MovieTheater {
    protected int theaterNumber;
    protected Movie presentedMovie;
    protected boolean[][] availableSeat;

    // Constructor for a movie theater, and resetting all the seats to available.
    public MovieTheater(int theaterNumber, int numberOfRows, int charisPerRow) {
        this.theaterNumber = theaterNumber;
        this.availableSeat = new boolean[numberOfRows][charisPerRow];
        for (int i = availableSeat.length - 1; i >= 0; i--) {
            for (int j = availableSeat[i].length - 1; j >= 0; j--) {
                availableSeat[i][j] = true;
            }
        }
    }

    public abstract int ticketPrice();

    // A method for selling a ticket, going over all theater seats from the bottom right.
    public Order ticketSell(Customer customer) {
        int priceAfterDiscount = customer.discount(ticketPrice());
        for (int i = availableSeat.length - 1; i >= 0; i--) {
            for (int j = availableSeat[i].length - 1; j >= 0; j--) {
                if (availableSeat[i][j]) {
                    availableSeat[i][j] = false;
                    return new Order(getPresentedMovie().getMovieName(), theaterNumber, i, j, priceAfterDiscount);
                }
            }
        }
        System.out.println("There is no available seat in the theater.");
        return null;
    }

    // A method for counting the amount of available seats in the theater.
    public int amountOfAvailableSeats() {
        int counter = 0;
        for (boolean[] booleans : availableSeat) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    counter++;
                }
            }
        }
        return counter;
    }


    // Updating a movie to a new one, resetting all the seats to available.
    public void movieUpdate(Movie newMovie) {
        presentedMovie = newMovie;
        for (int i = availableSeat.length - 1; i >= 0; i--) {
            for (int j = availableSeat[i].length - 1; j >= 0; j--) {
                availableSeat[i][j] = true;
            }
        }
    }

    public Movie getPresentedMovie() {
        return presentedMovie;
    }

}
