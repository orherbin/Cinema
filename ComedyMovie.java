package com.company;

public class ComedyMovie extends Movie{

    private static final int minAge = 0;

    public ComedyMovie(String movieName, int movieLength) {
        super(movieName, minAge, movieLength,"comedy");
    }
}
