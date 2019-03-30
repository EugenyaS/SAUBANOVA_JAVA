package ru.saubanova.repositories;

import java.util.List;

// CREATE, READ, UPDATE, DELETE
public interface CrudRepository<T> {
    void save(T model);
    T find(Long id);
    List<T> findAll();
}
