package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;
    @Autowired
    public ProductController(ProductService productService,CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/Product-main/product")
    public String list(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "admin/Product-main/product-list";
    }

    @GetMapping("/admin/Product-main/product-list-create")
    public String productListCreate(Model model){
        Product product = new Product();

//        Tao category gan vao form product
        product.setCategory(new Category());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        model.addAttribute("product", product);
        return "admin/Product-main/product-list-create";
    }

    @GetMapping("/admin/Product-main/product-list-edit")
    public String categoryListEdit(@RequestParam("id") int id,Model model){

        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "admin/Product-main/product-list-edit";
    }

    @PostMapping("/admin/Product-main/saveProduct")
    public String saveProduct(Product product){
        productService.save(product);
        return "redirect:/admin/Product-main/product";
    }

    @GetMapping("/admin/Product-main/deleteProduct")
    public String delete(@RequestParam("id") int id){
        productService.deleteById(id);
        return "redirect:/admin/Product-main/product";
    }
}
