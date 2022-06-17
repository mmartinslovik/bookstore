package com.example.bookstore.domain;

import com.example.bookstore.model.NamedEntity;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Book extends NamedEntity {

    private static final long serialVersionUID = 8480439267773089700L;

    private boolean available;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    List<Order> orders = new ArrayList<>();

    public Book(String name, boolean available, Department department, Author... authors) {
        super(name);
        this.available = available;
        this.department = department;
        this.authors = Stream.of(authors).collect(Collectors.toList());
    }

    public Book(String name, boolean available, Department department, List<Author> authors) {
        super(name);
        this.available = available;
        this.department = department;
        this.authors = authors;
    }
}
