package com.example.bookstore.domain;

import com.example.bookstore.model.BaseEntity;
import com.example.bookstore.model.NamedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity {

    private String description;

    private Status status;
}
