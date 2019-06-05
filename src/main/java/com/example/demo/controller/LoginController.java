package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        return "home.html";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login.html";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "success";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "success";
    }
}

