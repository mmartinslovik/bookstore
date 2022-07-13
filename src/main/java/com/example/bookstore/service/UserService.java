package com.example.bookstore.service;

import com.example.bookstore.domain.User;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAll(Iterable<User> entities) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existById(Long id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> ids) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> entities) {
        return null;
    }
}
