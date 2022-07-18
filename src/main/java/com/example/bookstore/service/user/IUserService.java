package com.example.bookstore.service.user;

import com.example.bookstore.domain.User;
import com.example.bookstore.service.IService;

import java.util.Optional;

public interface IUserService extends IService<User> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
