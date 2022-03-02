package com.company;

public abstract class Movie {
    protected String movieName;
    protected int minAge;
    protected int movieLength;
    private  String movieKind;


    public Movie(String movieName, int minAge, int movieLength,String movieKind) {
        this.movieName = movieName;
        this.minAge = minAge;
        this.movieLength = movieLength;
        this.movieKind = movieKind;
    }

    public boolean checkAge(Customer customer) {
        return (customer.getAge() < minAge);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Movie) {
            return ((Movie) object).getMovieName().equals(movieName);
        }
        return false;
    }

    @Override
    public String toString() {
        return "The movie name is " + movieName + ", the minimal age is " + minAge + ", this is a " + movieKind + " movie, and the movie length is " + movieLength;
    }

    public int getMinAge() {
        return minAge;
    }

    public String getMovieName() {
        return movieName;
    }


}
