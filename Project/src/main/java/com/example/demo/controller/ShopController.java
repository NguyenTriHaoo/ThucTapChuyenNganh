package com.example.demo.controller;

import com.example.demo.entity.About;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.AboutService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<Product> products = productService.findByStatus();
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
        List<Product> products = productService.findByStatus();
        model.addAttribute("products",products);
        return "home/homeProduct";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam("keyword") String keyword,
            Model model
    ) {
        List<Product> products = productService.searchByKeyword(keyword);

        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);

        return "home/homeSearchResult";
    }


        @Autowired
        private AboutService aboutService;

        @GetMapping("/home/about")
        public String aboutPage(Model model) {
            About about = aboutService.findAll().get(0);

            model.addAttribute("about", about);
            return "home/about";
        }
}
