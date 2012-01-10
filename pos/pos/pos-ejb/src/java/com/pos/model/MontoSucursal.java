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
public class MontoSucursal {

    private String sucursal;
    private BigDecimal monto;
    private Long cantidad;
    private String tipo;

    public MontoSucursal() {
    }

    public MontoSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public MontoSucursal(String sucursal, BigDecimal monto, Long cantidad, String tipo) {
        this.sucursal = sucursal;
        this.monto = monto;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
