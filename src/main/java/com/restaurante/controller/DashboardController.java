package com.restaurante.controller;

import com.restaurante.model.Usuario;
import com.restaurante.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            Usuario usuario = usuarioService.findByEmail(email).orElse(null);
            model.addAttribute("usuario", usuario);
        }
        return "dashboard";
    }
}
