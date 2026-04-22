package com.restaurante.service;

import com.restaurante.model.Producto;
import com.restaurante.model.Categoria;
import com.restaurante.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }
    
    public List<Producto> findByCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }
    
    public List<Producto> findByDisponibleTrue() {
        return productoRepository.findByDisponibleTrue();
    }
    
    public List<Producto> findByCategoriaAndDisponibleTrue(Categoria categoria) {
        return productoRepository.findByCategoriaAndDisponibleTrue(categoria);
    }
    
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }
    
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
