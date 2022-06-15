package com.example.bookstore.domain;

import com.example.bookstore.model.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "authors")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Author extends BaseEntity {

    @Column(nullable = false)
    @NonNull
    private String firstName;

    @Column(nullable = false)
    @NonNull
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
