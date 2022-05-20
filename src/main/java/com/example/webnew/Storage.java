package com.example.webnew;

import java.sql.SQLException;
import java.util.List;

public interface Storage {
    boolean addElements(PrintedProduct element);
    public List<PrintedProduct> showAllEl() throws SQLException;
    PrintedProduct findElements(long id);
    public boolean deleteElements(long id);
    void updateElements(PrintedProduct newElem);
}
