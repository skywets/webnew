package com.example.webnew;

import java.sql.Date;
import java.time.LocalDate;

public abstract class PrintedProduct {

    private long numID;
    private String title;//название
    private String publishingOffice;//издательство
    private int numberOfPages;//количество страниц
    private LocalDate dataOfIssue;//дата выпуска
    protected ProductType type;


    public PrintedProduct(long numID, int numberOfPages, String title, String publishingOffice, LocalDate dataOfIssue) {
        this.numID = numID;
        this.title = title;
        this.publishingOffice = publishingOffice;
        this.numberOfPages = numberOfPages;
        this.dataOfIssue = dataOfIssue;
    }

    public PrintedProduct(String title, LocalDate createdAT, String publishingOffice, LocalDate dataOfIssue, int numberOfPages) {
    }

    public String toString() {
        return "ID=" + numID +
                ", numberOfPages=" + numberOfPages +
                ", title=" + title +
                ", publishingOffice=" +
                publishingOffice +
                ", dataOfIssue=" + dataOfIssue + " ";
    }

    public long getNumID() {
        return numID;
    }

    public void setNumID(long numID) {
        this.numID = numID;
    }

    public ProductType getType() {
        return type;
    }
    public int num(int n){
        return n;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    public Date getDataOfIssue() {
        return Date.valueOf(dataOfIssue);
    }

    public void setDataOfIssue(LocalDate dataOfIssue) {
        this.dataOfIssue = dataOfIssue;
    }

}
