package com.example.bookstore.service.author;

import com.example.bookstore.domain.Author;
import com.example.bookstore.service.IService;

import java.util.List;

public interface IAuthorService extends IService<Author> {

    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);

    List<Author> findAuthorsByBooksId(Long bookId);
}
