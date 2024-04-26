package com.example.friends.controller;

import com.example.friends.model.Categoria;
import com.example.friends.model.Contenuto;
import com.example.friends.service.CategoriaService;
import com.example.friends.service.ContenutoService;
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
   private ContenutoService contenutoService;

   @GetMapping
   public String getContenuto(
           @RequestParam("categoriaId") int idCategoria,
           Model model
   ) {

      Categoria categoria = categoriaService.getCategoriaById(idCategoria);
      model.addAttribute("categoria", categoria);

      // Contenuto contenuto = contenutoService.getContenutoById(idContenuto);
      // List<Galleria> galleria = galleriaService.getFotoByContenutoId(idContenuto); // Supponendo che tu abbia un metodo simile per ottenere tutte le immagini associate a un contenuto
      // model.addAttribute("contenuto", categoria.);
      // model.addAttribute("galleria", contenuto.getImmagini());
      return "contenuto";
   }


}
