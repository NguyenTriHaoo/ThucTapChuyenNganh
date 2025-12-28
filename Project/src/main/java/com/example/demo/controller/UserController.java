package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("admin/Management-main/user-list")
    public String list(Model model) {

        List<User> users = userService.findAll();
        users.forEach(u -> {
            if (u.getAuthorities() != null) {
                u.getAuthorities().size();
            }
        });

        model.addAttribute("users", users);
        return "admin/Management-main/user-list";
    }

    @PostMapping("admin/Management-main/user-list/lock/{username}")
    public String lock(@PathVariable String username) {
        userService.lock(username);
        return "redirect:/admin/Management-main/user-list";
    }

    @PostMapping("admin/Management-main/user-list/unlock/{username}")
    public String unlock(@PathVariable String username) {
        userService.unlock(username);
        return "redirect:/admin/Management-main/user-list";
    }

    @PostMapping("admin/Management-main/user-list/delete/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return "redirect:/admin/Management-main/user-list";
    }
}
