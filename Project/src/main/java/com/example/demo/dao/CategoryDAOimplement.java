package com.example.demo.dao;

import com.example.demo.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryDAOimplement implements CategoryDAO{
    private EntityManager em;
    @Autowired
    public CategoryDAOimplement(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query=em.createQuery("from Category",
                Category.class);
        return query.getResultList();
    }

    @Override
    public Category findById(int id) {
        return em.find(Category.class,id);
    }

    @Override
    @Transactional
    public Category save(Category category) {
        Category saved = em.merge(category);
        return saved;
    }

    @Override
    public void deleteById(int id) {
        Category category = em.find(Category.class,id);
        em.remove(category);
    }

    @Override
    public long countAll() {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(c) FROM Category c", Long.class
        );
        return query.getSingleResult();
    }
}
