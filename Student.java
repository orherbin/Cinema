package com.company;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Student extends Customer {

    private String school;
    private LocalDate graduationDate;

    public Student(String name, int id, String email, String phoneNumber, int age, String school, LocalDate graduationDate) {
        super(name, id, email, phoneNumber, age);
        this.school = school;
        this.graduationDate = graduationDate;
    }

    @Override
    public int discount(int totalPrice) {
        if (isStillStudent()) {
            return totalPrice / 2;
        }
        return totalPrice;
    }

    private boolean isStillStudent() {
        return graduationDate.isAfter(LocalDate.now());
    }
}
