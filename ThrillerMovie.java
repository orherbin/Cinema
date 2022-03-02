package com.company;

public class ThrillerMovie extends Movie {

    private static final int minAge = 16;

    public ThrillerMovie(String movieName, int movieLength) {
        super(movieName, minAge, movieLength,"thriller");
    }
}
