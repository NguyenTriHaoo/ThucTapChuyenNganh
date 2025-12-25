package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    void saveUser(User user, List<String> roles);
    void lock(String username);
    void unlock(String username);
    void delete(String username);
}
