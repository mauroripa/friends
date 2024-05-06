package com.example.friends.controller;

import com.example.friends.model.Admin;
import com.example.friends.model.Categoria;
import com.example.friends.model.Contenuto;
import com.example.friends.model.Galleria;
import com.example.friends.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    private GalleriaService galleriaService;

    @Autowired
    private UploadPhotoService uploadPhotoService;

    private Admin admin;
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
            @RequestParam(name = "messaggio", required = false) String messaggio,
            @RequestParam(name = "categoriaId", required = false) String categoriaId,
            @RequestParam(name = "contenutoId", required = false) String contenutoId,
            @RequestParam(name = "adminId", required = false) String adminId

    ) {

        Admin logged = (Admin) session.getAttribute("admin");

        if (logged != null) {

            List<Admin> admins = adminService.getAdmins();
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

            admin = (
                    adminId != null && isInteger(adminId)
                            ? adminService.getAdmin(Integer.parseInt(adminId))
                            : new Admin()
            );

            model.addAttribute("contenuti", contenuti);
            model.addAttribute("contenuto", contenuto);

            model.addAttribute("categorie", categorie);
            model.addAttribute("categoria", categoria);

            model.addAttribute("admins", admins);
            model.addAttribute("admin", admin);
            model.addAttribute("messaggio", messaggio);

            model.addAttribute("login", session.getAttribute("admin") != null);

            return "areariservata";
        }

        return "redirect:/admin/login";
    }


    @PostMapping("/admin")
    public String formAdmin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session
    ) {

        Admin logged = (Admin) session.getAttribute("admin");

        if (logged != null) {

            admin.setUsername(username);
            admin.setPassword(password);

            adminService.aggiungiAdmin(admin);

            return "redirect:/areariservata";
        }

        return "redirect:/admin/login";
    }

    @GetMapping("/admin/elimina")
    public String eliminaAdmin(
            @RequestParam("id") String id,
            HttpSession session
    ) {

        Admin logged = (Admin) session.getAttribute("admin");

        if (logged != null) {

            if (adminService.getAdmins().size() > 1 && isInteger(id)) {
                adminService.rimuoviAdmin(Integer.parseInt(id));
            }

            return "redirect:/areariservata";
        }

        return "redirect:/admin/login";
    }

    @PostMapping("/categoria")
    public String formCategoria(
            @RequestParam("nomeCategoria") String nomeCategoria,
            HttpSession session
    ) {

        Admin logged = (Admin) session.getAttribute("admin");

        if (logged != null) {
            categoria.setNomeCategoria(nomeCategoria);
            categoriaService.addCategoria(categoria);

            return "redirect:/areariservata";
        }

        return "redirect:/admin/login";
    }

    @GetMapping("/categoria/elimina")
    public String eliminaCategoria(
            @RequestParam("id") int id,
            HttpSession session
    ) {

        Admin logged = (Admin) session.getAttribute("admin");

        if (logged != null) {

            categoriaService.removeCategoria(id);

            return "redirect:/areariservata";
        }

        return "redirect:/admin/login";
    }


    private List<Galleria> getListGalleria(MultipartFile[] galleria) {

        List<Galleria> listGalleria = new ArrayList<>();

        for (MultipartFile file : galleria) {
            if( !file.isEmpty() ) {

                String fileName = file.getOriginalFilename();
                uploadPhotoService.uploadFile(file, fileName);

                Galleria galleriaImg = new Galleria();
                galleriaImg.setGalleria(fileName);
                galleriaImg.setContenuto(contenuto);
                listGalleria.add(galleriaImg);
            }
        }

        return listGalleria;
    }

    @PostMapping("/contenuto")
    public String formContenuto(
            @RequestParam("titolo") String titolo,
            @RequestParam("descrizione") String descrizione,
            @RequestParam("categoria") String idCategoria,
            @RequestParam(value = "foto", required = false) MultipartFile[] galleria,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        Admin logged = (Admin) session.getAttribute("admin");

        if (logged != null) {
            try {
                contenuto.setTitolo(titolo);
                contenuto.setDescrizione(descrizione);
                contenuto.setCategoria(
                        categoriaService.getCategoriaById(Integer.parseInt(idCategoria))
                );

                List<Galleria> images = getListGalleria(galleria);
                List<Galleria> originalGalleria = contenuto.getImmagini();
                if (!originalGalleria.isEmpty()) {
                    images.addAll(originalGalleria);
                }

                contenuto.setImmagini(images);

                contenutoService.addContenuto(contenuto);

                return "redirect:/areariservata";
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/areariservata";
            }
        }
        return "redirect:/admin/login";
    }


    @GetMapping("/contenuto/elimina")
    public String eliminaContenuto(
            @RequestParam("id") int id,
            HttpSession session
    ) {
        Admin logged = (Admin) session.getAttribute("admin");

        if (logged != null) {
            contenutoService.removeContenuto(id);
            return "redirect:/areariservata";
        }

        return "redirect:/admin/login";
    }

    @GetMapping("/immagine/elimina")
    public String eliminaImmagine(
            @RequestParam("id") int id,
            @RequestParam("contenutoId") String contenutoId,
            HttpSession session
    ) {

        Admin logged = (Admin) session.getAttribute("admin");

        if (logged != null) {
            galleriaService.removeImg(id);
            return "redirect:/areariservata?contenutoId=" + contenutoId;
        }

        return "redirect:/admin/login";
    }
}
