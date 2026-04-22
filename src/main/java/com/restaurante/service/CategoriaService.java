package com.restaurante.service;

import com.restaurante.model.Categoria;
import com.restaurante.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    
    public List<Categoria> findByTipo(Categoria.TipoCategoria tipo) {
        return categoriaRepository.findByTipo(tipo);
    }
    
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }
    
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
