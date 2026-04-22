package com.restaurante.repository;

import com.restaurante.model.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
    List<Oferta> findByActivaTrue();
    List<Oferta> findByActivaTrueAndFechaFinAfter(LocalDateTime fecha);
}
