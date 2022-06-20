package com.example.bookstore.service;

import com.example.bookstore.domain.Author;
import com.example.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IService<Author> {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Override
    public void delete(Author entity) {
        authorRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<Author> entities) {
        authorRepository.deleteAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Iterable<Author> findAllById(Iterable<Long> ids) {
        return authorRepository.findAllById(ids);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> findByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName);
    }

    public List<Author> findByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    public List<Author> findAuthorsByBooksId(Long bookId) {
        return authorRepository.findAuthorsByBooksId(bookId);
    }

    @Override
    public Author save(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Iterable<Author> saveAll(Iterable<Author> entities) {
        return authorRepository.saveAll(entities);
    }
}
