/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "RESUMEN_VIATICOS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResumenViaticos.findAll", query = "SELECT r FROM ResumenViaticos r"),
    @NamedQuery(name = "ResumenViaticos.findByCodCia", query = "SELECT r FROM ResumenViaticos r WHERE r.resumenViaticosPK.codCia = :codCia"),
    @NamedQuery(name = "ResumenViaticos.findByAnio", query = "SELECT r FROM ResumenViaticos r WHERE r.resumenViaticosPK.anio = :anio"),
    @NamedQuery(name = "ResumenViaticos.findByMes", query = "SELECT r FROM ResumenViaticos r WHERE r.resumenViaticosPK.mes = :mes"),
    @NamedQuery(name = "ResumenViaticos.findByNumPlanilla", query = "SELECT r FROM ResumenViaticos r WHERE r.resumenViaticosPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "ResumenViaticos.findByCodTipopla", query = "SELECT r FROM ResumenViaticos r WHERE r.resumenViaticosPK.codTipopla = :codTipopla"),
    @NamedQuery(name = "ResumenViaticos.findByCodEmp", query = "SELECT r FROM ResumenViaticos r WHERE r.resumenViaticosPK.codEmp = :codEmp"),
    @NamedQuery(name = "ResumenViaticos.findByFInicial", query = "SELECT r FROM ResumenViaticos r WHERE r.fInicial = :fInicial"),
    @NamedQuery(name = "ResumenViaticos.findByFFinal", query = "SELECT r FROM ResumenViaticos r WHERE r.fFinal = :fFinal"),
    @NamedQuery(name = "ResumenViaticos.findByCodViatico", query = "SELECT r FROM ResumenViaticos r WHERE r.codViatico = :codViatico"),
    @NamedQuery(name = "ResumenViaticos.findByPeriodo", query = "SELECT r FROM ResumenViaticos r WHERE r.periodo = :periodo"),
    @NamedQuery(name = "ResumenViaticos.findByDViaticos", query = "SELECT r FROM ResumenViaticos r WHERE r.dViaticos = :dViaticos"),
    @NamedQuery(name = "ResumenViaticos.findByDHospedaje", query = "SELECT r FROM ResumenViaticos r WHERE r.dHospedaje = :dHospedaje"),
    @NamedQuery(name = "ResumenViaticos.findByCodTarifa", query = "SELECT r FROM ResumenViaticos r WHERE r.codTarifa = :codTarifa"),
    @NamedQuery(name = "ResumenViaticos.findByStatus", query = "SELECT r FROM ResumenViaticos r WHERE r.status = :status"),
    @NamedQuery(name = "ResumenViaticos.findByCodDepto", query = "SELECT r FROM ResumenViaticos r WHERE r.codDepto = :codDepto"),
    @NamedQuery(name = "ResumenViaticos.findByCodSucursal", query = "SELECT r FROM ResumenViaticos r WHERE r.codSucursal = :codSucursal"),
    @NamedQuery(name = "ResumenViaticos.findByEstado", query = "SELECT r FROM ResumenViaticos r WHERE r.estado = :estado")})
public class ResumenViaticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResumenViaticosPK resumenViaticosPK;
    @Column(name = "F_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fInicial;
    @Column(name = "F_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFinal;
    @Column(name = "COD_VIATICO")
    private Short codViatico;
    @Column(name = "PERIODO", length = 1)
    private String periodo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "D_VIATICOS", nullable = false, precision = 6, scale = 2)
    private BigDecimal dViaticos;
    @Column(name = "D_HOSPEDAJE", precision = 6, scale = 2)
    private BigDecimal dHospedaje;
    @Column(name = "COD_TARIFA")
    private Short codTarifa;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "COD_SUCURSAL", length = 2)
    private String codSucursal;
    @Column(name = "ESTADO", length = 1)
    private String estado;

    public ResumenViaticos() {
    }

    public ResumenViaticos(ResumenViaticosPK resumenViaticosPK) {
        this.resumenViaticosPK = resumenViaticosPK;
    }

    public ResumenViaticos(ResumenViaticosPK resumenViaticosPK, BigDecimal dViaticos) {
        this.resumenViaticosPK = resumenViaticosPK;
        this.dViaticos = dViaticos;
    }

    public ResumenViaticos(short codCia, short anio, short mes, short numPlanilla, short codTipopla, int codEmp) {
        this.resumenViaticosPK = new ResumenViaticosPK(codCia, anio, mes, numPlanilla, codTipopla, codEmp);
    }

    public ResumenViaticosPK getResumenViaticosPK() {
        return resumenViaticosPK;
    }

    public void setResumenViaticosPK(ResumenViaticosPK resumenViaticosPK) {
        this.resumenViaticosPK = resumenViaticosPK;
    }

    public Date getFInicial() {
        return fInicial;
    }

    public void setFInicial(Date fInicial) {
        this.fInicial = fInicial;
    }

    public Date getFFinal() {
        return fFinal;
    }

    public void setFFinal(Date fFinal) {
        this.fFinal = fFinal;
    }

    public Short getCodViatico() {
        return codViatico;
    }

    public void setCodViatico(Short codViatico) {
        this.codViatico = codViatico;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public BigDecimal getDViaticos() {
        return dViaticos;
    }

    public void setDViaticos(BigDecimal dViaticos) {
        this.dViaticos = dViaticos;
    }

    public BigDecimal getDHospedaje() {
        return dHospedaje;
    }

    public void setDHospedaje(BigDecimal dHospedaje) {
        this.dHospedaje = dHospedaje;
    }

    public Short getCodTarifa() {
        return codTarifa;
    }

    public void setCodTarifa(Short codTarifa) {
        this.codTarifa = codTarifa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resumenViaticosPK != null ? resumenViaticosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenViaticos)) {
            return false;
        }
        ResumenViaticos other = (ResumenViaticos) object;
        if ((this.resumenViaticosPK == null && other.resumenViaticosPK != null) || (this.resumenViaticosPK != null && !this.resumenViaticosPK.equals(other.resumenViaticosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ResumenViaticos[ resumenViaticosPK=" + resumenViaticosPK + " ]";
    }
    
}
