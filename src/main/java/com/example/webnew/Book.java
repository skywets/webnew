package com.example.webnew;

import java.time.LocalDate;

public class Book extends PrintedProduct {

    private String author;

    public Book(long numID, String title, String publishingOffice, String author,  int numberOfPages, LocalDate dataOfIssue
                ) {
        super(numID, numberOfPages, title, publishingOffice, dataOfIssue);
        this.type = ProductType.BOOK;
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + " Author " + author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
