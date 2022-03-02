package com.company;

public class Veteran extends Customer {

    public Veteran(String name, int id, String email, String phoneNumber, int age) {
        super(name, id, email, phoneNumber, age);
    }

    private boolean isVeteran() {
        return getAge() >= 65;
    }

    @Override
    public int discount(int totalPrice) {
        if (isVeteran()) {
            return totalPrice / 3;
        }
        return totalPrice;
    }
}
