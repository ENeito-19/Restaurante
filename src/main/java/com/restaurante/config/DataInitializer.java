package com.restaurante.config;

import com.restaurante.model.*;
import com.restaurante.repository.*;
import com.restaurante.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private OfertaRepository ofertaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public void run(String... args) {
        if (categoriaRepository.count() == 0) {
            initCategorias();
            initProductos();
            initOfertas();
            initUsuario();
        }
    }
    
    private void initCategorias() {
        Categoria desayunos = new Categoria("Desayunos", "Deliciosos desayunos para empezar el día", Categoria.TipoCategoria.DESAYUNO);
        Categoria almuerzos = new Categoria("Almuerzos", "Platillos principales del mediodía", Categoria.TipoCategoria.ALMUERZO);
        Categoria cenas = new Categoria("Cenas", "Cenas especiales para la noche", Categoria.TipoCategoria.CENA);
        Categoria bebidas = new Categoria("Bebidas", "Bebidas refrescantes", Categoria.TipoCategoria.BEBIDA);
        
        categoriaRepository.save(desayunos);
        categoriaRepository.save(almuerzos);
        categoriaRepository.save(cenas);
        categoriaRepository.save(bebidas);
    }
    
    private void initProductos() {
        Categoria desayunos = categoriaRepository.findByTipo(Categoria.TipoCategoria.DESAYUNO).get(0);
        Categoria almuerzos = categoriaRepository.findByTipo(Categoria.TipoCategoria.ALMUERZO).get(0);
        Categoria cenas = categoriaRepository.findByTipo(Categoria.TipoCategoria.CENA).get(0);
        Categoria bebidas = categoriaRepository.findByTipo(Categoria.TipoCategoria.BEBIDA).get(0);
        
        // Desayunos tradicionales guatemaltecos
        Producto desayunoChapin = new Producto("Desayuno Chapín", "Huevos, frijoles, plátano, queso y tortilla", new BigDecimal("35.00"), desayunos);
        desayunoChapin.setImagen("https://images.unsplash.com/photo-1533089860892-a7c6f0a88666?w=400&h=250&fit=crop");
        productoRepository.save(desayunoChapin);
        
        Producto tamales = new Producto("Tamales", "Tamales de cerdo con masa de maíz", new BigDecimal("8.00"), desayunos);
        tamales.setImagen("https://images.unsplash.com/photo-1559339352-11d035aa65de?w=400&h=250&fit=crop");
        productoRepository.save(tamales);
        
        Producto atolElote = new Producto("Atol de Elote", "Bebida tradicional de maíz", new BigDecimal("10.00"), desayunos);
        atolElote.setImagen("https://images.unsplash.com/photo-1623065422902-30a2d299bbe4?w=400&h=250&fit=crop");
        productoRepository.save(atolElote);
        
        Producto pupusas = new Producto("Pupusas", "Tortillas rellenas de queso y chicharrón", new BigDecimal("15.00"), desayunos);
        pupusas.setImagen("https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=400&h=250&fit=crop");
        productoRepository.save(pupusas);
        
        // Almuerzos tradicionales guatemaltecos
        Producto pepian = new Producto("Pepián", "Plato tradicional con recado de pepita y carne", new BigDecimal("45.00"), almuerzos);
        pepian.setImagen("https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?w=400&h=250&fit=crop");
        productoRepository.save(pepian);
        
        Producto kakik = new Producto("Kak'ik", "Caldo de pavo con recado de chiles", new BigDecimal("40.00"), almuerzos);
        kakik.setImagen("https://images.unsplash.com/photo-1547592166-23ac45744acd?w=400&h=250&fit=crop");
        productoRepository.save(kakik);
        
        Producto joccon = new Producto("Jocón", "Pollo en recado verde de hierbas", new BigDecimal("38.00"), almuerzos);
        joccon.setImagen("https://images.unsplash.com/photo-1432139555190-58524dae6a55?w=400&h=250&fit=crop");
        productoRepository.save(joccon);
        
        Producto hilachas = new Producto("Hilachas", "Carne deshebrada en recado de tomate", new BigDecimal("35.00"), almuerzos);
        hilachas.setImagen("https://images.unsplash.com/photo-1544025162-d76694265947?w=400&h=250&fit=crop");
        productoRepository.save(hilachas);
        
        Producto polloCrema = new Producto("Pollo en Crema", "Pollo en crema con loroco", new BigDecimal("32.00"), almuerzos);
        polloCrema.setImagen("https://images.unsplash.com/photo-1598515214211-89d3c73ae83b?w=400&h=250&fit=crop");
        productoRepository.save(polloCrema);
        
        Producto pulique = new Producto("Pulique", "Caldo tradicional con vegetales y carne", new BigDecimal("42.00"), almuerzos);
        pulique.setImagen("https://images.unsplash.com/photo-1547592166-23ac45744acd?w=400&h=250&fit=crop");
        productoRepository.save(pulique);
        
        // Cenas tradicionales guatemaltecas
        Producto tamalesColorados = new Producto("Tamales Colorados", "Tamales de cerdo con recado rojo", new BigDecimal("8.00"), cenas);
        tamalesColorados.setImagen("https://images.unsplash.com/photo-1559339352-11d035aa65de?w=400&h=250&fit=crop");
        productoRepository.save(tamalesColorados);
        
        Producto tamalesNegros = new Producto("Tamales Negros", "Tamales dulces con chocolate", new BigDecimal("8.00"), cenas);
        tamalesNegros.setImagen("https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=400&h=250&fit=crop");
        productoRepository.save(tamalesNegros);
        
        Producto fiambre = new Producto("Fiambre", "Plato tradicional de noviembre", new BigDecimal("50.00"), cenas);
        fiambre.setImagen("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?w=400&h=250&fit=crop");
        productoRepository.save(fiambre);
        
        Producto caldoRes = new Producto("Caldo de Res", "Caldo de res con vegetales", new BigDecimal("40.00"), cenas);
        caldoRes.setImagen("https://images.unsplash.com/photo-1547592166-23ac45744acd?w=400&h=250&fit=crop");
        productoRepository.save(caldoRes);
        
        // Bebidas - Café
        Producto cafeAntigua = new Producto("Café de Antigua", "Café tradicional de Antigua Guatemala", new BigDecimal("15.00"), bebidas);
        cafeAntigua.setTipoBebida(Producto.TipoBebida.CAFE);
        cafeAntigua.setImagen("https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=400&h=250&fit=crop");
        productoRepository.save(cafeAntigua);
        
        // Bebidas - Alcohol
        Producto gallo = new Producto("Cerveza Gallo", "Cerveza guatemalteca", new BigDecimal("12.00"), bebidas);
        gallo.setTipoBebida(Producto.TipoBebida.ALCOHOL);
        gallo.setImagen("https://images.unsplash.com/photo-1566417713940-fe7c737a9ef2?w=400&h=250&fit=crop");
        productoRepository.save(gallo);
        
        Producto zacapa = new Producto("Ron Zacapa", "Ron premium de Guatemala", new BigDecimal("25.00"), bebidas);
        zacapa.setTipoBebida(Producto.TipoBebida.ALCOHOL);
        zacapa.setImagen("https://images.unsplash.com/photo-1569529465841-dfecdab7503b?w=400&h=250&fit=crop");
        productoRepository.save(zacapa);
        
        Producto boj = new Producto("Boj", "Bebida alcohólica tradicional", new BigDecimal("18.00"), bebidas);
        boj.setTipoBebida(Producto.TipoBebida.ALCOHOL);
        boj.setImagen("https://images.unsplash.com/photo-1566417713940-fe7c737a9ef2?w=400&h=250&fit=crop");
        productoRepository.save(boj);
        
        // Bebidas - Gaseosas
        Producto cola = new Producto("Coca Cola", "Refresco cola", new BigDecimal("5.00"), bebidas);
        cola.setTipoBebida(Producto.TipoBebida.GASEOSA);
        cola.setImagen("https://images.unsplash.com/photo-1622483767028-3f66f32aef97?w=400&h=250&fit=crop");
        productoRepository.save(cola);
        
        Producto sprite = new Producto("Sprite", "Refresco de limón", new BigDecimal("5.00"), bebidas);
        sprite.setTipoBebida(Producto.TipoBebida.GASEOSA);
        sprite.setImagen("https://images.unsplash.com/photo-1622483767028-3f66f32aef97?w=400&h=250&fit=crop");
        productoRepository.save(sprite);
        
        // Bebidas - Jugos/Atoles
        Producto atolEloteBebida = new Producto("Atol de Elote", "Bebida tradicional de maíz", new BigDecimal("10.00"), bebidas);
        atolEloteBebida.setTipoBebida(Producto.TipoBebida.JUGO);
        atolEloteBebida.setImagen("https://images.unsplash.com/photo-1623065422902-30a2d299bbe4?w=400&h=250&fit=crop");
        productoRepository.save(atolEloteBebida);
        
        Producto atolArroz = new Producto("Atol de Arroz", "Bebida tradicional de arroz", new BigDecimal("10.00"), bebidas);
        atolArroz.setTipoBebida(Producto.TipoBebida.JUGO);
        atolArroz.setImagen("https://images.unsplash.com/photo-1623065422902-30a2d299bbe4?w=400&h=250&fit=crop");
        productoRepository.save(atolArroz);
        
        Producto horchata = new Producto("Horchata", "Bebida de arroz y canela", new BigDecimal("12.00"), bebidas);
        horchata.setTipoBebida(Producto.TipoBebida.JUGO);
        horchata.setImagen("https://images.unsplash.com/photo-1623065422902-30a2d299bbe4?w=400&h=250&fit=crop");
        productoRepository.save(horchata);
        
        Producto tamarindo = new Producto("Fresco de Tamarindo", "Bebida refrescante de tamarindo", new BigDecimal("10.00"), bebidas);
        tamarindo.setTipoBebida(Producto.TipoBebida.JUGO);
        tamarindo.setImagen("https://images.unsplash.com/photo-1623065422902-30a2d299bbe4?w=400&h=250&fit=crop");
        productoRepository.save(tamarindo);
    }
    
    private void initOfertas() {
        Oferta oferta1 = new Oferta("Combo Chapín", "Desayuno Chapín + Café de Antigua", new BigDecimal("50.00"), new BigDecimal("40.00"));
        oferta1.setFechaInicio(LocalDateTime.now());
        oferta1.setFechaFin(LocalDateTime.now().plusDays(7));
        oferta1.setImagen("https://images.unsplash.com/photo-1533089860892-a7c6f0a88666?w=400&h=250&fit=crop");
        ofertaRepository.save(oferta1);
        
        Oferta oferta2 = new Oferta("2x1 Tamales", "Dos tamales por el precio de uno", new BigDecimal("16.00"), new BigDecimal("8.00"));
        oferta2.setFechaInicio(LocalDateTime.now());
        oferta2.setFechaFin(LocalDateTime.now().plusDays(5));
        oferta2.setImagen("https://images.unsplash.com/photo-1559339352-11d035aa65de?w=400&h=250&fit=crop");
        ofertaRepository.save(oferta2);
        
        Oferta oferta3 = new Oferta("Combo Pepián", "Pepián + Tamales + Atol", new BigDecimal("63.00"), new BigDecimal("50.00"));
        oferta3.setFechaInicio(LocalDateTime.now());
        oferta3.setFechaFin(LocalDateTime.now().plusDays(3));
        oferta3.setImagen("https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=400&h=250&fit=crop");
        ofertaRepository.save(oferta3);
    }
    
    private void initUsuario() {
        if (!usuarioRepository.existsByEmail("admin@restaurant.com")) {
            Usuario admin = new Usuario("Admin", "admin@restaurant.com", "admin123");
            admin.setRol(Usuario.Rol.ADMIN);
            usuarioRepository.save(admin);
        }
    }
}
