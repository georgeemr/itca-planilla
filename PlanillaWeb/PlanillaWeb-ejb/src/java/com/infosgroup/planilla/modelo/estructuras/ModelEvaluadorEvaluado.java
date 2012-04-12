/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Evaluador;
import java.util.List;

/**
 *
 * @author root
 */
public class ModelEvaluadorEvaluado implements java.io.Serializable {

    private Evaluador evaluador;
    private List<Empleados> listaEvaluados;
    private String filtroEvaluados = "S";
    private Integer cantidad = 0;

    public ModelEvaluadorEvaluado(Evaluador evaluador, List<Empleados> evaluados, String filtroEvaluados) {
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

    public ModelEvaluadorEvaluado(Evaluador evaluador, List<Empleados> evaluados) {
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

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }

    public List<Empleados> getListaEvaluados() {
        return listaEvaluados;
    }

    public void setListaEvaluados(List<Empleados> listaEvaluados) {
        this.listaEvaluados = listaEvaluados;
    }
}
