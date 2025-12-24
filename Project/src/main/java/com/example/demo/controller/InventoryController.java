package com.example.demo.controller;

import com.example.demo.dao.InventoryDao;
import com.example.demo.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class InventoryController {
    @Autowired
    private InventoryDao inventoryDao;

    @GetMapping("admin/Storage-main/inventory")
    public String inventory(Model model) {
        model.addAttribute("inventories", inventoryDao.findAll());
        return "admin/Storage-main/inventory";
    }
}
