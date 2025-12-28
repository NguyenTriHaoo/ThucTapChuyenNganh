package com.example.demo.dao;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
    List<Product> findByCategoryId(int cateId);
    long countAll();
    long countActive();
    long countInactive();
    long countByCategoryId(int categoryId);
    List<Product> searchByKeyword(String keyword);
    List<Product> findByStatus();
}
