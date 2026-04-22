package com.restaurante.controller;

import com.restaurante.model.Usuario;
import com.restaurante.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@RequestParam String nombre, 
                          @RequestParam String email, 
                          @RequestParam String password, 
                          Model model) {
        if (usuarioService.existsByEmail(email)) {
            model.addAttribute("error", "El email ya está registrado");
            model.addAttribute("usuario", new Usuario());
            return "register";
        }
        
        Usuario usuario = new Usuario(nombre, email, password);
        usuarioService.save(usuario);
        return "redirect:/login";
    }
}
