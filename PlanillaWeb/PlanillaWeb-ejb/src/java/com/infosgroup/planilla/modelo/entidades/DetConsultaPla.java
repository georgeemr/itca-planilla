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
@Table(name = "DET_CONSULTA_PLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetConsultaPla.findAll", query = "SELECT d FROM DetConsultaPla d"),
    @NamedQuery(name = "DetConsultaPla.findByCodCia", query = "SELECT d FROM DetConsultaPla d WHERE d.codCia = :codCia"),
    @NamedQuery(name = "DetConsultaPla.findByAnio", query = "SELECT d FROM DetConsultaPla d WHERE d.anio = :anio"),
    @NamedQuery(name = "DetConsultaPla.findByMes", query = "SELECT d FROM DetConsultaPla d WHERE d.mes = :mes"),
    @NamedQuery(name = "DetConsultaPla.findByNumPlanilla", query = "SELECT d FROM DetConsultaPla d WHERE d.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "DetConsultaPla.findByCodTipopla", query = "SELECT d FROM DetConsultaPla d WHERE d.codTipopla = :codTipopla"),
    @NamedQuery(name = "DetConsultaPla.findByCodDepto", query = "SELECT d FROM DetConsultaPla d WHERE d.codDepto = :codDepto"),
    @NamedQuery(name = "DetConsultaPla.findBySueldos", query = "SELECT d FROM DetConsultaPla d WHERE d.sueldos = :sueldos"),
    @NamedQuery(name = "DetConsultaPla.findByComision", query = "SELECT d FROM DetConsultaPla d WHERE d.comision = :comision"),
    @NamedQuery(name = "DetConsultaPla.findByBono", query = "SELECT d FROM DetConsultaPla d WHERE d.bono = :bono"),
    @NamedQuery(name = "DetConsultaPla.findBySuperg", query = "SELECT d FROM DetConsultaPla d WHERE d.superg = :superg"),
    @NamedQuery(name = "DetConsultaPla.findByOtros", query = "SELECT d FROM DetConsultaPla d WHERE d.otros = :otros"),
    @NamedQuery(name = "DetConsultaPla.findByHorasExtras", query = "SELECT d FROM DetConsultaPla d WHERE d.horasExtras = :horasExtras")})
public class DetConsultaPla implements Serializable {
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
    @Column(name = "COD_DEPTO")
    private Short codDepto;
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

    public DetConsultaPla() {
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

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
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
