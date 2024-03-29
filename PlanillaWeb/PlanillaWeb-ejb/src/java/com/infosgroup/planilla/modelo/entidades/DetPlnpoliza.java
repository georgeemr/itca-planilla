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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_PLNPOLIZA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetPlnpoliza.findAll", query = "SELECT d FROM DetPlnpoliza d"),
    @NamedQuery(name = "DetPlnpoliza.findByCodCia", query = "SELECT d FROM DetPlnpoliza d WHERE d.detPlnpolizaPK.codCia = :codCia"),
    @NamedQuery(name = "DetPlnpoliza.findByTipoDocto", query = "SELECT d FROM DetPlnpoliza d WHERE d.detPlnpolizaPK.tipoDocto = :tipoDocto"),
    @NamedQuery(name = "DetPlnpoliza.findByNumPoliza", query = "SELECT d FROM DetPlnpoliza d WHERE d.detPlnpolizaPK.numPoliza = :numPoliza"),
    @NamedQuery(name = "DetPlnpoliza.findByCorrelat", query = "SELECT d FROM DetPlnpoliza d WHERE d.detPlnpolizaPK.correlat = :correlat"),
    @NamedQuery(name = "DetPlnpoliza.findByFecha", query = "SELECT d FROM DetPlnpoliza d WHERE d.detPlnpolizaPK.fecha = :fecha"),
    @NamedQuery(name = "DetPlnpoliza.findByCta1", query = "SELECT d FROM DetPlnpoliza d WHERE d.cta1 = :cta1"),
    @NamedQuery(name = "DetPlnpoliza.findByCta2", query = "SELECT d FROM DetPlnpoliza d WHERE d.cta2 = :cta2"),
    @NamedQuery(name = "DetPlnpoliza.findByCta3", query = "SELECT d FROM DetPlnpoliza d WHERE d.cta3 = :cta3"),
    @NamedQuery(name = "DetPlnpoliza.findByCta4", query = "SELECT d FROM DetPlnpoliza d WHERE d.cta4 = :cta4"),
    @NamedQuery(name = "DetPlnpoliza.findByCta5", query = "SELECT d FROM DetPlnpoliza d WHERE d.cta5 = :cta5"),
    @NamedQuery(name = "DetPlnpoliza.findByTipoActiv", query = "SELECT d FROM DetPlnpoliza d WHERE d.tipoActiv = :tipoActiv"),
    @NamedQuery(name = "DetPlnpoliza.findBySubActiv", query = "SELECT d FROM DetPlnpoliza d WHERE d.subActiv = :subActiv"),
    @NamedQuery(name = "DetPlnpoliza.findByCargo", query = "SELECT d FROM DetPlnpoliza d WHERE d.cargo = :cargo"),
    @NamedQuery(name = "DetPlnpoliza.findByAbono", query = "SELECT d FROM DetPlnpoliza d WHERE d.abono = :abono"),
    @NamedQuery(name = "DetPlnpoliza.findByCodTipopla", query = "SELECT d FROM DetPlnpoliza d WHERE d.codTipopla = :codTipopla"),
    @NamedQuery(name = "DetPlnpoliza.findByCodDepto", query = "SELECT d FROM DetPlnpoliza d WHERE d.codDepto = :codDepto"),
    @NamedQuery(name = "DetPlnpoliza.findByConcepto", query = "SELECT d FROM DetPlnpoliza d WHERE d.concepto = :concepto"),
    @NamedQuery(name = "DetPlnpoliza.findByProyecto", query = "SELECT d FROM DetPlnpoliza d WHERE d.proyecto = :proyecto")})
public class DetPlnpoliza implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetPlnpolizaPK detPlnpolizaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_1", nullable = false)
    private short cta1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_2", nullable = false)
    private short cta2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_3", nullable = false)
    private short cta3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_4", nullable = false)
    private short cta4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_5", nullable = false)
    private int cta5;
    @Size(max = 2)
    @Column(name = "TIPO_ACTIV", length = 2)
    private String tipoActiv;
    @Column(name = "SUB_ACTIV")
    private Integer subActiv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CARGO", precision = 13, scale = 2)
    private BigDecimal cargo;
    @Column(name = "ABONO", precision = 13, scale = 2)
    private BigDecimal abono;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Size(max = 100)
    @Column(name = "CONCEPTO", length = 100)
    private String concepto;
    @Size(max = 20)
    @Column(name = "PROYECTO", length = 20)
    private String proyecto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_DOCTO", referencedColumnName = "TIPO_DOCTO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NUM_POLIZA", referencedColumnName = "NUM_POLIZA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "FECHA", referencedColumnName = "FECHA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Plnpoliza plnpoliza;

    public DetPlnpoliza() {
    }

    public DetPlnpoliza(DetPlnpolizaPK detPlnpolizaPK) {
        this.detPlnpolizaPK = detPlnpolizaPK;
    }

    public DetPlnpoliza(DetPlnpolizaPK detPlnpolizaPK, short cta1, short cta2, short cta3, short cta4, int cta5) {
        this.detPlnpolizaPK = detPlnpolizaPK;
        this.cta1 = cta1;
        this.cta2 = cta2;
        this.cta3 = cta3;
        this.cta4 = cta4;
        this.cta5 = cta5;
    }

    public DetPlnpoliza(short codCia, String tipoDocto, int numPoliza, short correlat, Date fecha) {
        this.detPlnpolizaPK = new DetPlnpolizaPK(codCia, tipoDocto, numPoliza, correlat, fecha);
    }

    public DetPlnpolizaPK getDetPlnpolizaPK() {
        return detPlnpolizaPK;
    }

    public void setDetPlnpolizaPK(DetPlnpolizaPK detPlnpolizaPK) {
        this.detPlnpolizaPK = detPlnpolizaPK;
    }

    public short getCta1() {
        return cta1;
    }

    public void setCta1(short cta1) {
        this.cta1 = cta1;
    }

    public short getCta2() {
        return cta2;
    }

    public void setCta2(short cta2) {
        this.cta2 = cta2;
    }

    public short getCta3() {
        return cta3;
    }

    public void setCta3(short cta3) {
        this.cta3 = cta3;
    }

    public short getCta4() {
        return cta4;
    }

    public void setCta4(short cta4) {
        this.cta4 = cta4;
    }

    public int getCta5() {
        return cta5;
    }

    public void setCta5(int cta5) {
        this.cta5 = cta5;
    }

    public String getTipoActiv() {
        return tipoActiv;
    }

    public void setTipoActiv(String tipoActiv) {
        this.tipoActiv = tipoActiv;
    }

    public Integer getSubActiv() {
        return subActiv;
    }

    public void setSubActiv(Integer subActiv) {
        this.subActiv = subActiv;
    }

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public Plnpoliza getPlnpoliza() {
        return plnpoliza;
    }

    public void setPlnpoliza(Plnpoliza plnpoliza) {
        this.plnpoliza = plnpoliza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detPlnpolizaPK != null ? detPlnpolizaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlnpoliza)) {
            return false;
        }
        DetPlnpoliza other = (DetPlnpoliza) object;
        if ((this.detPlnpolizaPK == null && other.detPlnpolizaPK != null) || (this.detPlnpolizaPK != null && !this.detPlnpolizaPK.equals(other.detPlnpolizaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetPlnpoliza[ detPlnpolizaPK=" + detPlnpolizaPK + " ]";
    }
    
}
