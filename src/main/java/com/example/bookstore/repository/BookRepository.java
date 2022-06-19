package com.example.bookstore.repository;

import com.example.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByName(String name);

    List<Book> findAllByAvailableIsTrue();
}
