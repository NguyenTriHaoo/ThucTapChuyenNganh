package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String indexnhacungcap(){
        return "indexnhacungcap";
    }

    @GetMapping("/shop")
    public String Shop(){
        return "home/shop";
    }

    @GetMapping("/feature")
    public String feature(){
        return "home/feature";
    }
}
