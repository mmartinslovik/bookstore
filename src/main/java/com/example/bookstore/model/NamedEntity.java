package com.example.bookstore.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class NamedEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;
}
