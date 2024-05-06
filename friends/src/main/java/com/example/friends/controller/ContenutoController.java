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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.ApplicationContext;
import java.util.List;

@Controller
@RequestMapping ("/{path}")
public class ContenutoController {

   @Autowired
    private CategoriaService categoriaService;

   @Autowired
   private ContenutoService contenutoService;

   @Autowired
   private ApplicationContext appContext;

   @GetMapping
   public String getContenuto(Model model,
                              @PathVariable String path,
                              HttpSession session) {

      List<Categoria> categorie = categoriaService.listaCategorie();
      model.addAttribute("categorie", categorie);
      model.addAttribute("login", session.getAttribute("admin") != null);

      Categoria categoria = categoriaService.getCategoriaByName(path);

      String templateName = path.toLowerCase().replace(' ', '-') + ".html";

      if(categoria != null && appContext.getResource("classpath:/templates/" + templateName).exists()) {
         model.addAttribute("categoria", categoria);
         model.addAttribute("contenuti", categoria.getContenuti());
         return path.toLowerCase().replace(' ', '-');
      }
      return "dettaglio-gadget";
   }

   @GetMapping("/dettaglio-gadget")
   public String getDettaglioGadget(Model model,
                                    @RequestParam("id") String id,
                                    HttpSession session){

      List<Categoria> categorie = categoriaService.listaCategorie();
      model.addAttribute("categorie", categorie);
      model.addAttribute("login", session.getAttribute("admin") != null);

      try {
         int contenutoId = Integer.parseInt(id);
         Contenuto contenuto = contenutoService.getContenutoById(contenutoId);

         if (contenuto != null) {
            model.addAttribute("contenuto", contenuto);
            return "dettaglio-gadget"; // Aggiorna con il nome del template per il dettaglio del gadget
         } else {
            System.out.println("Contenuto non trovato per ID: " + contenutoId);
         }
      } catch (NumberFormatException e) {
         System.out.println("ID non valido: " + id);
      }

      return "404";
   }


}
