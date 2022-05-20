package com.example.webnew.db.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class Executor {
    private static Executor instance;
    public Executor() {}
    public void execute(String query) {
        try (
                Connection connection = ConnectionManager.getInstance().getConnection();
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Unable to get data: " + e.getMessage());}}

    public <T> List<T> executeSelect(String query, Extractor<T> extractor) {
        try (
                Connection connection = ConnectionManager.getInstance().getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            return extractor.extractor(resultSet);
        } catch (SQLException e) {
            System.out.println("Unable to get data: " + e.getMessage());
        }
        return Collections.emptyList();}
    public static Executor getInstance() {
        if (instance == null) {
            instance = new Executor();}
        return instance;
    }
}
