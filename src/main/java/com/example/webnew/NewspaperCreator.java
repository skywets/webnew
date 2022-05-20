package com.example.webnew;

import java.time.LocalDate;
import java.util.Scanner;

public class NewspaperCreator implements PrintedProductCreator {
    String author, title, publishingOffice;
    Long id;
    int numberOfPages, number;
    @Override
    public PrintedProduct create(Scanner scanner) {
        System.out.println("Вы выбрали  NEWSPAPER");
        System.out.println("Заполните информацию о товаре ");
        System.out.println("ВВедите дата выпуска товара");
        LocalDate dq = LocalDate.parse(scanner.nextLine());
        System.out.println("ВВедите номер товара");
        number = scanner.nextInt();
        System.out.println("ВВедите ID товара");
        id = scanner.nextLong();
        System.out.println("ВВедите количество страниц товара");
        numberOfPages = scanner.nextInt();
        System.out.println("ВВедите название товара");
        title = scanner.nextLine();
        System.out.println("ВВедите издательство товара");
        publishingOffice = scanner.nextLine();
        return new Newspaper(dq, number, id, numberOfPages, title, publishingOffice);
    }
}
