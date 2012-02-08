/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CONSULTA_PLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaPla.findAll", query = "SELECT c FROM ConsultaPla c"),
    @NamedQuery(name = "ConsultaPla.findByCodCia", query = "SELECT c FROM ConsultaPla c WHERE c.codCia = :codCia"),
    @NamedQuery(name = "ConsultaPla.findByAnio", query = "SELECT c FROM ConsultaPla c WHERE c.anio = :anio"),
    @NamedQuery(name = "ConsultaPla.findByMes", query = "SELECT c FROM ConsultaPla c WHERE c.mes = :mes"),
    @NamedQuery(name = "ConsultaPla.findByNumPlanilla", query = "SELECT c FROM ConsultaPla c WHERE c.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "ConsultaPla.findByCodTipopla", query = "SELECT c FROM ConsultaPla c WHERE c.codTipopla = :codTipopla"),
    @NamedQuery(name = "ConsultaPla.findBySueldos", query = "SELECT c FROM ConsultaPla c WHERE c.sueldos = :sueldos"),
    @NamedQuery(name = "ConsultaPla.findByComision", query = "SELECT c FROM ConsultaPla c WHERE c.comision = :comision"),
    @NamedQuery(name = "ConsultaPla.findByBono", query = "SELECT c FROM ConsultaPla c WHERE c.bono = :bono"),
    @NamedQuery(name = "ConsultaPla.findBySuperg", query = "SELECT c FROM ConsultaPla c WHERE c.superg = :superg"),
    @NamedQuery(name = "ConsultaPla.findByOtros", query = "SELECT c FROM ConsultaPla c WHERE c.otros = :otros"),
    @NamedQuery(name = "ConsultaPla.findByHorasExtras", query = "SELECT c FROM ConsultaPla c WHERE c.horasExtras = :horasExtras")})
public class ConsultaPla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @Column(name = "MES", nullable = false)
    private short mes;
    @Basic(optional = false)
    @Column(name = "NUM_PLANILLA", nullable = false)
    private short numPlanilla;
    @Basic(optional = false)
    @Column(name = "COD_TIPOPLA", nullable = false)
    private short codTipopla;
    @Column(name = "SUELDOS")
    private BigInteger sueldos;
    @Column(name = "COMISION")
    private BigInteger comision;
    @Column(name = "BONO")
    private BigInteger bono;
    @Column(name = "SUPERG")
    private BigInteger superg;
    @Column(name = "OTROS")
    private BigInteger otros;
    @Column(name = "HORAS_EXTRAS")
    private BigInteger horasExtras;

    public ConsultaPla() {
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public short getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(short numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public BigInteger getSueldos() {
        return sueldos;
    }

    public void setSueldos(BigInteger sueldos) {
        this.sueldos = sueldos;
    }

    public BigInteger getComision() {
        return comision;
    }

    public void setComision(BigInteger comision) {
        this.comision = comision;
    }

    public BigInteger getBono() {
        return bono;
    }

    public void setBono(BigInteger bono) {
        this.bono = bono;
    }

    public BigInteger getSuperg() {
        return superg;
    }

    public void setSuperg(BigInteger superg) {
        this.superg = superg;
    }

    public BigInteger getOtros() {
        return otros;
    }

    public void setOtros(BigInteger otros) {
        this.otros = otros;
    }

    public BigInteger getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(BigInteger horasExtras) {
        this.horasExtras = horasExtras;
    }
    
}
