package com.company;

public class CustomException extends Exception {
    private String description;

    public CustomException(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
