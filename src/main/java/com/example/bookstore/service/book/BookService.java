package com.example.bookstore.service.book;

import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public void delete(Book entity) {
        bookRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<Book> entities) {
        bookRepository.deleteAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return bookRepository.existsById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Iterable<Book> findAllById(Iterable<Long> ids) {
        return bookRepository.findAllById(ids);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAllByAvailableIsTrue() {
        return bookRepository.findAllByAvailableIsTrue();
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Book save(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public Iterable<Book> saveAll(Iterable<Book> entities) {
        return bookRepository.saveAll(entities);
    }
}
