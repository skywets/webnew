package com.example.webnew;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static com.example.webnew.DeleteElements.deleteElement;
import static com.example.webnew.FindElements.findElement;

public class Displaying {

    public static void display(){
        while (true) {
            displayMethod(0);
            Scanner scanner = new Scanner(System.in);
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    displayMethod(1);
                    printingElement();
                    break;
                case 2:
                    displayMethod(2);
                    createProduct(scanner.nextInt());
                    break;
                case 3:
                    displayMethod(3);
                    deleteElement(scanner.nextLong());
                    break;
                case 4:
                    displayMethod(4);
                    findElement(scanner.nextLong());
                    break;
                case 5:
                    displayMethod(5);
                    redactionElement(scanner.nextLong());
                    break;
            }
        }
    }

    static PostgresSQLStorage st = PostgresSQLStorage.getInstance();
    public static void printingElement() {
        try {
            List<PrintedProduct> list = st.showAllEl();
            for (PrintedProduct str: list) {
                System.out.println(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static CreatorFactory creatorFactory = new CreatorFactory();

    public static void createProduct(int n) {
        Scanner scanner = new Scanner(System.in);
        ProductType type = ProductType.fromValue(n);
        PrintedProductCreator creator = creatorFactory.getCreator(type);
        PrintedProduct pp = creator.create(scanner);
        st.addElements(pp);
    }

    static EditorFactory factory = new EditorFactory();

    public static void redactionElement(long id) {
        Scanner scanner = new Scanner(System.in);
        PrintedProduct pp = st.findElements(id);
        ProductEditor editor = factory.getEditor(pp.getType());
        editor.edit(pp, scanner);
        st.updateElements(pp);
    }

    public static void displayMethod(int n){
        if (n==0){
            System.out.println("Enter what do you want");
            System.out.println("SHOWALLPRODUCTS = 1");
            System.out.println("ADDELEMENT = 2");
            System.out.println("DELETEELEMENT = 3");
            System.out.println("FINDELEMENT = 4");
            System.out.println("UPDATEELEMENT = 5");
        }else if (n==1){
            System.out.println("Вы ввели ShOWELEMENT");
        }else if (n==2){
            System.out.println("Вы ввели ADDELEMENT");
            System.out.println("Chooso type product");
            System.out.println("Book = 1");
            System.out.println("Newspaper = 2");
            System.out.println("Magazine = 3");
        }else if (n==3){
            System.out.println("Вы ввели DELETEELEMENT\n  Вводите id");
        }else if (n==4){
            System.out.println("Вы ввели FINDELEMENT\n Вводите id");
        }else if (n==5){
            System.out.println("Вы ввели UPDATEELEMENT");
        }

    }
}
