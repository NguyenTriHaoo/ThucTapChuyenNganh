package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findByUsername(String username);
    void save(User user);
    void delete(String username);
}
