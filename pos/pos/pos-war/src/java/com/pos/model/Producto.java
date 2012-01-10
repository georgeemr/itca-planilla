/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.model;

import java.math.BigDecimal;

/**
 *
 * @author Soporte
 */
public class Producto {

    private String identificador;
    private String nombre;
    private String descripcion;
    private Long cantidad;
    private BigDecimal total;

    public Producto() {
        cantidad = 0L;
        total = new BigDecimal("0");
    }

    public Producto(String identificador, String nombre, String descripcion, Long cantidad, BigDecimal total) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
