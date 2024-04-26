package com.example.friends.controller;

import com.example.friends.model.Categoria;
import com.example.friends.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService; // annota e inietta l'istanza di CategoriaService in questo controller

    @GetMapping
    public String getListCategories(Model model) {
        List<Categoria> categorie = categoriaService.listaCategorie(); // ottengo la lista di categorie utilizzando la crud in categoriaService
        model.addAttribute("categorie", categorie); // Model permette alla vista associata di accedere all'elenco delle categorie
        return "categoria"; // e di visualizzarli nella pagina HTML corrispondente.
    }
}
