package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NamedEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;
}
