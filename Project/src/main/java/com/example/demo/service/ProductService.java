package com.example.demo.service;

import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
}
