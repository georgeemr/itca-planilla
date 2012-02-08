/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PASIVO_LABORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasivoLaboral.findAll", query = "SELECT p FROM PasivoLaboral p"),
    @NamedQuery(name = "PasivoLaboral.findByCodCia", query = "SELECT p FROM PasivoLaboral p WHERE p.codCia = :codCia"),
    @NamedQuery(name = "PasivoLaboral.findByCodEmp", query = "SELECT p FROM PasivoLaboral p WHERE p.codEmp = :codEmp"),
    @NamedQuery(name = "PasivoLaboral.findByCodDepto", query = "SELECT p FROM PasivoLaboral p WHERE p.codDepto = :codDepto"),
    @NamedQuery(name = "PasivoLaboral.findByFecIngreso", query = "SELECT p FROM PasivoLaboral p WHERE p.fecIngreso = :fecIngreso"),
    @NamedQuery(name = "PasivoLaboral.findByAnio", query = "SELECT p FROM PasivoLaboral p WHERE p.anio = :anio"),
    @NamedQuery(name = "PasivoLaboral.findByMes", query = "SELECT p FROM PasivoLaboral p WHERE p.mes = :mes"),
    @NamedQuery(name = "PasivoLaboral.findBySueldo", query = "SELECT p FROM PasivoLaboral p WHERE p.sueldo = :sueldo"),
    @NamedQuery(name = "PasivoLaboral.findByComision", query = "SELECT p FROM PasivoLaboral p WHERE p.comision = :comision"),
    @NamedQuery(name = "PasivoLaboral.findByComplemento", query = "SELECT p FROM PasivoLaboral p WHERE p.complemento = :complemento"),
    @NamedQuery(name = "PasivoLaboral.findByDLaborados", query = "SELECT p FROM PasivoLaboral p WHERE p.dLaborados = :dLaborados"),
    @NamedQuery(name = "PasivoLaboral.findByMeses", query = "SELECT p FROM PasivoLaboral p WHERE p.meses = :meses")})
public class PasivoLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "FEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Basic(optional = false)
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @Column(name = "MES", nullable = false)
    private short mes;
    @Column(name = "SUELDO")
    private BigInteger sueldo;
    @Column(name = "COMISION")
    private BigInteger comision;
    @Column(name = "COMPLEMENTO")
    private BigInteger complemento;
    @Column(name = "D_LABORADOS")
    private BigInteger dLaborados;
    @Column(name = "MESES")
    private BigInteger meses;

    public PasivoLaboral() {
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
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

    public BigInteger getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigInteger sueldo) {
        this.sueldo = sueldo;
    }

    public BigInteger getComision() {
        return comision;
    }

    public void setComision(BigInteger comision) {
        this.comision = comision;
    }

    public BigInteger getComplemento() {
        return complemento;
    }

    public void setComplemento(BigInteger complemento) {
        this.complemento = complemento;
    }

    public BigInteger getDLaborados() {
        return dLaborados;
    }

    public void setDLaborados(BigInteger dLaborados) {
        this.dLaborados = dLaborados;
    }

    public BigInteger getMeses() {
        return meses;
    }

    public void setMeses(BigInteger meses) {
        this.meses = meses;
    }
    
}
