package com.example.bookstore.service.book;

import com.example.bookstore.domain.Book;
import com.example.bookstore.service.IService;

import java.util.List;

public interface IBookService extends IService<Book> {

    List<Book> findAllByAvailableIsTrue();

    List<Book> findByName(String name);
}
