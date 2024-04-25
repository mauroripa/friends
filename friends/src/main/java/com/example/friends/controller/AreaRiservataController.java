package com.example.friends.controller;

import com.example.friends.model.Categoria;
import com.example.friends.model.Contenuto;
import com.example.friends.service.CategoriaService;
import com.example.friends.service.ContenutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController {

    @Autowired
    private ContenutoService contenutoService;

    @Autowired
    private CategoriaService categoriaService;

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    @GetMapping
    public String getPage(
            Model model,
            HttpSession session,
            @RequestParam(name = "categoriaId", required = false) String categoriaId,
            @RequestParam(name = "contenutoId", required = false) String contenutoId
    ) {

        List<Contenuto> contenuti = contenutoService.listaContenuti();
        List<Categoria> categorie = categoriaService.listaCategorie();

        Categoria categoria = (
                !categoriaId.isEmpty() && isInteger(categoriaId)
                        ? categoriaService.getCategoriaById(Integer.parseInt(categoriaId))
                        : new Categoria()
        );

        Contenuto contenuto = (
                !contenutoId.isEmpty() && isInteger(contenutoId)
                        ? contenutoService.getContenutoById(Integer.parseInt(contenutoId))
                        : new Contenuto()
        );

        model.addAttribute("contenuti", contenuti);
        model.addAttribute("contenuto", contenuto);

        model.addAttribute("categorie", categorie);
        model.addAttribute("categoria", categoria);

        return "areariservata";
    }
}
