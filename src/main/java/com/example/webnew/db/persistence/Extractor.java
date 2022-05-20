package com.example.webnew.db.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface Extractor<T> {

    List<T> extractor(ResultSet rs)throws SQLException;
}
