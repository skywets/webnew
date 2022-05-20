package com.example.webnew.db.jdbc_dao;
import java.util.Arrays;
public enum Builderfactory {
    SQLBOOKBUILDER(1), SQLMAGAZINEBUILDER(2), SQLNEWSPAPERBUILDER(3);

    private Object object;

    Builderfactory(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public static Builderfactory fromBuilderalue(Object object) {
        return Arrays.stream(Builderfactory.values())
                .filter(bf -> bf.object == object)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Нет типа со значенем" + object));
    }
}
