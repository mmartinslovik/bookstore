package com.example.bookstore.configuration;

import com.example.bookstore.domain.*;
import com.example.bookstore.repository.*;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final Faker faker = new Faker();

    @Bean
    @Transactional
    CommandLineRunner initDatabase(AuthorRepository authorRepository, BookRepository bookRepository,
                                   UserRepository userRepository, DepartmentRepository departmentRepository,
                                   OrderRepository orderRepository) {
        return args -> {
            Author author = new Author("George", "Orwell");

            Department department = new Department("Politics");

            Book book = new Book("1984", true, 10.0, department, List.of(author));
            bookRepository.save(book);

            for (int i = 0; i < 10; i++) {
                userRepository.save(new User(faker.internet().emailAddress(), "123456", null));
            }

            User user = userRepository.findAll().stream().findFirst().get();

            orderRepository.save(new Order("Order of 1984", Status.IN_PROGRESS, List.of(book), user));
        };
    }
}
