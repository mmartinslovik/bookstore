package com.example.bookstore.domain;

import com.example.bookstore.model.NamedEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Department extends NamedEntity {

    private static final long serialVersionUID = 4169378839360213878L;

    @Column(unique = true)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "department")
    @JsonBackReference
    private List<Book> books = new ArrayList<>();
}
