package com.example.friends.controller;

import com.example.friends.service.AdminService;
import com.example.friends.service.ServizioTentativiAccessoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginAdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ServizioTentativiAccessoImpl servizioTentativiAccesso;

    @GetMapping("/admin/login")
    public String showLoginForm() {
        return "loginAdmin";
    }

    @PostMapping("/admin/login")
    public String loginAdmin(String username, String password, Model model, HttpSession session) {
        if (servizioTentativiAccesso.isBloccato(session)) {
            model.addAttribute("error", "Utente bloccato. Riprova più tardi.");
            return "loginAdmin";
        }

        boolean isLoggedIn = adminService.loggaAdmin(username, password, session);
        if (isLoggedIn) {
            servizioTentativiAccesso.accessoRiuscito(session);
            return "redirect:/areariservata";
        } else {
            servizioTentativiAccesso.accessoFallito(session);
            model.addAttribute("error", "Credenziali non valide. Riprova.");
            return "loginAdmin";
        }
    }
    @GetMapping("/admin/logout")
    public String logoutAdmin(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/";
    }

}
