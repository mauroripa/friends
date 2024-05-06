package com.example.friends.controller;

import com.example.friends.model.Categoria;
import com.example.friends.model.Contenuto;
import com.example.friends.service.CategoriaService;
import com.example.friends.service.ContenutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.ApplicationContext;
import org.w3c.dom.ls.LSOutput;

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

   @Autowired
   private ResourceLoader resourceLoader;

   @GetMapping
   public String getContenuto(Model model,
                              @PathVariable String path,
                              HttpSession session) {

      List<Categoria> categorie = categoriaService.listaCategorie();
      model.addAttribute("categorie", categorie);
      model.addAttribute("login", session.getAttribute("admin") != null);

      Categoria categoria = categoriaService.getCategoriaByName(path);

      String templateName = path.toLowerCase().replace(' ', '-') + ".html";

      /*
      if(categoria != null && appContext.getResource("classpath:/templates/" + templateName).exists()) {
         System.out.println(appContext.getResource("classpath:/templates/" + templateName).exists());
         model.addAttribute("categoria", categoria);
         model.addAttribute("contenuti", categoria.getContenuti());
         return path.toLowerCase().replace(' ', '-');
      }
      System.out.println(appContext.getResource("classpath:/templates/" + templateName).exists());
      System.out.println(path.toLowerCase().replace(' ', '-'));
      return "404";*/

      Resource templateResource = resourceLoader.getResource("classpath:/templates/" + templateName);

      if (templateResource.exists()) {
         System.out.println(resourceLoader.getResource("classpath:/templates/" + templateName));
         System.out.println(templateResource.exists());
         model.addAttribute("categoria", categoria);
         model.addAttribute("contenuti", categoria.getContenuti());
         return path.toLowerCase().replace(' ', '-');
      } else {
         System.out.println(path.toLowerCase().replace(' ', '-'));
         
         return "404";
      }
   }

   @GetMapping ("/dettaglio")
   public String getDettaglio(Model model,
                              @RequestParam("id") String id,
                              HttpSession session){

      List<Categoria> categorie = categoriaService.listaCategorie();
      model.addAttribute("categorie", categorie);
      model.addAttribute("login", session.getAttribute("admin") != null);

      Contenuto contenuto = contenutoService.getContenutoById(Integer.parseInt(id));

      if(contenuto != null) {
         String templateName = "dettaglio-" + contenuto.getCategoria().getNomeCategoria().toLowerCase().replace(' ', '-') + ".html";
         if(appContext.getResource("classpath:/templates/" + templateName).exists()) {
            model.addAttribute("contenuto", contenuto);
            model.addAttribute("categoria", contenuto.getCategoria());
            return "dettaglio-" + contenuto.getCategoria().getNomeCategoria().toLowerCase().replace(' ', '-');
         }
      }
      return "404";
   }


}
