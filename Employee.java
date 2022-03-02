package com.company;

import java.util.ArrayList;

public class Employee extends Customer {

    private int hoursPerDay[];
    private int hourlyWage;

    // Constructor for an employee.
    public Employee(String name, int id, String email, String phoneNumber, int age, int hoursPerDay[], int hourlyWage) {
        super(name, id, email, phoneNumber, age);
        this.hoursPerDay = hoursPerDay;
        this.hourlyWage = hourlyWage;
    }

    // Overriding the discount method.
    @Override
    public int discount(int totalPrice) {
        return totalPrice;
    }

    // A method for selling a popcorn according to it's size.
    public int popcornSell(String popcornSize, int popcornPrice, Customer orderedCustomer) {
        int pPrice = 0;
        if (popcornSize.contains("Small")) {
            pPrice = Cinema.smallPopcornPrice;
        } else if (popcornSize.contains("Medium")) {
            pPrice = Cinema.mediumPopcornPrice;
        } else if (popcornSize.contains("Big")) {
            pPrice = Cinema.bigPopcornPrice;
        }
        pPrice=  orderedCustomer.discount(pPrice);
        return pPrice;
    }

    //
    public Order ticketSell(Customer customer, Movie movie, MovieTheater[] theater) {

        int maxAvailableSeatsIndex = -1;
        int maxAvailableSeats = -1;
        for (int j = 0; j < theater.length; j++) {
            if (theater[j].getPresentedMovie() != null && theater[j].getPresentedMovie().equals(movie) &&
                    theater[j].amountOfAvailableSeats() > maxAvailableSeats) {
                maxAvailableSeats = theater[j].amountOfAvailableSeats();
                maxAvailableSeatsIndex = j;
            }
        }
        if (maxAvailableSeatsIndex == -1) {
            System.out.println("The requested movie is not presented.");
            return null;
        }
        if (maxAvailableSeats <= 0) {
            System.out.println("We are fully booked.");
            return null;
        }
        return theater[maxAvailableSeatsIndex].ticketSell(customer);
    }


    public int salary() {
        int salary = 0;
        for (int i = 0; i < 30; i++) {
            salary += hoursPerDay[i] * hourlyWage;
        }
        return salary;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Employee) {
            return ((Employee) object).getId() == id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "The employee name is " + name + ", he is " + age + " years old, and his phone number is: " + phoneNumber;
    }
}
