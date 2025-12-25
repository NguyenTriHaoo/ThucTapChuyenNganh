package com.example.demo.service;

import com.example.demo.entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> getAuthoritiesByUsername(String username);
}
