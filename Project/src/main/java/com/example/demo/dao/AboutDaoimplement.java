package com.example.demo.dao;

import com.example.demo.entity.About;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AboutDaoimplement implements AboutDao{
    private EntityManager em;

    public AboutDaoimplement(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<About> findAll() {
        TypedQuery<About> query = em.createQuery("from About", About.class);
        return query.getResultList();
    }

    @Override
    public void update(About about) {
        em.merge(about);
    }
}
