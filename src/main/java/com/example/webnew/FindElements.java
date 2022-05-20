package com.example.webnew;

import java.util.ArrayList;
import java.util.List;

public class FindElements {
  //  static InMemoryStorage st = InMemoryStorage.getInstance();

    static PostgresSQLStorage st = PostgresSQLStorage.getInstance();

    static List<PrintedProduct> items = new ArrayList<>();
    public static PrintedProduct findElement(long id) {
        return st.findElements(id);
    }

}
