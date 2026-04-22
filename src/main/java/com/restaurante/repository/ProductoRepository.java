package com.restaurante.repository;

import com.restaurante.model.Producto;
import com.restaurante.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria(Categoria categoria);
    List<Producto> findByDisponibleTrue();
    List<Producto> findByCategoriaAndDisponibleTrue(Categoria categoria);
}
