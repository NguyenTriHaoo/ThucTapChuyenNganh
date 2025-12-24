package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;

public interface InventoryService {
    void increase(Product product,int qty); //qty = so luong nhap
    void decrease(Product product,int qty);

    Inventory findByProduct(Product product);
    boolean isLowStock(Inventory inventory);
}
