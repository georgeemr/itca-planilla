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
@Table(name = "DET_PRESTAMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetPrestamos.findAll", query = "SELECT d FROM DetPrestamos d"),
    @NamedQuery(name = "DetPrestamos.findByCodCia", query = "SELECT d FROM DetPrestamos d WHERE d.detPrestamosPK.codCia = :codCia"),
    @NamedQuery(name = "DetPrestamos.findByCodPresta", query = "SELECT d FROM DetPrestamos d WHERE d.detPrestamosPK.codPresta = :codPresta"),
    @NamedQuery(name = "DetPrestamos.findByCodEmp", query = "SELECT d FROM DetPrestamos d WHERE d.detPrestamosPK.codEmp = :codEmp"),
    @NamedQuery(name = "DetPrestamos.findByCorrelat", query = "SELECT d FROM DetPrestamos d WHERE d.detPrestamosPK.correlat = :correlat"),
    @NamedQuery(name = "DetPrestamos.findByCta1", query = "SELECT d FROM DetPrestamos d WHERE d.cta1 = :cta1"),
    @NamedQuery(name = "DetPrestamos.findByCta2", query = "SELECT d FROM DetPrestamos d WHERE d.cta2 = :cta2"),
    @NamedQuery(name = "DetPrestamos.findByCta3", query = "SELECT d FROM DetPrestamos d WHERE d.cta3 = :cta3"),
    @NamedQuery(name = "DetPrestamos.findByCta4", query = "SELECT d FROM DetPrestamos d WHERE d.cta4 = :cta4"),
    @NamedQuery(name = "DetPrestamos.findByCta5", query = "SELECT d FROM DetPrestamos d WHERE d.cta5 = :cta5"),
    @NamedQuery(name = "DetPrestamos.findByCta6", query = "SELECT d FROM DetPrestamos d WHERE d.cta6 = :cta6"),
    @NamedQuery(name = "DetPrestamos.findByCta7", query = "SELECT d FROM DetPrestamos d WHERE d.cta7 = :cta7"),
    @NamedQuery(name = "DetPrestamos.findByCta8", query = "SELECT d FROM DetPrestamos d WHERE d.cta8 = :cta8"),
    @NamedQuery(name = "DetPrestamos.findByCargo", query = "SELECT d FROM DetPrestamos d WHERE d.cargo = :cargo"),
    @NamedQuery(name = "DetPrestamos.findByAbono", query = "SELECT d FROM DetPrestamos d WHERE d.abono = :abono")})
public class DetPrestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetPrestamosPK detPrestamosPK;
    @Basic(optional = false)
    @Column(name = "CTA_1", nullable = false, length = 2)
    private String cta1;
    @Basic(optional = false)
    @Column(name = "CTA_2", nullable = false, length = 3)
    private String cta2;
    @Basic(optional = false)
    @Column(name = "CTA_3", nullable = false, length = 4)
    private String cta3;
    @Basic(optional = false)
    @Column(name = "CTA_4", nullable = false, length = 4)
    private String cta4;
    @Basic(optional = false)
    @Column(name = "CTA_5", nullable = false, length = 5)
    private String cta5;
    @Basic(optional = false)
    @Column(name = "CTA_6", nullable = false, length = 5)
    private String cta6;
    @Basic(optional = false)
    @Column(name = "CTA_7", nullable = false, length = 5)
    private String cta7;
    @Basic(optional = false)
    @Column(name = "CTA_8", nullable = false, length = 5)
    private String cta8;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CARGO", precision = 13, scale = 2)
    private BigDecimal cargo;
    @Column(name = "ABONO", precision = 13, scale = 2)
    private BigDecimal abono;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PRESTA", referencedColumnName = "COD_PRESTA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Prestamos prestamos;

    public DetPrestamos() {
    }

    public DetPrestamos(DetPrestamosPK detPrestamosPK) {
        this.detPrestamosPK = detPrestamosPK;
    }

    public DetPrestamos(DetPrestamosPK detPrestamosPK, String cta1, String cta2, String cta3, String cta4, String cta5, String cta6, String cta7, String cta8) {
        this.detPrestamosPK = detPrestamosPK;
        this.cta1 = cta1;
        this.cta2 = cta2;
        this.cta3 = cta3;
        this.cta4 = cta4;
        this.cta5 = cta5;
        this.cta6 = cta6;
        this.cta7 = cta7;
        this.cta8 = cta8;
    }

    public DetPrestamos(short codCia, int codPresta, int codEmp, int correlat) {
        this.detPrestamosPK = new DetPrestamosPK(codCia, codPresta, codEmp, correlat);
    }

    public DetPrestamosPK getDetPrestamosPK() {
        return detPrestamosPK;
    }

    public void setDetPrestamosPK(DetPrestamosPK detPrestamosPK) {
        this.detPrestamosPK = detPrestamosPK;
    }

    public String getCta1() {
        return cta1;
    }

    public void setCta1(String cta1) {
        this.cta1 = cta1;
    }

    public String getCta2() {
        return cta2;
    }

    public void setCta2(String cta2) {
        this.cta2 = cta2;
    }

    public String getCta3() {
        return cta3;
    }

    public void setCta3(String cta3) {
        this.cta3 = cta3;
    }

    public String getCta4() {
        return cta4;
    }

    public void setCta4(String cta4) {
        this.cta4 = cta4;
    }

    public String getCta5() {
        return cta5;
    }

    public void setCta5(String cta5) {
        this.cta5 = cta5;
    }

    public String getCta6() {
        return cta6;
    }

    public void setCta6(String cta6) {
        this.cta6 = cta6;
    }

    public String getCta7() {
        return cta7;
    }

    public void setCta7(String cta7) {
        this.cta7 = cta7;
    }

    public String getCta8() {
        return cta8;
    }

    public void setCta8(String cta8) {
        this.cta8 = cta8;
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

    public Prestamos getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamos prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detPrestamosPK != null ? detPrestamosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPrestamos)) {
            return false;
        }
        DetPrestamos other = (DetPrestamos) object;
        if ((this.detPrestamosPK == null && other.detPrestamosPK != null) || (this.detPrestamosPK != null && !this.detPrestamosPK.equals(other.detPrestamosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetPrestamos[ detPrestamosPK=" + detPrestamosPK + " ]";
    }
    
}
