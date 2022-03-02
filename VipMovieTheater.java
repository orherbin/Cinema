package com.company;

public class VipMovieTheater extends MovieTheater{

    private static final int rows = 8;
    private static final int chairsPerRow = 12;
    private static final int ticketPrice = 67;

    public VipMovieTheater(int theaterNumber) {
        super(theaterNumber, rows, chairsPerRow);
    }

    @Override
    public int ticketPrice() {
        return ticketPrice;
    }
}
