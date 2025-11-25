package com.example.demo.controller;

import com.example.demo.dao.CategoryDAOimplement;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/Product-main")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public  String list(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "admin/Product-main/category-list";
    }
}
