package com.example.webnew.db.jdbc_dao;//package com.com.company.db.jdbc_dao;
//
//import com.com.company.Magazine;
//import com.com.company.PrintedProduct;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public class SQLMagazineBuilder extends SQLNewspaperBuilder implements BaseSQLBuilder {
//
//
//    public SQLMagazineBuilder(Long numID, String title, String publishingOffice, Integer number, Integer numberOfPages, LocalDate dataOfIssue) {
//        super(numID, title, publishingOffice, number, numberOfPages, dataOfIssue);
//    }
//
//    @Override
//    public PrintedProduct insert(PrintedProduct object) {
//        Magazine m = (Magazine) object;
//
//        String query  = String.format ("INSERT INTO items(id_p, title, author, publishinghouse, numberofpages, dataofissue) VALUES" +
//                "(" + m.getNumID() + ", " + m.getTitle() + ", " + m.getPublishingOffice() + ", " + m.getNumber() + ", " +
//                m.getNumberOfPages() + ", " + m.getDataOfIssue() + ");","Added record to table items");
//        return m;
//    }
//
//    @Override
//    public boolean delete(long id) {
//        String query = String.format("DELETE FROM items WHERE id = " + id + ";",
//                "Deleted record from table items");
//        if (id != -1) {
//            return true;
//        } else
//            return false;
//    }
//
//    @Override
//    public PrintedProduct update(PrintedProduct object) {
//        Magazine m = (Magazine) object;
//        String query = String.format("UPTADE items SET(id_p, title, author, publishinghouse, numberofpages, dataofissue) VALUES" +
//                "(" + m.getNumID() + ", " + m.getTitle() + ", " + m.getPublishingOffice() + ", " + m.getNumber() + ", " +
//                m.getNumberOfPages() + ", " + m.getDataOfIssue() + ");","Added record to table items");
//        return m;
//    }
//
//    @Override
//    public PrintedProduct getByID(long id) {
//        String query = String.format("SELECT * FROM items WHERE id = " + id + ";",
//                "Search in table items by id");
//        return getByID(id);
//    }
//
//    @Override
//    public List<PrintedProduct> getAll() throws Exception {
//        String query = String.format("SELECT * FROM items ORDER BY id;",
//                "Getting all records from table items");
//        return getAll();
//    }
//}
