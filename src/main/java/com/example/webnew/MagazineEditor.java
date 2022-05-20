package com.example.webnew;

import java.util.Scanner;

public class MagazineEditor implements ProductEditor {
    @Override
    public void edit(PrintedProduct pp, Scanner scanner) {
        pp.setTitle(scanner.nextLine());
        pp.setPublishingOffice(scanner.nextLine());
        pp.setNumberOfPages(scanner.nextInt());
        pp.setNumID(scanner.nextLong());
        ((Magazine) pp).setNumber(scanner.nextInt());
    }
}
