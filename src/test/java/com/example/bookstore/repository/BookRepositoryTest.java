package com.example.bookstore.repository;

import com.example.bookstore.domain.Author;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Department;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private final Faker faker = new Faker();

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(bookRepository).isNotNull();
    }

    @Test
    public void testSaveThenFindByName() {
        String name = faker.book().title();
        bookRepository.save(new Book(name, true, 10.0, new Department(faker.book().genre()),
                List.of(new Author(faker.name().firstName(), faker.name().lastName()))));
        assertThat(bookRepository.findByName(name)).isNotNull();
    }
}
