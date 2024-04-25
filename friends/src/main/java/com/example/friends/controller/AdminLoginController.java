package com.example.friends.controller;

import com.example.friends.model.Admin;
import com.example.friends.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/login")
    public String showLoginForm() {
        return "loginAdmin";
    }

    @PostMapping("/admin/login")
    public String loginAdmin(String username, String password, Model model, HttpSession session) {
        boolean isLoggedIn = adminService.loggaAdmin(username, password, session);
        if (isLoggedIn) {
            return "redirect:/areariservata";
        } else {
            model.addAttribute("error", "Credenziali non valide. Riprova.");
            return "loginAdmin";
        }
    }
}

