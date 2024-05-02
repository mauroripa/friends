package com.example.friends.controller;

import com.example.friends.model.Categoria;
import com.example.friends.service.CategoriaService;
import com.example.friends.service.ContenutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/{path}")
public class ContenutoController {

   @Autowired
    private CategoriaService categoriaService;


   @GetMapping //("/{path}")
   public String getContenuto(Model model,
                              @PathVariable String path,
                              HttpSession session) {
      List<Categoria> categorie = categoriaService.listaCategorie();
      model.addAttribute("categorie", categorie);
      model.addAttribute("login", session.getAttribute("admin") != null);
      Categoria categoria = categoriaService.getCategoriaByName(path);
      if(categoria != null) {
         model.addAttribute("categoria", categoria);
         return path.toLowerCase();
      }
      return "index";
   }
}
