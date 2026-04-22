package com.restaurante.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ofertas")
public class Oferta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String titulo;
    
    private String descripcion;
    
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal precioOriginal;
    
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal precioOferta;
    
    private String imagen;
    
    private LocalDateTime fechaInicio;
    
    private LocalDateTime fechaFin;
    
    private boolean activa = true;
    
    public Oferta() {}
    
    public Oferta(String titulo, String descripcion, BigDecimal precioOriginal, BigDecimal precioOferta) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precioOriginal = precioOriginal;
        this.precioOferta = precioOferta;
        this.fechaInicio = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public BigDecimal getPrecioOriginal() { return precioOriginal; }
    public void setPrecioOriginal(BigDecimal precioOriginal) { this.precioOriginal = precioOriginal; }
    
    public BigDecimal getPrecioOferta() { return precioOferta; }
    public void setPrecioOferta(BigDecimal precioOferta) { this.precioOferta = precioOferta; }
    
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
    
    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }
    
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    
    public BigDecimal getDescuento() {
        if (precioOriginal != null && precioOferta != null && precioOriginal.compareTo(BigDecimal.ZERO) > 0) {
            return precioOriginal.subtract(precioOferta)
                    .divide(precioOriginal, 2, java.math.RoundingMode.HALF_UP)
                    .multiply(new BigDecimal("100"));
        }
        return BigDecimal.ZERO;
    }
}
