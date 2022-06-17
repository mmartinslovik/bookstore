package com.example.bookstore.domain;

import com.example.bookstore.model.NamedEntity;
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

    @Column(unique = true)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Book> books = new ArrayList<>();
}
