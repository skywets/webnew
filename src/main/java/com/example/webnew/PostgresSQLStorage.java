package com.example.webnew;

import com.example.webnew.db.jdbc_dao.BaseSQLBuilder;
import com.example.webnew.db.jdbc_dao.SQLBookBulder;
import com.example.webnew.db.persistence.ConnectionManager;
import com.example.webnew.db.persistence.Extractor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PostgresSQLStorage implements Storage{
    private final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/newsstand";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "rootroot";
    private static final PostgresSQLStorage instance = new PostgresSQLStorage();
    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    BaseSQLBuilder bs = new SQLBookBulder();
    public Extractor<PrintedProduct> extractor = resultSet -> {
        List<PrintedProduct> items = new ArrayList<>();
        while (resultSet.next()) {
            Date d = resultSet.getDate("dataofissue");
            LocalDate dataofissue = null;
            if (d!=null) {
                dataofissue = d.toLocalDate();
            }
            final Book item = new Book(
                    resultSet.getLong("id_p"),
                    resultSet.getString("title"),
                    resultSet.getString("publishinghouse"),
                    resultSet.getString("author"),
                    resultSet.getInt("numberofpages"),
                    dataofissue
            ) {
            };
            item.setNumID(resultSet.getLong("id_p"));
            items.add(item);
        }
        return items;
    };


    public static PostgresSQLStorage getInstance() {
        return instance;
    }
    @Override
    public boolean addElements(PrintedProduct element) {
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             Statement statement = conn.createStatement();
             )
        { int rowsInsereted = statement.executeUpdate(bs.insert(element));
                System.out.println("An existing product was updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<PrintedProduct>showAllEl() throws SQLException {
      return executeSelect(bs.getAll(), extractor) ;
    }
    @Override
    public boolean deleteElements(long id) {
        try (Connection conn = ConnectionManager.getInstance().getConnection();
        Statement statement = conn.createStatement();
        )
        {
            int rowsRemoved = statement.executeUpdate(bs.delete(id));
            if (id>0){
                System.out.println("You removed succesfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public PrintedProduct findElements(long id) {
        final List<PrintedProduct> items = executeSelect(bs.getByID(id), extractor);
      return items.size() > 0 ?  items.get(0): null;

    }
    @Override
    public void updateElements(PrintedProduct newElem) {
        try ( Connection conn = ConnectionManager.getInstance().getConnection();
        Statement statement = conn.createStatement();)
        {
            int rowsUpdated = statement.executeUpdate(bs.update(newElem));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private <T> List<T> executeSelect(String query, Extractor<T> extractor){
        try (
                Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement();
        ){
            ResultSet resultSet = statement.executeQuery(query);
            return  extractor.extractor(resultSet);
        }catch (SQLException e){
            System.out.println("Unable to get data :" + e.getMessage());
        }
        return Collections.emptyList();
    }


}
