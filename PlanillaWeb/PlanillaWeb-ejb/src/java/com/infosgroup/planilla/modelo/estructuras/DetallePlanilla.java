/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author root
 */
public class DetallePlanilla implements Serializable {

    private int cod_cia;
    private int num_pla;
    private int cod_emp;
    private String apellido;
    private String nombre;
    private Double base;
    private Double prestaciones;
    private Double deducciones;
    private Double total;
    private List<DetallePlanilla> listaIng;
    private List<DetallePlanilla> listaEgr;

    public List<DetallePlanilla> getListaEgr() {
        return listaEgr;
    }

    public void setListaEgr(List<DetallePlanilla> listaEgr) {
        this.listaEgr = listaEgr;
    }

    public List<DetallePlanilla> getListaIng() {
        return listaIng;
    }

    public void setListaIng(List<DetallePlanilla> listaIng) {
        this.listaIng = listaIng;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public int getCod_cia() {
        return cod_cia;
    }

    public void setCod_cia(int cod_cia) {
        this.cod_cia = cod_cia;
    }

    public int getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(int cod_emp) {
        this.cod_emp = cod_emp;
    }

    public Double getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(Double deducciones) {
        this.deducciones = deducciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_pla() {
        return num_pla;
    }

    public void setNum_pla(int num_pla) {
        this.num_pla = num_pla;
    }

    public Double getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(Double prestaciones) {
        this.prestaciones = prestaciones;
    }

    public Double getTotal() {
//        total = this.base + this.prestaciones - this.deducciones;
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
