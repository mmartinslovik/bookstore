package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    long count();

    void delete(T entity);

    void deleteAll(Iterable<T> entities);

    boolean existById(Long id);

    List<T> findAll();

    Iterable<T> findAllById(Iterable<Long> ids);

    Optional<T> findById(Long id);

    T save(T entity);

    Iterable<T> saveAll(Iterable<T> entities);
}
