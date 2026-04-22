package com.restaurante.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String nombre;
    
    private String descripcion;
    
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal precio;
    
    private String imagen;
    
    @Enumerated(EnumType.STRING)
    private TipoBebida tipoBebida;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    private boolean disponible = true;
    
    public Producto() {}
    
    public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    
    public TipoBebida getTipoBebida() { return tipoBebida; }
    public void setTipoBebida(TipoBebida tipoBebida) { this.tipoBebida = tipoBebida; }
    
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    public enum TipoBebida {
        CAFE, ALCOHOL, GASEOSA, JUGO, AGUA
    }
}
