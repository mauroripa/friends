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
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private ContenutoService contenutoService;

    @GetMapping
    public String getLocationPage(Model model) {
        List<Contenuto> contenutiLocation = contenutoService.getContenutiByCategoria("Location");
        model.addAttribute("contenutiLocation", contenutiLocation);
        return "location";
    }
}
