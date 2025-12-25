package com.example.demo.dao;

import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class UserDaoimplement implements UserDao{

    private EntityManager em;

    @Autowired
    public UserDaoimplement(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> findAll() {
        return em.createQuery(
                "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.authorities", User.class
        ).getResultList();
    }

    @Override
    public User findByUsername(String username) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(User user) {
        if (em.find(User.class, user.getUsername()) == null) {
            em.persist(user); //mới thì persist
        } else {
            em.merge(user);  //đã tồn tại thì merge
        }
    }

    @Override
    public void delete(String username) {
        User u = em.find(User.class, username);
        if (u != null) {
            em.remove(u);
        }
    }
}
