package com.example.demo.service;

import com.example.demo.dao.AuthorityDao;
import com.example.demo.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AuthorityServiceImplement implements AuthorityService{
    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public List<Authority> getAuthoritiesByUsername(String username) {
        return authorityDao.findByUsername(username);
    }

}
