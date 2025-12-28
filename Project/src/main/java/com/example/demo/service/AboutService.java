package com.example.demo.service;

import com.example.demo.entity.About;

import java.util.List;

public interface AboutService {
    List<About> findAll();
    void update(About about);
    About getAbout();
}
