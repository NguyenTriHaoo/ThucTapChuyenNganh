package com.example.demo.controller;

import com.example.demo.dao.CategoryDAOimplement;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/Product-main/category")
    public  String list(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "admin/Product-main/category-list";
    }



    @GetMapping("/admin/Product-main/category-list-create")
    public String categoryListCreate(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "admin/Product-main/category-list-create";
    }

    @GetMapping("/admin/Product-main/category-list-edit")
    public String categoryListEdit(@RequestParam("id") int id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "admin/Product-main/category-list-edit";
    }

    @PostMapping("/admin/Product-main/saveCategory")
    public String save(Category category){
        categoryService.save(category);
        return "redirect:/admin/Product-main/category"; //redirect: tra ve cai duong dan mapping
    }

    @GetMapping("/admin/Product-main/delete")
    public String delete(@RequestParam("id") int id){
        categoryService.deleteById(id);
        return "redirect:/admin/Product-main/category";
    }


}
