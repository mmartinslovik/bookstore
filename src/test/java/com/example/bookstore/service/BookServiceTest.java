package com.example.bookstore.service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.service.book.BookService;
import com.example.bookstore.service.book.IBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    public void testFindByName() {
        String name = "1984";

        assertThat(bookService.findByName(name))
                .filteredOn(book -> book.getName().equals(name)).isNotEmpty();

    }

    @Test
    public void testFindAllAvailable() {
        assertThat(bookService.findAllByAvailableIsTrue())
                .hasSize(1);
    }

    @Test
    public void testSave() {
        Book book = bookService.save(new Book("Animal farm", false, 10.0, null,
                null));

        assertThat(bookService.findById(book.getId())).isNotEmpty();
    }
}
