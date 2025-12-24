package com.example.demo.dao;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface InventoryDao {
    //Ko phai danh sach nen dung optional
    Optional<Inventory> findByProduct(Product product);

    Inventory save(Inventory inventory);
    List<Inventory> findAll();
}
