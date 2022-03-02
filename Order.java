package com.company;

import java.util.Objects;

public class Order {
    private String movieName;
    private int theaterNumber;
    private int rowNumber;
    private int seatNumber;
    private int totalPrice;

    public Order(String movieName, int theaterNumber, int rowNumber, int seatNumber, int totalPrice) {
        this.movieName = movieName;
        this.theaterNumber = theaterNumber;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "You made an order for the movie " + movieName + ", in theater number " + theaterNumber + ".\n"
                + "Your sit is in row " + rowNumber + " and seat number " + seatNumber +
                ".\n" + "Overall the total price is " + totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Order) {
            Order order = (Order) o;
            return theaterNumber == order.theaterNumber && rowNumber == order.rowNumber && seatNumber == order.seatNumber && totalPrice == order.totalPrice && Objects.equals(movieName, order.movieName);
        }
        return false;
    }
}
