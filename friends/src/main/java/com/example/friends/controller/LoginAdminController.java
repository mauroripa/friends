package com.example.friends.controller;

import com.example.friends.model.Categoria;
import com.example.friends.service.AdminService;
import com.example.friends.service.CategoriaService;
import com.example.friends.service.ServizioTentativiAccessoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class LoginAdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ServizioTentativiAccessoImpl servizioTentativiAccesso;

    @GetMapping("/admin/login")
    public String showLoginForm(Model model, HttpSession session) {

        if(session.getAttribute("admin") != null) {
            return "redirect:/areariservata";
        }

        List<Categoria> categorie = categoriaService.listaCategorie();
        model.addAttribute("categorie", categorie);


        if (servizioTentativiAccesso.isBloccato(session)) {
            model.addAttribute("error", "Utente bloccato. Riprova più tardi.");
        }
        return "loginAdmin";
    }

    @PostMapping("/admin/login")
    public String loginAdmin(String username, String password, Model model, HttpSession session) {
        List<Categoria> categorie = categoriaService.listaCategorie();
        model.addAttribute("categorie", categorie);
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

        session.removeAttribute("admin");
        servizioTentativiAccesso.accessoRiuscito(session); // Rimuove lo stato di blocco
        return "redirect:/";
    }
}
