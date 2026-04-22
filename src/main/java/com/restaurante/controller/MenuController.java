package com.restaurante.controller;

import com.restaurante.model.Categoria;
import com.restaurante.model.Producto;
import com.restaurante.service.CategoriaService;
import com.restaurante.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MenuController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/menu")
    public String menu(Model model) {
        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);
        return "menu/lista";
    }
    
    @GetMapping("/menu/{tipo}")
    public String menuByTipo(@PathVariable String tipo, Model model) {
        Categoria.TipoCategoria tipoEnum = Categoria.TipoCategoria.valueOf(tipo.toUpperCase());
        List<Categoria> categorias = categoriaService.findByTipo(tipoEnum);
        model.addAttribute("categorias", categorias);
        model.addAttribute("tipo", tipo);
        return "menu/tipo";
    }
    
    @GetMapping("/menu/categoria/{id}")
    public String menuByCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id).orElse(null);
        List<Producto> productos = productoService.findByCategoriaAndDisponibleTrue(categoria);
        model.addAttribute("categoria", categoria);
        model.addAttribute("productos", productos);
        return "menu/detalle";
    }
}
