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

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final Faker faker = new Faker();

    @Bean
    @Transactional
    CommandLineRunner initDatabase(AuthorRepository authorRepository, BookRepository bookRepository,
                                   CustomerRepository customerRepository, DepartmentRepository departmentRepository,
                                   OrderRepository orderRepository) {
        return args -> {
            Author author = new Author("George", "Orwell");

            Department department = new Department("Politics");

            Book book = new Book("1984", true, 10.0, department, List.of(author));
            bookRepository.save(book);

            for (int i = 0; i < 10; i++) {
                customerRepository.save(new Customer(faker.name().firstName(), faker.name().lastName(),
                        faker.internet().emailAddress(), null));
            }

            Customer customer = customerRepository.findAll().stream().findFirst().get();

            orderRepository.save(new Order("Order of 1984", Status.IN_PROGRESS, List.of(book), customer));
        };
    }
}
