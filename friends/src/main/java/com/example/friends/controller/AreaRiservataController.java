package com.example.friends.controller;

import com.example.friends.model.Admin;
import com.example.friends.model.Categoria;
import com.example.friends.model.Contenuto;
import com.example.friends.model.Galleria;
import com.example.friends.service.AdminService;
import com.example.friends.service.CategoriaService;
import com.example.friends.service.ContenutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController {

    @Autowired
    private ContenutoService contenutoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private AdminService adminService;

    private Categoria categoria;
    private Contenuto contenuto;

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
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

        categoria = (
                categoriaId != null && isInteger(categoriaId)
                        ? categoriaService.getCategoriaById(Integer.parseInt(categoriaId))
                        : new Categoria()
        );

        contenuto = (
                contenutoId != null && isInteger(contenutoId)
                        ? contenutoService.getContenutoById(Integer.parseInt(contenutoId))
                        : new Contenuto()
        );

        List<Admin> admins = adminService.getAdmins();

        model.addAttribute("contenuti", contenuti);
        model.addAttribute("contenuto", contenuto);

        model.addAttribute("categorie", categorie);
        model.addAttribute("categoria", categoria);

        model.addAttribute("admins", admins);

        return "areariservata";
    }

    @PostMapping("/categoria")
    public String formCategoria(
            @RequestParam("nomeCategoria") String nomeCategoria
    ) {

        categoria.setNomeCategoria(nomeCategoria);
        categoriaService.addCategoria(categoria);

        return "redirect:/areariservata";
    }

    @GetMapping("/categoria/elimina")
    public String eliminaCategoria(
            @RequestParam("id") int id
    ) {

        categoriaService.removeCategoria(id);

        return "redirect:/areariservata";
    }

    private List<Galleria> getListGalleria(MultipartFile[] galleria) {

        try {

            List<Galleria> listGalleria = new ArrayList<>();

            for (MultipartFile file : galleria) {

                // data:image/png;base64,.....
                String formato = file.getContentType();
                String imageGalleria = "data:" + formato + ";base64," + Base64.getEncoder().encodeToString(file.getBytes());

                Galleria galleriaImg = new Galleria();
                galleriaImg.setGalleria(imageGalleria);
                galleriaImg.setContenuto(contenuto);
                listGalleria.add(galleriaImg);
            }

            return listGalleria;

        } catch (IOException e) {
            return null;
        }
    }

    @PostMapping("/contenuto")
    public String formContenuto(
            @RequestParam("titolo") String titolo,
            @RequestParam("descrizione") String descrizione,
            @RequestParam("categoria") String idCategoria,
            @RequestParam("foto") MultipartFile[] galleria
    ) {

        contenuto.setTitolo(titolo);
        contenuto.setDescrizione(descrizione);
        contenuto.setCategoria(
                categoriaService.getCategoriaById(Integer.parseInt(idCategoria))
        );

        List<Galleria> images = getListGalleria(galleria);
        if( images != null && !images.isEmpty()) {
            contenuto.setImmagini(getListGalleria(galleria));
        }

        contenutoService.addContenuto(contenuto);

        return "redirect:/areariservata";
    }
}
