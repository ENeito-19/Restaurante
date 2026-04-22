package com.restaurante.controller;

import com.restaurante.model.Oferta;
import com.restaurante.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OfertasController {
    
    @Autowired
    private OfertaService ofertaService;
    
    @GetMapping("/ofertas")
    public String ofertas(Model model) {
        List<Oferta> ofertas = ofertaService.findActiveOffers();
        model.addAttribute("ofertas", ofertas);
        return "ofertas/lista";
    }
}
