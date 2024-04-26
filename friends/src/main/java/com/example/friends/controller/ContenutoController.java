package com.example.friends.controller;

import com.example.friends.model.Categoria;
import com.example.friends.model.Contenuto;
import com.example.friends.model.Galleria;
import com.example.friends.service.CategoriaService;
import com.example.friends.service.ContenutoService;
import com.example.friends.service.GalleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/contenuti")
public class ContenutoController {

   @Autowired
    private CategoriaService categoriaService;

   @Autowired
   private GalleriaService galleriaService;

   @GetMapping
    public String getContenuto(@RequestParam("categoriaId") int idCategoria,
                               @RequestParam("contenutoId") int idContenuto,
                               Model model) {
       Categoria categoria = categoriaService.getCategoriaById(idCategoria);
       model.addAttribute("categoria", categoria);

       Galleria galleria = galleriaService.getFotoById(idContenuto);
       model.addAttribute("galleria", galleria);
       return "contenuto";
   }

}
