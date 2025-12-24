package com.example.demo.dao;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class InventoryDaoimplement implements InventoryDao{
    private EntityManager em;

    @Autowired
    public InventoryDaoimplement(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Inventory> findAll() {
        TypedQuery<Inventory> query = em.createQuery("FROM Inventory", Inventory.class);
        return query.getResultList();
    }

    @Override
    public Optional<Inventory> findByProduct(Product product) {
        TypedQuery<Inventory> query = em.createQuery("SELECT i FROM Inventory i WHERE i.product = :product",Inventory.class);
        query.setParameter("product",product);
        return query.getResultList().stream().findFirst();
        //neu list rong thi tra ve Optional.Empty nguoc lai
        //neu co tra ve Optional.of(inventory)
    }

    @Override
    public Inventory save(Inventory inventory) {
        return em.merge(inventory);
    }
}
