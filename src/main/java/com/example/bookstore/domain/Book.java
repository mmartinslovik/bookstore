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

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "books")
    List<Order> orders = new ArrayList<>();

    public Book(String name, boolean available, Set<Author> authors, Department department) {
        super(name);
        this.available = available;
        this.authors = authors;
        this.department = department;
    }
}
