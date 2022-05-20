package com.example.webnew.db.ITEM;
import java.time.LocalDate;
import java.util.Objects;
public class Item {
    private Long id;
    private String name;
    private LocalDate createdAT;
    private String publishingOffice;//издательство
    private LocalDate dataOfIssue;//дата выпуска
    private int numberOfPages;//количество страниц

    public Item(String name, LocalDate createdAT, String publishingOffice, LocalDate dataOfIssue, int numberOfPages) {
        this.id = id;
        this.name = name;
        this.createdAT = createdAT;
        this.publishingOffice = publishingOffice;
        this.dataOfIssue = dataOfIssue;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return numberOfPages == item.numberOfPages && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(createdAT, item.createdAT) && Objects.equals(publishingOffice, item.publishingOffice) && Objects.equals(dataOfIssue, item.dataOfIssue);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAT, publishingOffice, dataOfIssue, numberOfPages);
    }
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAT=" + createdAT +
                ", publishingOffice='" + publishingOffice + '\'' +
                ", dataOfIssue=" + dataOfIssue +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDate createdAT) {
        this.createdAT = createdAT;
    }

    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    public LocalDate getDataOfIssue() {
        return dataOfIssue;
    }

    public void setDataOfIssue(LocalDate dataOfIssue) {
        this.dataOfIssue = dataOfIssue;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
