package com.example.bookstore.domain;

import com.example.bookstore.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Data
public class Customer extends BaseEntity {

    private String firstName;

    private String lastName;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Order> orders = new ArrayList<>();
}
