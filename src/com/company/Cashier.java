package com.company;

public class Cashier {
    private static int cashiers = 0;
    private int id;
    private String firstName;
    private String lastName;

    public Cashier(String firstName, String lastName) {
        cashiers++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = cashiers;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public int getId(){
        return this.id;
    }

    public void readReceipt(String filePath, String fileName){

    }
}
