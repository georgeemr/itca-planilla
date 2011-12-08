/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class ModelConsultaCriterio implements Serializable {

    private Integer empresa;
    private Integer puesto;
    private Integer tipoCriterio;
    private Integer correlativo;
    private String valor;
    private String valorInicialRango;
    private String valorFinalRango;
    private String operacion;
    private String clase;
    private String campo;
    private String entidad;
    private String entidadPK;

    public ModelConsultaCriterio() {
    }

    public ModelConsultaCriterio(Integer empresa, Integer puesto, Integer tipoCriterio, Integer correlativo, String valor, String valorInicialRango, String valorFinalRango, String operacion, String clase, String campo, String entidad, String entidadPK) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.tipoCriterio = tipoCriterio;
        this.correlativo = correlativo;
        this.valor = valor;
        this.valorInicialRango = valorInicialRango;
        this.valorFinalRango = valorFinalRango;
        this.operacion = operacion;
        this.clase = clase;
        this.campo = campo;
        this.entidad = entidad;
        this.entidad = entidadPK;
    }

    public ModelConsultaCriterio(Object[] o) {
        this.empresa = (Integer) o[0];
        this.puesto = (Integer) o[1];
        this.tipoCriterio = (Integer) o[2];
        this.correlativo = (Integer) o[3];
        this.valor = (String) o[4];
        this.valorInicialRango = (String) o[5];
        this.valorFinalRango = (String) o[6];
        this.operacion = (String) o[7];
        this.clase = (String) o[8];
        this.campo = (String) o[9];
        this.entidad = (String) o[10];
        this.entidadPK = (String) o[11];
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public String getClase() {
        return clase;
    }

    public void setEstructura(String clase) {
        this.clase = clase;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getPuesto() {
        return puesto;
    }

    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    public Integer getTipoCriterio() {
        return tipoCriterio;
    }

    public void setTipoCriterio(Integer tipoCriterio) {
        this.tipoCriterio = tipoCriterio;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorFinalRango() {
        return valorFinalRango;
    }

    public void setValorFinalRango(String valorFinalRango) {
        this.valorFinalRango = valorFinalRango;
    }

    public String getValorInicialRango() {
        return valorInicialRango;
    }

    public void setValorInicialRango(String valorInicialRango) {
        this.valorInicialRango = valorInicialRango;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getEntidadPK() {
        return entidadPK;
    }

    public void setEntidadPK(String entidadPK) {
        this.entidadPK = entidadPK;
    }

    @Override
    public String toString() {
        return "Datos :: empresa: " + empresa
                + " puesto: " + puesto
                + " tipoCriterio: " + tipoCriterio
                + " correlativo: " + correlativo
                + " valor: " + valor
                + " valorInicialRango: " + valorInicialRango
                + " valorFinalRango: " + valorFinalRango
                + " operacion: " + operacion
                + " clase: " + clase
                + " entidad: " + entidad
                + " campo: " + campo
                + " entidadPK: " + entidadPK;
    }
}