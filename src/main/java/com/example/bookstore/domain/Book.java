package com.example.bookstore.domain;

import com.example.bookstore.model.NamedEntity;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book extends NamedEntity {

    private static final long serialVersionUID = 8480439267773089700L;

    private boolean available;

    private Double price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Order> orders = new ArrayList<>();

    public Book(String name, boolean available, Double price, Department department, List<Author> authors) {
        super(name);
        this.available = available;
        this.price = price;
        this.department = department;
        this.authors = authors;
    }
}
