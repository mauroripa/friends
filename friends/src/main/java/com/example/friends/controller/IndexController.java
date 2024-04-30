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
@RequestMapping("/")
public class IndexController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String getIndexPage(Model model) {
        List<Categoria> categorie = categoriaService.listaCategorie();
        model.addAttribute("categorie", categorie);
        return "index";
    }

}
