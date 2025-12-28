package com.example.demo.dao;

import com.example.demo.entity.About;

import java.util.List;

public interface AboutDao {
    List<About> findAll();
    void update(About about);

}
