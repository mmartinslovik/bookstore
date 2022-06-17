package com.example.bookstore.repository;

import com.example.bookstore.domain.Author;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    private final Faker faker = new Faker();

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(authorRepository).isNotNull();
    }

    @Test
    public void testSaveThenFindByFirstName() {
        String firstName = faker.name().firstName();
        authorRepository.save(new Author(firstName, faker.name().lastName()));
        assertThat(authorRepository.findByFirstName(firstName)).isNotNull();
    }

    @Test
    public void testSaveThenFindByLastName() {
        String lastName = faker.name().lastName();
        authorRepository.save(new Author(faker.name().firstName(), lastName));
        assertThat(authorRepository.findByLastName(lastName)).isNotNull();
    }
}
