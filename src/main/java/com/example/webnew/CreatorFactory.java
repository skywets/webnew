package com.example.webnew;

import java.util.HashMap;
import java.util.Map;

public class CreatorFactory {

    private Map<ProductType, PrintedProductCreator> creators = new HashMap<>(){{
        put(ProductType.BOOK, new BookCreator());
        put(ProductType.NEWSPAPER, new NewspaperCreator());
        put(ProductType.MAGAZINE, new MagazineCretor());
    }};
    public PrintedProductCreator getCreator(ProductType type){
        return creators.get(type);
    }
}
