package com.example.demo.dao;

import com.example.demo.entity.Category;

public interface AppDAO {
    void save(Category theCategory);
    Category findCategoryById(int theId);
    void deleteCategoryById(int theID);
}
