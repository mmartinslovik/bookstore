package com.example.bookstore.configuration;

import com.example.bookstore.domain.Author;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Customer;
import com.example.bookstore.domain.Department;
import com.example.bookstore.repository.*;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final Faker faker = new Faker();

    @Bean
    CommandLineRunner initDatabase(AuthorRepository authorRepository, BookRepository bookRepository,
                                   CustomerRepository customerRepository, DepartmentRepository departmentRepository) {
        return args -> {
            Set<Author> authors = new HashSet<>();
            Author author = new Author("George", "Orwell");
            authors.add(author);

            Department department = new Department("Orwell");
            departmentRepository.save(department);

            Set<Book> books = new HashSet<>();
            Book book = new Book("1984", true, department, author);
            books.add(book);
            bookRepository.saveAll(books);

            for (int i = 0; i < 10; i++) {
                customerRepository.save(new Customer(faker.name().firstName(), faker.name().lastName(), null));
            }
        };
    }
}
