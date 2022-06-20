package com.example.bookstore.controller;

import com.example.bookstore.domain.Author;
import com.example.bookstore.domain.Book;
import com.example.bookstore.service.AuthorService;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    private final AuthorModelAssembler authorModelAssembler;

    private final BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, AuthorModelAssembler authorModelAssembler,
                            BookService bookService) {
        this.authorService = authorService;
        this.authorModelAssembler = authorModelAssembler;
        this.bookService = bookService;
    }

    @GetMapping("/authors/{id}")
    EntityModel<Author> getById(@PathVariable Long id) {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource"));

        return authorModelAssembler.toModel(author);
    }

    @GetMapping("/authors")
    CollectionModel<EntityModel<Author>> getAll() {
        List<EntityModel<Author>> authors = authorService.findAll().stream()
                .map(authorModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(authors,
                linkTo(methodOn(AuthorController.class).getAll()).withSelfRel());
    }

    @GetMapping("/books/{bookId}/authors")
    CollectionModel<EntityModel<Author>> getByBookId(@PathVariable Long bookId) {
        List<EntityModel<Author>> authors = authorService.findAuthorsByBooksId(bookId).stream()
                .map(authorModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(authors,
                linkTo(methodOn(AuthorController.class).getByBookId(bookId)).withSelfRel());
    }

    @PostMapping("/books/{bookId}/authors")
    ResponseEntity<?> createAndAssignAuthor(@RequestBody Author author, @PathVariable Long bookId) {
        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Unable to find book with id " + bookId));

        book.getAuthors().add(author);
        EntityModel<Author> entityModel = authorModelAssembler.toModel(authorService.save(author));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }
}
