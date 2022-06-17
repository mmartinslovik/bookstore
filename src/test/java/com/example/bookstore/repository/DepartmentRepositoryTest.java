package com.example.bookstore.repository;

import com.example.bookstore.domain.Department;
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
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    private final Faker faker = new Faker();

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(departmentRepository).isNotNull();
    }

    @Test
    public void testSaveThenFindByName() {
        String name = faker.book().genre();
        departmentRepository.save(new Department(name));
        assertThat(departmentRepository.findByName(name)).isNotNull();
    }
}
