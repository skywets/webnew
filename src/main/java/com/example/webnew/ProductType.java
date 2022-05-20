package com.example.webnew;

import java.util.Arrays;

public enum ProductType {
    BOOK(1), MAGAZINE(2), NEWSPAPER(3);

    private int value;

    ProductType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static ProductType fromValue(int value) {
        return Arrays.stream(ProductType.values())
                .filter(pt -> pt.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Нет типа со значением " + value));
    }
}
