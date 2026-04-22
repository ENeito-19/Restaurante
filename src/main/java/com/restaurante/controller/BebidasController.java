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
public class BebidasController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/bebidas")
    public String bebidas(Model model) {
        List<Producto> bebidas = productoService.findByDisponibleTrue();
        bebidas.removeIf(p -> p.getCategoria() == null || p.getCategoria().getTipo() != Categoria.TipoCategoria.BEBIDA);
        model.addAttribute("bebidas", bebidas);
        return "bebidas/lista";
    }
    
    @GetMapping("/bebidas/{tipo}")
    public String bebidasByTipo(@PathVariable String tipo, Model model) {
        List<Producto> bebidas = productoService.findByDisponibleTrue();
        Producto.TipoBebida tipoBebida = Producto.TipoBebida.valueOf(tipo.toUpperCase());
        bebidas.removeIf(p -> p.getTipoBebida() != tipoBebida);
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("tipo", tipo);
        return "bebidas/tipo";
    }
}
