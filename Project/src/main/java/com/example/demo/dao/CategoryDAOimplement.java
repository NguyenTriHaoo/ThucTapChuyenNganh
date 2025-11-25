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
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
