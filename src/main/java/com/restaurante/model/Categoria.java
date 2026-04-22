package com.restaurante.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String nombre;
    
    private String descripcion;
    
    @Enumerated(EnumType.STRING)
    private TipoCategoria tipo;
    
    public Categoria() {}
    
    public Categoria(String nombre, String descripcion, TipoCategoria tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public TipoCategoria getTipo() { return tipo; }
    public void setTipo(TipoCategoria tipo) { this.tipo = tipo; }
    
    public enum TipoCategoria {
        DESAYUNO, ALMUERZO, CENA, BEBIDA
    }
}
