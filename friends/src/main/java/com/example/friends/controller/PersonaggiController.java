package com.example.friends.controller;

import com.example.friends.model.Contenuto;
import com.example.friends.service.ContenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personaggi")
public class PersonaggiController {

    @Autowired
    private ContenutoService contenutoService; // Servizio per gestire i contenuti

    @GetMapping
    public String getPersonaggiPage(Model model) {
        // Carica i contenuti relativi alla categoria "Personaggi"
        List<Contenuto> contenutiPersonaggi = contenutoService.getContenutiByCategoria("Personaggi");
        model.addAttribute("contenutiPersonaggi", contenutiPersonaggi);
        return "personaggi"; // Ritorna il nome della pagina HTML
    }
}

