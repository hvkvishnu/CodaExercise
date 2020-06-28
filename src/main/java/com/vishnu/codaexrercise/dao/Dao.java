package com.vishnu.codaexrercise.dao;

import java.util.List;

public interface Dao<T>  {
    int save(T t);
    List<T> getAll();
    void update(int id,T t);
}
