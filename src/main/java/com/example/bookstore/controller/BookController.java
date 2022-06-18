package com.example.bookstore.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.bookstore.domain.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookService bookService;

    private final BookModelAssembler bookModelAssembler;

    @Autowired
    BookController(BookService bookService, BookModelAssembler bookModelAssembler) {
        this.bookService = bookService;
        this.bookModelAssembler = bookModelAssembler;
    }

    @GetMapping("/books/{id}")
    EntityModel<Book> getById(@PathVariable Long id) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource"));

        return bookModelAssembler.toModel(book);
    }

    @GetMapping("/books")
    CollectionModel<EntityModel<Book>> getAll() {
        List<EntityModel<Book>> books = bookService.findAll().stream()
                .map(bookModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).getAll()).withSelfRel());
    }

    @PostMapping("/books")
    ResponseEntity<?> createBook(@RequestBody Book book) {
        EntityModel<Book> entityModel = bookModelAssembler.toModel(bookService.save(book));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping("/books/{id}")
    ResponseEntity<?> updateBook(@RequestBody Book newBook, @PathVariable Long id) {
        Book updatedBook = bookService.findById(id)
                .map(book -> {
                    book.setName(newBook.getName());
                    book.setAvailable(newBook.isAvailable());
                    book.setAuthors(newBook.getAuthors());
                    book.setDepartment(newBook.getDepartment());
                    book.setOrders(newBook.getOrders());
                    return bookService.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return bookService.save(newBook);
                });

        EntityModel<Book> entityModel = bookModelAssembler.toModel(updatedBook);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/books/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
