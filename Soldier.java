package com.company;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Soldier extends Customer {
    private LocalDate endOfService;

    public Soldier(String name, int id, String email, String phoneNumber, int age, LocalDate endOfService) {
        super(name, id, email, phoneNumber, age);
        this.endOfService = endOfService;
    }

    private boolean stillSoldier() {
        return endOfService.isAfter(LocalDate.now());
    }

    @Override
    public int discount(int totalPrice) {
        if (stillSoldier()) {
            return 0;
        }
        return totalPrice;
    }
}
