package com.company;

import java.time.LocalDate;

public class Goods {
    private int id;
    private String name;
    private double price;
    private LocalDate expirationDate;

    public Goods(int id, String name, double price, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public int getId(){
        return this.id;
    }

    public LocalDate getExpirationDate(){
        return expirationDate;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }
}
