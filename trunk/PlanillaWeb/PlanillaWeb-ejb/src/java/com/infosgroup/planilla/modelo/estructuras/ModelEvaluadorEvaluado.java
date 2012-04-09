/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.util.List;

/**
 *
 * @author root
 */
public class ModelEvaluadorEvaluado implements java.io.Serializable {

    private Empleados evaluador;
    private List<Empleados> listaEvaluados;
    private String filtroEvaluados = "S";
    private Integer cantidad = 0;

    public ModelEvaluadorEvaluado(Empleados evaluador, List<Empleados> evaluados, String filtroEvaluados) {
        this.evaluador = evaluador;
        this.listaEvaluados = evaluados;
        this.filtroEvaluados = filtroEvaluados;
    }

    public Integer getCantidad() {
        if ( listaEvaluados==null ){
            return 0;
        }
        cantidad = listaEvaluados.size();
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ModelEvaluadorEvaluado(Empleados evaluador, List<Empleados> evaluados) {
        this.evaluador = evaluador;
        this.listaEvaluados = evaluados;
    }

    public String getFiltroEvaluados() {
        return filtroEvaluados;
    }

    public void setFiltroEvaluados(String filtroEvaluados) {
        this.filtroEvaluados = filtroEvaluados;
    }

    public ModelEvaluadorEvaluado() {
    }

    public Empleados getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Empleados evaluador) {
        this.evaluador = evaluador;
    }

    public List<Empleados> getListaEvaluados() {
        return listaEvaluados;
    }

    public void setListaEvaluados(List<Empleados> listaEvaluados) {
        this.listaEvaluados = listaEvaluados;
    }
}
