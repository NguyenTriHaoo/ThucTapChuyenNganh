package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/shopcart")
    public String shopcart(){
        return "home/shop-cart";
    }

}
