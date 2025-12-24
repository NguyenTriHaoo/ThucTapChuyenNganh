package com.example.demo.service;

import com.example.demo.dao.InventoryDao;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class InventoryServiceImplement implements InventoryService{
    private InventoryDao inventoryDao;

    @Autowired
    public InventoryServiceImplement(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @Override
    public void increase(Product product, int qty) {
        Inventory inventory = inventoryDao.findByProduct(product).orElse(new Inventory(product,0));

        inventory.setQuantity(inventory.getQuantity()+qty);
        inventory.setLastUpdated(LocalDateTime.now());

        inventoryDao.save(inventory);
    }

    @Override
    public void decrease(Product product, int qty) {
        Inventory inventory = inventoryDao.findByProduct(product)
                .orElseThrow(() -> new RuntimeException("Chua co ton kho"));
        if(inventory.getQuantity()<qty){
            throw new RuntimeException("Khong du ton kho");
        }
        inventory.setQuantity(inventory.getQuantity() - qty);
        inventory.setLastUpdated(LocalDateTime.now());
        inventoryDao.save(inventory);
    }

    @Override

    public Inventory findByProduct(Product product) {
        return inventoryDao.findByProduct(product).orElse(null);
    }

    @Override

    public boolean isLowStock(Inventory inv) {
        return inv.getQuantity() <= inv.getWarningLevel();
    }
}
