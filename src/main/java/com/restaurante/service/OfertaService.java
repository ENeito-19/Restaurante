package com.restaurante.service;

import com.restaurante.model.Oferta;
import com.restaurante.repository.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfertaService {
    
    @Autowired
    private OfertaRepository ofertaRepository;
    
    public List<Oferta> findAll() {
        return ofertaRepository.findAll();
    }
    
    public List<Oferta> findByActivaTrue() {
        return ofertaRepository.findByActivaTrue();
    }
    
    public List<Oferta> findActiveOffers() {
        return ofertaRepository.findByActivaTrueAndFechaFinAfter(LocalDateTime.now());
    }
    
    public Oferta save(Oferta oferta) {
        if (oferta.getFechaInicio() == null) {
            oferta.setFechaInicio(LocalDateTime.now());
        }
        return ofertaRepository.save(oferta);
    }
    
    public void deleteById(Long id) {
        ofertaRepository.deleteById(id);
    }
}
