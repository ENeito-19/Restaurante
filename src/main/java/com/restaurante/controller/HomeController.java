package com.restaurante.controller;

import com.restaurante.model.Categoria;
import com.restaurante.model.Oferta;
import com.restaurante.model.Producto;
import com.restaurante.service.CategoriaService;
import com.restaurante.service.OfertaService;
import com.restaurante.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private OfertaService ofertaService;
    
    @GetMapping("/")
    public String home(Model model) {
        List<Producto> destacados = productoService.findByDisponibleTrue();
        List<Oferta> ofertas = ofertaService.findActiveOffers();
        model.addAttribute("destacados", destacados);
        model.addAttribute("ofertas", ofertas);
        return "home";
    }
}
