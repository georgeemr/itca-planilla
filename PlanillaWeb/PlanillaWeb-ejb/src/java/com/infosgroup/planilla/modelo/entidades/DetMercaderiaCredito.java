/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_MERCADERIA_CREDITO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetMercaderiaCredito.findAll", query = "SELECT d FROM DetMercaderiaCredito d"),
    @NamedQuery(name = "DetMercaderiaCredito.findByCodCia", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.detMercaderiaCreditoPK.codCia = :codCia"),
    @NamedQuery(name = "DetMercaderiaCredito.findByAnio", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.detMercaderiaCreditoPK.anio = :anio"),
    @NamedQuery(name = "DetMercaderiaCredito.findByMes", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.detMercaderiaCreditoPK.mes = :mes"),
    @NamedQuery(name = "DetMercaderiaCredito.findByCredito", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.detMercaderiaCreditoPK.credito = :credito"),
    @NamedQuery(name = "DetMercaderiaCredito.findByCodCliente", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.detMercaderiaCreditoPK.codCliente = :codCliente"),
    @NamedQuery(name = "DetMercaderiaCredito.findBySaldo", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.saldo = :saldo"),
    @NamedQuery(name = "DetMercaderiaCredito.findByCuotaSugerida", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.cuotaSugerida = :cuotaSugerida"),
    @NamedQuery(name = "DetMercaderiaCredito.findByCuotaAprobada", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.cuotaAprobada = :cuotaAprobada"),
    @NamedQuery(name = "DetMercaderiaCredito.findByCodEmp", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.codEmp = :codEmp"),
    @NamedQuery(name = "DetMercaderiaCredito.findByNumPlanilla", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "DetMercaderiaCredito.findByCodTipopla", query = "SELECT d FROM DetMercaderiaCredito d WHERE d.codTipopla = :codTipopla")})
public class DetMercaderiaCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetMercaderiaCreditoPK detMercaderiaCreditoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SALDO", nullable = false, precision = 14, scale = 2)
    private BigDecimal saldo;
    @Column(name = "CUOTA_SUGERIDA", precision = 14, scale = 2)
    private BigDecimal cuotaSugerida;
    @Column(name = "CUOTA_APROBADA", precision = 14, scale = 2)
    private BigDecimal cuotaAprobada;
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @Column(name = "NUM_PLANILLA")
    private Short numPlanilla;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "MES", referencedColumnName = "MES", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CREDITO", referencedColumnName = "CREDITO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MercaderiaCredito mercaderiaCredito;

    public DetMercaderiaCredito() {
    }

    public DetMercaderiaCredito(DetMercaderiaCreditoPK detMercaderiaCreditoPK) {
        this.detMercaderiaCreditoPK = detMercaderiaCreditoPK;
    }

    public DetMercaderiaCredito(DetMercaderiaCreditoPK detMercaderiaCreditoPK, BigDecimal saldo) {
        this.detMercaderiaCreditoPK = detMercaderiaCreditoPK;
        this.saldo = saldo;
    }

    public DetMercaderiaCredito(short codCia, short anio, short mes, int credito, String codCliente) {
        this.detMercaderiaCreditoPK = new DetMercaderiaCreditoPK(codCia, anio, mes, credito, codCliente);
    }

    public DetMercaderiaCreditoPK getDetMercaderiaCreditoPK() {
        return detMercaderiaCreditoPK;
    }

    public void setDetMercaderiaCreditoPK(DetMercaderiaCreditoPK detMercaderiaCreditoPK) {
        this.detMercaderiaCreditoPK = detMercaderiaCreditoPK;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getCuotaSugerida() {
        return cuotaSugerida;
    }

    public void setCuotaSugerida(BigDecimal cuotaSugerida) {
        this.cuotaSugerida = cuotaSugerida;
    }

    public BigDecimal getCuotaAprobada() {
        return cuotaAprobada;
    }

    public void setCuotaAprobada(BigDecimal cuotaAprobada) {
        this.cuotaAprobada = cuotaAprobada;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public Short getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(Short numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public MercaderiaCredito getMercaderiaCredito() {
        return mercaderiaCredito;
    }

    public void setMercaderiaCredito(MercaderiaCredito mercaderiaCredito) {
        this.mercaderiaCredito = mercaderiaCredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detMercaderiaCreditoPK != null ? detMercaderiaCreditoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetMercaderiaCredito)) {
            return false;
        }
        DetMercaderiaCredito other = (DetMercaderiaCredito) object;
        if ((this.detMercaderiaCreditoPK == null && other.detMercaderiaCreditoPK != null) || (this.detMercaderiaCreditoPK != null && !this.detMercaderiaCreditoPK.equals(other.detMercaderiaCreditoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetMercaderiaCredito[ detMercaderiaCreditoPK=" + detMercaderiaCreditoPK + " ]";
    }
    
}
