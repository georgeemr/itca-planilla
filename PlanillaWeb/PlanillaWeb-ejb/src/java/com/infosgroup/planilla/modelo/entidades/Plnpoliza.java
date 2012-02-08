/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PLNPOLIZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plnpoliza.findAll", query = "SELECT p FROM Plnpoliza p"),
    @NamedQuery(name = "Plnpoliza.findByCodCia", query = "SELECT p FROM Plnpoliza p WHERE p.plnpolizaPK.codCia = :codCia"),
    @NamedQuery(name = "Plnpoliza.findByTipoDocto", query = "SELECT p FROM Plnpoliza p WHERE p.plnpolizaPK.tipoDocto = :tipoDocto"),
    @NamedQuery(name = "Plnpoliza.findByNumPoliza", query = "SELECT p FROM Plnpoliza p WHERE p.plnpolizaPK.numPoliza = :numPoliza"),
    @NamedQuery(name = "Plnpoliza.findByNumReferencia", query = "SELECT p FROM Plnpoliza p WHERE p.numReferencia = :numReferencia"),
    @NamedQuery(name = "Plnpoliza.findByFecha", query = "SELECT p FROM Plnpoliza p WHERE p.plnpolizaPK.fecha = :fecha"),
    @NamedQuery(name = "Plnpoliza.findByConcepto", query = "SELECT p FROM Plnpoliza p WHERE p.concepto = :concepto"),
    @NamedQuery(name = "Plnpoliza.findByTotalPoliza", query = "SELECT p FROM Plnpoliza p WHERE p.totalPoliza = :totalPoliza"),
    @NamedQuery(name = "Plnpoliza.findByStatus", query = "SELECT p FROM Plnpoliza p WHERE p.status = :status"),
    @NamedQuery(name = "Plnpoliza.findByAnio", query = "SELECT p FROM Plnpoliza p WHERE p.anio = :anio"),
    @NamedQuery(name = "Plnpoliza.findByMes", query = "SELECT p FROM Plnpoliza p WHERE p.mes = :mes"),
    @NamedQuery(name = "Plnpoliza.findByNumPlanilla", query = "SELECT p FROM Plnpoliza p WHERE p.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "Plnpoliza.findByCodTipopla", query = "SELECT p FROM Plnpoliza p WHERE p.codTipopla = :codTipopla"),
    @NamedQuery(name = "Plnpoliza.findByPeriodoConta", query = "SELECT p FROM Plnpoliza p WHERE p.periodoConta = :periodoConta"),
    @NamedQuery(name = "Plnpoliza.findByNumPolizaConta", query = "SELECT p FROM Plnpoliza p WHERE p.numPolizaConta = :numPolizaConta"),
    @NamedQuery(name = "Plnpoliza.findByTipoDoctoConta", query = "SELECT p FROM Plnpoliza p WHERE p.tipoDoctoConta = :tipoDoctoConta")})
public class Plnpoliza implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlnpolizaPK plnpolizaPK;
    @Column(name = "NUM_REFERENCIA", length = 10)
    private String numReferencia;
    @Column(name = "CONCEPTO", length = 120)
    private String concepto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_POLIZA", precision = 13, scale = 2)
    private BigDecimal totalPoliza;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "ANIO")
    private Short anio;
    @Column(name = "MES")
    private Short mes;
    @Column(name = "NUM_PLANILLA")
    private Short numPlanilla;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @Column(name = "PERIODO_CONTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoConta;
    @Column(name = "NUM_POLIZA_CONTA")
    private Long numPolizaConta;
    @Column(name = "TIPO_DOCTO_CONTA", length = 2)
    private String tipoDoctoConta;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ParamPlan paramPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plnpoliza")
    private List<DetPlnpoliza> detPlnpolizaList;

    public Plnpoliza() {
    }

    public Plnpoliza(PlnpolizaPK plnpolizaPK) {
        this.plnpolizaPK = plnpolizaPK;
    }

    public Plnpoliza(short codCia, String tipoDocto, int numPoliza, Date fecha) {
        this.plnpolizaPK = new PlnpolizaPK(codCia, tipoDocto, numPoliza, fecha);
    }

    public PlnpolizaPK getPlnpolizaPK() {
        return plnpolizaPK;
    }

    public void setPlnpolizaPK(PlnpolizaPK plnpolizaPK) {
        this.plnpolizaPK = plnpolizaPK;
    }

    public String getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(String numReferencia) {
        this.numReferencia = numReferencia;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getTotalPoliza() {
        return totalPoliza;
    }

    public void setTotalPoliza(BigDecimal totalPoliza) {
        this.totalPoliza = totalPoliza;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public Short getMes() {
        return mes;
    }

    public void setMes(Short mes) {
        this.mes = mes;
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

    public Date getPeriodoConta() {
        return periodoConta;
    }

    public void setPeriodoConta(Date periodoConta) {
        this.periodoConta = periodoConta;
    }

    public Long getNumPolizaConta() {
        return numPolizaConta;
    }

    public void setNumPolizaConta(Long numPolizaConta) {
        this.numPolizaConta = numPolizaConta;
    }

    public String getTipoDoctoConta() {
        return tipoDoctoConta;
    }

    public void setTipoDoctoConta(String tipoDoctoConta) {
        this.tipoDoctoConta = tipoDoctoConta;
    }

    public ParamPlan getParamPlan() {
        return paramPlan;
    }

    public void setParamPlan(ParamPlan paramPlan) {
        this.paramPlan = paramPlan;
    }

    @XmlTransient
    public List<DetPlnpoliza> getDetPlnpolizaList() {
        return detPlnpolizaList;
    }

    public void setDetPlnpolizaList(List<DetPlnpoliza> detPlnpolizaList) {
        this.detPlnpolizaList = detPlnpolizaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plnpolizaPK != null ? plnpolizaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plnpoliza)) {
            return false;
        }
        Plnpoliza other = (Plnpoliza) object;
        if ((this.plnpolizaPK == null && other.plnpolizaPK != null) || (this.plnpolizaPK != null && !this.plnpolizaPK.equals(other.plnpolizaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Plnpoliza[ plnpolizaPK=" + plnpolizaPK + " ]";
    }
    
}
