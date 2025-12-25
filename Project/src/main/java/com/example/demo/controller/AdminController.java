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

}
