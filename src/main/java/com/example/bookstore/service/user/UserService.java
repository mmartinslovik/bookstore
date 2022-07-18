package com.example.bookstore.service.user;

import com.example.bookstore.domain.User;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<User> entities) {
        userRepository.deleteAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> ids) {
        return userRepository.findAllById(ids);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> entities) {
        return userRepository.saveAll(entities);
    }
}
