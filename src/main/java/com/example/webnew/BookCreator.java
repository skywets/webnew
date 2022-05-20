package com.example.webnew;
import java.time.LocalDate;
import java.util.Scanner;
public class BookCreator implements PrintedProductCreator {
    String author, title, publishingOffice;
    Long id;
    int numberOfPages;
    @Override
    public PrintedProduct create( Scanner scanner) {
        System.out.println("Вы выбрали  BOOK");
        System.out.println("Заполните информацию о товаре ");
        System.out.println("ВВедите дата выпуска товара");
        LocalDate dq = LocalDate.parse(scanner.nextLine());
        System.out.println("ВВедите автор товара");
        author = scanner.nextLine();
//        System.out.println("ВВедите ID товара");
//        id = scanner.nextLong();
        System.out.println("ВВедите количество страниц товара");
        numberOfPages = scanner.nextInt();
        System.out.println("ВВедите название товара");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();
        scanner = new Scanner(System.in);
        System.out.println("ВВедите издательство товара");
        publishingOffice = scanner.nextLine();
        return new Book(0, title, publishingOffice,  author,  numberOfPages, dq );
    }
}
