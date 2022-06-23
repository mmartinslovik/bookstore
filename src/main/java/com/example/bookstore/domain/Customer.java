package com.example.bookstore.domain;

import com.example.bookstore.model.BaseEntity;
import lombok.*;

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
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 9212101535368994882L;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Order> orders = new ArrayList<>();
}
