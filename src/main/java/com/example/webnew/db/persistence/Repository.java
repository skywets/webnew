package com.example.webnew.db.persistence;

import java.util.List;

public interface Repository<T, Id> {
    List<T> list();
    T find(Id id);
}
