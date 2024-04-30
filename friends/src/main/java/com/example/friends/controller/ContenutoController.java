package com.example.friends.controller;

import com.example.friends.model.Categoria;
import com.example.friends.model.Contenuto;
import com.example.friends.service.CategoriaService;
import com.example.friends.service.ContenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/contenuti")
public class ContenutoController {

   @Autowired
    private CategoriaService categoriaService;

   @Autowired
   private ContenutoService contenutoService;

   @GetMapping ("/{path}")
   public String getContenuto(Model model,
                              @PathVariable String path) {

      Categoria categoria = categoriaService.getCategoriaByName(path);
      model.addAttribute("categoria", categoria);
      return path;
   }
}
