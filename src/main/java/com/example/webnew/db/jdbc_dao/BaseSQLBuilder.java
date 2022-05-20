package com.example.webnew.db.jdbc_dao;

import com.example.webnew.PrintedProduct;

public interface BaseSQLBuilder {
    String insert(PrintedProduct object);
    String delete(long id);
    String update(PrintedProduct object);
    String getByID(long id);
    public String getAll();
}


