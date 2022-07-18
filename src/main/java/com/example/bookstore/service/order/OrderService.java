package com.example.bookstore.service.order;

import com.example.bookstore.domain.Order;
import com.example.bookstore.domain.Status;
import com.example.bookstore.domain.User;
import com.example.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order cancel(Order entity) {
        entity.setStatus(Status.CANCELLED);
        return orderRepository.save(entity);
    }

    public Order complete(Order entity) {
        entity.setStatus(Status.COMPLETED);
        return orderRepository.save(entity);
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public void delete(Order entity) {
        orderRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<Order> entities) {
        orderRepository.deleteAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<Order> findAllById(Iterable<Long> ids) {
        return orderRepository.findAllById(ids);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }

    @Override
    public Optional<Order> findByIdAndUser(Long id, User user) {
        return orderRepository.findByIdAndUser(id, user);
    }

    @Override
    public Order save(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Iterable<Order> saveAll(Iterable<Order> entities) {
        return orderRepository.saveAll(entities);
    }
}
