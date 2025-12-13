package com.example.demo.dao;

import com.example.demo.entity.Category;
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
        return em.find(Product.class,id);
    }

    @Override
    public Product save(Product product) {
        Product saved = em.merge(product);
        return saved;
    }

    @Override
    public void deleteById(int id) {
        Product product = em.find(Product.class,id);
        em.remove(product);
    }

    @Override
    public List<Product> findByCategoryId(int cateId) {

        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.category.id = :cateId",
                Product.class
        );
        query.setParameter("cateId", cateId);

        return query.getResultList();
    }
}
