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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_RANGOS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetRangos.findAll", query = "SELECT d FROM DetRangos d"),
    @NamedQuery(name = "DetRangos.findByCodCia", query = "SELECT d FROM DetRangos d WHERE d.detRangosPK.codCia = :codCia"),
    @NamedQuery(name = "DetRangos.findByCodRango", query = "SELECT d FROM DetRangos d WHERE d.detRangosPK.codRango = :codRango"),
    @NamedQuery(name = "DetRangos.findBySecuencia", query = "SELECT d FROM DetRangos d WHERE d.detRangosPK.secuencia = :secuencia"),
    @NamedQuery(name = "DetRangos.findByDel", query = "SELECT d FROM DetRangos d WHERE d.del = :del"),
    @NamedQuery(name = "DetRangos.findByAl", query = "SELECT d FROM DetRangos d WHERE d.al = :al"),
    @NamedQuery(name = "DetRangos.findByValorFijo", query = "SELECT d FROM DetRangos d WHERE d.valorFijo = :valorFijo"),
    @NamedQuery(name = "DetRangos.findByPorcentaje", query = "SELECT d FROM DetRangos d WHERE d.porcentaje = :porcentaje"),
    @NamedQuery(name = "DetRangos.findByExceso", query = "SELECT d FROM DetRangos d WHERE d.exceso = :exceso")})
public class DetRangos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetRangosPK detRangosPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEL", nullable = false, precision = 14, scale = 4)
    private BigDecimal del;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AL", nullable = false, precision = 14, scale = 4)
    private BigDecimal al;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_FIJO", nullable = false, precision = 14, scale = 4)
    private BigDecimal valorFijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE", nullable = false, precision = 14, scale = 4)
    private BigDecimal porcentaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXCESO", nullable = false, precision = 14, scale = 4)
    private BigDecimal exceso;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_RANGO", referencedColumnName = "COD_RANGO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PorRangos porRangos;

    public DetRangos() {
    }

    public DetRangos(DetRangosPK detRangosPK) {
        this.detRangosPK = detRangosPK;
    }

    public DetRangos(DetRangosPK detRangosPK, BigDecimal del, BigDecimal al, BigDecimal valorFijo, BigDecimal porcentaje, BigDecimal exceso) {
        this.detRangosPK = detRangosPK;
        this.del = del;
        this.al = al;
        this.valorFijo = valorFijo;
        this.porcentaje = porcentaje;
        this.exceso = exceso;
    }

    public DetRangos(short codCia, short codRango, short secuencia) {
        this.detRangosPK = new DetRangosPK(codCia, codRango, secuencia);
    }

    public DetRangosPK getDetRangosPK() {
        return detRangosPK;
    }

    public void setDetRangosPK(DetRangosPK detRangosPK) {
        this.detRangosPK = detRangosPK;
    }

    public BigDecimal getDel() {
        return del;
    }

    public void setDel(BigDecimal del) {
        this.del = del;
    }

    public BigDecimal getAl() {
        return al;
    }

    public void setAl(BigDecimal al) {
        this.al = al;
    }

    public BigDecimal getValorFijo() {
        return valorFijo;
    }

    public void setValorFijo(BigDecimal valorFijo) {
        this.valorFijo = valorFijo;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public BigDecimal getExceso() {
        return exceso;
    }

    public void setExceso(BigDecimal exceso) {
        this.exceso = exceso;
    }

    public PorRangos getPorRangos() {
        return porRangos;
    }

    public void setPorRangos(PorRangos porRangos) {
        this.porRangos = porRangos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detRangosPK != null ? detRangosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetRangos)) {
            return false;
        }
        DetRangos other = (DetRangos) object;
        if ((this.detRangosPK == null && other.detRangosPK != null) || (this.detRangosPK != null && !this.detRangosPK.equals(other.detRangosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetRangos[ detRangosPK=" + detRangosPK + " ]";
    }
    
}
