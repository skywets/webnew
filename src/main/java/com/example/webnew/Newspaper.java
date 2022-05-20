package com.example.webnew;

import java.time.LocalDate;

public class Newspaper extends PrintedProduct {

    private int number;

    public Newspaper(LocalDate dataOfIssue, int number, long numID, int numberOfPages, String title,
                     String publishingOffice) {
        super(numID, numberOfPages, title, publishingOffice, dataOfIssue);
        this.type = ProductType.NEWSPAPER;
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + "Number" + number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
