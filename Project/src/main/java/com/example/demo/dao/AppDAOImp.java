package com.example.demo.dao;

import com.example.demo.entity.Category;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImp implements AppDAO{
    private EntityManager entityManager;
    public AppDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Category theCategory) {
        entityManager.persist(theCategory);
    }

    @Override
    public Category findCategoryById(int theId) {
        return entityManager.find(Category.class,theId);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int theID) {
        Category tempCategory = entityManager.find(Category.class,theID);
        entityManager.remove(tempCategory);
    }
}
