package com.example.friends.controller;

import com.example.friends.model.Contenuto;
import com.example.friends.service.ContenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/gadget")
public class GadgetController {

    @Autowired
    private ContenutoService contenutoService;

    @GetMapping
    public String getGadgetPage(Model model,@RequestParam(name="categoriaId", required = false) int categoriaId) {
        List<Contenuto> contenutiGadget = contenutoService.getContenutiByCategoriaId(categoriaId);
        model.addAttribute("contenutiGadget", contenutiGadget);
        return "gadget";
    }
}
