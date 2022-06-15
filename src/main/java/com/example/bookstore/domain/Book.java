package com.example.bookstore.domain;

import com.example.bookstore.model.NamedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book extends NamedEntity {

    private boolean available;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    List<Order> orders = new ArrayList<>();

    public Book(String name, boolean available, Department department, Author... authors) {
        super(name);
        this.available = available;
        this.department = department;
        this.authors = Stream.of(authors).collect(Collectors.toSet());
    }

    public Book(String name, boolean available, Department department, Set<Author> authors) {
        super(name);
        this.available = available;
        this.department = department;
        this.authors = authors;
    }
}
