package com.example.webnew;

import java.util.HashMap;
import java.util.Map;

public class EditorFactory {
    private Map<ProductType, ProductEditor> editors = new HashMap<>() {{
        put(ProductType.BOOK, new BookEditor());
        put(ProductType.MAGAZINE, new MagazineEditor());
        put(ProductType.NEWSPAPER, new NewspaperEditor());
    }};

    public ProductEditor getEditor(ProductType type) {
        return editors.get(type);
    }
}
