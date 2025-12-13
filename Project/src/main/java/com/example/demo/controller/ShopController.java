package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopController {
    private  ProductService productService;
    private  CategoryService categoryService;
    @Autowired
    public ShopController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public  String listShop(Model model){
        List<Category> categories = categoryService.findAll();
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        model.addAttribute("categories",categories);
        return "indexnhacungcap";
    }

        @GetMapping("/home/homeCategory")
    public String listCategory(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "home/homeCategory";
    }

    @GetMapping("/home/homeProduct")
    public String listProduct(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "home/homeProduct";
    }
}
