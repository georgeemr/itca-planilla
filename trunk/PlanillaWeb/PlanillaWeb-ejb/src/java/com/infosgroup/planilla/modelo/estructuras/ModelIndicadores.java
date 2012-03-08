/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Indicador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class ModelIndicadores implements java.io.Serializable {

    private String categoria;
    private List<Indicador> listaIndicadores;

    public ModelIndicadores() {
    }

    public ModelIndicadores(String categoria, List<Indicador> listaIndicadores) {
        this.categoria = categoria;
        this.listaIndicadores = listaIndicadores;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Indicador> getListaIndicadores() {
        return listaIndicadores;
    }

    public void setListaIndicadores(List<Indicador> listaIndicadores) {
        this.listaIndicadores = listaIndicadores;
    }
}
