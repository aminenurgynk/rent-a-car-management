package com.aminenurgynk.untility;

import java.util.List;

public interface ICrud<T>  {
    T save(T t);
    T update(T t);
    void deleteById(Long id );
    List<T> findAll();
    T findById(Long id);
}
