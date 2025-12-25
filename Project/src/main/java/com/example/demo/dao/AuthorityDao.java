package com.example.demo.dao;

import com.example.demo.entity.Authority;

import java.util.List;

public interface AuthorityDao {
    List<Authority> findByUsername(String username);

}
