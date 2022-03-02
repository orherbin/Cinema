package com.company;

public class BigMovieTheater extends MovieTheater{

    private static final int rows = 16;
    private static final int chairsPerRow = 20;
    private static final int ticketPrice = 42;

    public BigMovieTheater(int theaterNumber, boolean available) {
        super(theaterNumber, rows, chairsPerRow);
    }

    @Override
    public int ticketPrice() {
        return ticketPrice;
    }
}
