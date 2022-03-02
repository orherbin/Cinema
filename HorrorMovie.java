package com.company;

public class HorrorMovie extends Movie {

    private static final int minAge = 18;

    public HorrorMovie(String movieName, int movieLength) {
        super(movieName, minAge, movieLength,"horror");
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
