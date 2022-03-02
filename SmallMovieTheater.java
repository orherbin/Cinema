package com.company;

public class SmallMovieTheater extends MovieTheater {

    private static final int rows = 8;
    private static final int chairsPerRow = 10;
    private static final int ticketPrice = 30;

    public SmallMovieTheater(int theaterNumber, boolean available) {
        super(theaterNumber, rows, chairsPerRow);
    }

    @Override
    public int ticketPrice() {
        return ticketPrice;
    }
}
