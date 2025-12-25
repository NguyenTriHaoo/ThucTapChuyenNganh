package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
@Service
@Transactional
public class UserServiceImplement implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUsername(String username) {
        User u = userDao.findByUsername(username);
        if (u != null) {
            u.setAuthorities(new HashSet<>(authorityService.getAuthoritiesByUsername(u.getUsername())));
        }
        return u;
    }

    @Override
    public void saveUser(User user, List<String> roles) {
        userDao.save(user);
    }

    @Override
    public void lock(String username) {
        User u = userDao.findByUsername(username);
        if (u != null) {
            u.setEnabled(false);
            userDao.save(u);
        }
    }

    @Override
    public void unlock(String username) {
        User u = userDao.findByUsername(username);
        if (u != null) {
            u.setEnabled(true);
            userDao.save(u);
        }
    }

    @Override
    public void delete(String username) {
        userDao.delete(username);
    }
}
