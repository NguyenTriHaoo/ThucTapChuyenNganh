package com.example.demo.dao;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    Category findById(int id);
    Category save(Category category);
    void deleteById(int id);
    long countAll();
}
