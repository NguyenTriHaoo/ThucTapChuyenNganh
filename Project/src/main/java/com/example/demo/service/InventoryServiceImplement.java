package com.example.demo.service;

import com.example.demo.dao.InventoryDao;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

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
    public boolean  decrease(Product product, int qty) {
        Optional<Inventory> opt = inventoryDao.findByProduct(product);

        if (opt.isEmpty()) {
            return false;
        }

        Inventory inventory = opt.get();
        if(inventory.getQuantity()<qty){
            return false;
        }
        inventory.setQuantity(inventory.getQuantity() - qty);
        inventory.setLastUpdated(LocalDateTime.now());
        inventoryDao.save(inventory);
        return true;
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
