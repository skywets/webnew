package com.example.webnew.db.jdbc_dao;

import com.example.webnew.Book;
import com.example.webnew.PrintedProduct;

public class SQLBookBulder implements BaseSQLBuilder, DBUtils {
    public SQLBookBulder() {
    }
    @Override
    public String insert(PrintedProduct object) {
        Book b = (Book) object;
        String query = String.format("INSERT INTO products(title, publishinghouse, numberofpages, dataofissue, author) " + "values (%s, %s, %s, %s, %s)",
               formToDbStyle(b.getTitle()),
                formToDbStyle(b.getPublishingOffice()), b.getNumberOfPages(), formToDbStyle(b.getDataOfIssue()),
                formToDbStyle(b.getAuthor()));
        return query;
    }

    @Override
    public String delete(long id) {
        String query = String.format("DELETE FROM products WHERE id_p = " + id + ";",
                "Deleted record from table items");
        return query;
        }
    @Override
    public String update(PrintedProduct object) {
        Book b = (Book) object;
        String query = String.format("UPDATE products SET (title, publishinghouse, numberofpages, dataofissue, author) = " + "(%s, %s, %s, %s, %s)" +
                        "Where id_p = " + b.getNumID() + ";",
                formToDbStyle(b.getTitle()),
                formToDbStyle(b.getPublishingOffice()),
                b.getNumberOfPages(),
                formToDbStyle(b.getDataOfIssue()),
                formToDbStyle(b.getAuthor()));
        return query;
    }
    @Override
    public String getByID(long id) {
        String query = String.format("SELECT * FROM products WHERE id_p = " + id + ";",
                "Search in table items by id");
       return query;
    }
    @Override
    public String getAll()  {
        String query = String.format("SELECT * FROM products ORDER BY id_p;");
        return query;
    }

    @Override
    public String formToDbStyle(Object t) {
        String s = t.toString();
        return String.format("'%s'", s);
    }

}
