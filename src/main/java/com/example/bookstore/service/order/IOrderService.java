package com.example.bookstore.service.order;

import com.example.bookstore.domain.Order;
import com.example.bookstore.domain.User;
import com.example.bookstore.service.IService;

import java.util.List;
import java.util.Optional;

public interface IOrderService extends IService<Order> {

    List<Order> findByUser(User user);

    Optional<Order> findByIdAndUser(Long id, User user);
}
