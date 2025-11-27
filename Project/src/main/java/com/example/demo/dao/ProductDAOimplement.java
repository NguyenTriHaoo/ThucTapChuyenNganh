package com.example.demo.dao;

import com.example.demo.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class ProductDAOimplement implements ProductDAO{
    private EntityManager em;
    @Autowired
    public ProductDAOimplement(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query=em.createQuery("from Product",
                Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
