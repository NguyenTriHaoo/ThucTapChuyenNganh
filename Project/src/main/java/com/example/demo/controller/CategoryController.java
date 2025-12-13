package com.example.demo.controller;

import com.example.demo.dao.CategoryDAOimplement;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    private ProductDAO productDAO;
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService,ProductDAO productDAO) {
        this.categoryService = categoryService;
        this.productDAO = productDAO;
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

    @GetMapping("/category/{id}")
    public String showProductByCategory(
            @PathVariable int id,
            Model model) {

        List<Product> products = productDAO.findByCategoryId(id);
        model.addAttribute("products", products);

        return "home/homeProductByCate";
    }
}
