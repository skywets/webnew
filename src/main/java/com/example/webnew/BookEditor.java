package com.example.webnew;

import com.example.webnew.db.jdbc_dao.BaseSQLBuilder;
import com.example.webnew.db.jdbc_dao.SQLBookBulder;

import java.time.LocalDate;
import java.util.Scanner;

public class BookEditor implements ProductEditor  {

    BaseSQLBuilder bs = new SQLBookBulder();
    @Override
    public void edit(PrintedProduct pt, Scanner scanner) {
        System.out.println("ВВедите дата выпуска товара");
        pt.setDataOfIssue(LocalDate.parse(scanner.nextLine()));
        System.out.println("ВВедите название товара");
        pt.setTitle(scanner.nextLine());
        System.out.println("ВВедите издательство товара");
        pt.setPublishingOffice(scanner.nextLine());
        System.out.println("ВВедите количество страниц товара");
    pt.setNumberOfPages(scanner.nextInt());
//        System.out.println("ВВедите ID товара");
//        pt.setNumID(scanner.nextLong());
        System.out.println("ВВедите автор товара");
        scanner = new Scanner(System.in);
        ((Book) pt).setAuthor(scanner.nextLine());

    }
}
