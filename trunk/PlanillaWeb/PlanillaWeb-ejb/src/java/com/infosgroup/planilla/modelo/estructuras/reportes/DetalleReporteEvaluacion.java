/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras.reportes;

/**
 *
 * @author root
 */
public class DetalleReporteEvaluacion {

    private String nivel;
    private Integer puntaje;
    private Integer valor;
    private Integer ponderacion;
    private Integer subTotal;

    public DetalleReporteEvaluacion(String nivel, Integer puntaje, Integer valor, Integer ponderacion, Integer subTotal) {
        this.nivel = nivel;
        this.puntaje = puntaje;
        this.valor = valor;
        this.ponderacion = ponderacion;
        this.subTotal = subTotal;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(Integer ponderacion) {
        this.ponderacion = ponderacion;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
}
