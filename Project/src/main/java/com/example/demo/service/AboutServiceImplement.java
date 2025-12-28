package com.example.demo.service;

import com.example.demo.dao.AboutDao;
import com.example.demo.entity.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AboutServiceImplement implements AboutService{
    @Autowired
    private AboutDao aboutDao;
    @Override
    public List<About> findAll() {
        return aboutDao.findAll();
    }

    @Override
    public void update(About about) {
        aboutDao.update(about);
    }

    @Override
    public About getAbout() {
        return aboutDao.findAll().get(0);
    }
}
