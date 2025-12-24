package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {

    @GetMapping("/admin/Management-main/role")
    public String roleList(){
        return "admin/Management-main/role-list";
    }

    @GetMapping("/admin/Management-main/user")
    public String userList(){
        return "admin/Management-main/user-list";
    }

    @GetMapping("/admin/Storage-main/add-storage")
    public String addStorage(){
        return "admin/Storage-main/add-storage-list";
    }

    @GetMapping("/admin/Storage-main/export-storage")
    public String exportStorage(){
        return "admin/Storage-main/export-storage-list";
    }

    @GetMapping("/admin/Storage-main/storage-history")
    public String StorageHistory(){
        return "admin/Storage-main/storage-history";
    }

    @GetMapping("/admin/Storage-main/export-list")
    public String StorageList(){
        return "admin/Storage-main/storage-list";
    }
}
