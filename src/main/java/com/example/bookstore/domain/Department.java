package com.example.bookstore.domain;

import com.example.bookstore.model.NamedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "departments")
@Data
public class Department extends NamedEntity {

    public Department(String name) {
        super(name);
    }
}
