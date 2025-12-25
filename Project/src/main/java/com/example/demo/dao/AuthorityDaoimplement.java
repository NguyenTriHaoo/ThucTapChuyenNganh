package com.example.demo.dao;

import com.example.demo.entity.Authority;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AuthorityDaoimplement implements AuthorityDao{

    private EntityManager em;

    @Autowired
    public AuthorityDaoimplement(EntityManager em) {
        this.em = em;
    }

    public List<Authority> findByUsername(String username) {
        return em.createQuery("SELECT a FROM Authority a WHERE a.user.username = :username", Authority.class)
                .setParameter("username", username)
                .getResultList();
    }
}
