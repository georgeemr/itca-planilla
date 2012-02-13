/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "REL_DEPTOS_CATEGORIAS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelDeptosCategorias.findAll", query = "SELECT r FROM RelDeptosCategorias r"),
    @NamedQuery(name = "RelDeptosCategorias.findByCodCia", query = "SELECT r FROM RelDeptosCategorias r WHERE r.relDeptosCategoriasPK.codCia = :codCia"),
    @NamedQuery(name = "RelDeptosCategorias.findByCodDepto", query = "SELECT r FROM RelDeptosCategorias r WHERE r.relDeptosCategoriasPK.codDepto = :codDepto"),
    @NamedQuery(name = "RelDeptosCategorias.findByCodCat", query = "SELECT r FROM RelDeptosCategorias r WHERE r.relDeptosCategoriasPK.codCat = :codCat"),
    @NamedQuery(name = "RelDeptosCategorias.findByPorcentaje", query = "SELECT r FROM RelDeptosCategorias r WHERE r.porcentaje = :porcentaje"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta1", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta1 = :cta1"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta2", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta2 = :cta2"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta3", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta3 = :cta3"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta4", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta4 = :cta4"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta5", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta5 = :cta5"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta1Hx", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta1Hx = :cta1Hx"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta2Hx", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta2Hx = :cta2Hx"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta3Hx", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta3Hx = :cta3Hx"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta4Hx", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta4Hx = :cta4Hx"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta5Hx", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta5Hx = :cta5Hx"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta1Bf", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta1Bf = :cta1Bf"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta2Bf", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta2Bf = :cta2Bf"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta3Bf", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta3Bf = :cta3Bf"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta4Bf", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta4Bf = :cta4Bf"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta5Bf", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta5Bf = :cta5Bf"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta1Cm", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta1Cm = :cta1Cm"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta2Cm", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta2Cm = :cta2Cm"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta3Cm", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta3Cm = :cta3Cm"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta4Cm", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta4Cm = :cta4Cm"),
    @NamedQuery(name = "RelDeptosCategorias.findByCta5Cm", query = "SELECT r FROM RelDeptosCategorias r WHERE r.cta5Cm = :cta5Cm")})
public class RelDeptosCategorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelDeptosCategoriasPK relDeptosCategoriasPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORCENTAJE", precision = 6, scale = 3)
    private BigDecimal porcentaje;
    @Column(name = "CTA_1")
    private Short cta1;
    @Column(name = "CTA_2")
    private Short cta2;
    @Column(name = "CTA_3")
    private Short cta3;
    @Column(name = "CTA_4")
    private Short cta4;
    @Column(name = "CTA_5")
    private Short cta5;
    @Column(name = "CTA_1_HX")
    private Short cta1Hx;
    @Column(name = "CTA_2_HX")
    private Short cta2Hx;
    @Column(name = "CTA_3_HX")
    private Short cta3Hx;
    @Column(name = "CTA_4_HX")
    private Short cta4Hx;
    @Column(name = "CTA_5_HX")
    private Short cta5Hx;
    @Column(name = "CTA_1_BF")
    private Short cta1Bf;
    @Column(name = "CTA_2_BF")
    private Short cta2Bf;
    @Column(name = "CTA_3_BF")
    private Short cta3Bf;
    @Column(name = "CTA_4_BF")
    private Short cta4Bf;
    @Column(name = "CTA_5_BF")
    private Short cta5Bf;
    @Column(name = "CTA_1_CM")
    private Short cta1Cm;
    @Column(name = "CTA_2_CM")
    private Short cta2Cm;
    @Column(name = "CTA_3_CM")
    private Short cta3Cm;
    @Column(name = "CTA_4_CM")
    private Short cta4Cm;
    @Column(name = "CTA_5_CM")
    private Short cta5Cm;

    public RelDeptosCategorias() {
    }

    public RelDeptosCategorias(RelDeptosCategoriasPK relDeptosCategoriasPK) {
        this.relDeptosCategoriasPK = relDeptosCategoriasPK;
    }

    public RelDeptosCategorias(short codCia, short codDepto, String codCat) {
        this.relDeptosCategoriasPK = new RelDeptosCategoriasPK(codCia, codDepto, codCat);
    }

    public RelDeptosCategoriasPK getRelDeptosCategoriasPK() {
        return relDeptosCategoriasPK;
    }

    public void setRelDeptosCategoriasPK(RelDeptosCategoriasPK relDeptosCategoriasPK) {
        this.relDeptosCategoriasPK = relDeptosCategoriasPK;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Short getCta1() {
        return cta1;
    }

    public void setCta1(Short cta1) {
        this.cta1 = cta1;
    }

    public Short getCta2() {
        return cta2;
    }

    public void setCta2(Short cta2) {
        this.cta2 = cta2;
    }

    public Short getCta3() {
        return cta3;
    }

    public void setCta3(Short cta3) {
        this.cta3 = cta3;
    }

    public Short getCta4() {
        return cta4;
    }

    public void setCta4(Short cta4) {
        this.cta4 = cta4;
    }

    public Short getCta5() {
        return cta5;
    }

    public void setCta5(Short cta5) {
        this.cta5 = cta5;
    }

    public Short getCta1Hx() {
        return cta1Hx;
    }

    public void setCta1Hx(Short cta1Hx) {
        this.cta1Hx = cta1Hx;
    }

    public Short getCta2Hx() {
        return cta2Hx;
    }

    public void setCta2Hx(Short cta2Hx) {
        this.cta2Hx = cta2Hx;
    }

    public Short getCta3Hx() {
        return cta3Hx;
    }

    public void setCta3Hx(Short cta3Hx) {
        this.cta3Hx = cta3Hx;
    }

    public Short getCta4Hx() {
        return cta4Hx;
    }

    public void setCta4Hx(Short cta4Hx) {
        this.cta4Hx = cta4Hx;
    }

    public Short getCta5Hx() {
        return cta5Hx;
    }

    public void setCta5Hx(Short cta5Hx) {
        this.cta5Hx = cta5Hx;
    }

    public Short getCta1Bf() {
        return cta1Bf;
    }

    public void setCta1Bf(Short cta1Bf) {
        this.cta1Bf = cta1Bf;
    }

    public Short getCta2Bf() {
        return cta2Bf;
    }

    public void setCta2Bf(Short cta2Bf) {
        this.cta2Bf = cta2Bf;
    }

    public Short getCta3Bf() {
        return cta3Bf;
    }

    public void setCta3Bf(Short cta3Bf) {
        this.cta3Bf = cta3Bf;
    }

    public Short getCta4Bf() {
        return cta4Bf;
    }

    public void setCta4Bf(Short cta4Bf) {
        this.cta4Bf = cta4Bf;
    }

    public Short getCta5Bf() {
        return cta5Bf;
    }

    public void setCta5Bf(Short cta5Bf) {
        this.cta5Bf = cta5Bf;
    }

    public Short getCta1Cm() {
        return cta1Cm;
    }

    public void setCta1Cm(Short cta1Cm) {
        this.cta1Cm = cta1Cm;
    }

    public Short getCta2Cm() {
        return cta2Cm;
    }

    public void setCta2Cm(Short cta2Cm) {
        this.cta2Cm = cta2Cm;
    }

    public Short getCta3Cm() {
        return cta3Cm;
    }

    public void setCta3Cm(Short cta3Cm) {
        this.cta3Cm = cta3Cm;
    }

    public Short getCta4Cm() {
        return cta4Cm;
    }

    public void setCta4Cm(Short cta4Cm) {
        this.cta4Cm = cta4Cm;
    }

    public Short getCta5Cm() {
        return cta5Cm;
    }

    public void setCta5Cm(Short cta5Cm) {
        this.cta5Cm = cta5Cm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relDeptosCategoriasPK != null ? relDeptosCategoriasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelDeptosCategorias)) {
            return false;
        }
        RelDeptosCategorias other = (RelDeptosCategorias) object;
        if ((this.relDeptosCategoriasPK == null && other.relDeptosCategoriasPK != null) || (this.relDeptosCategoriasPK != null && !this.relDeptosCategoriasPK.equals(other.relDeptosCategoriasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.RelDeptosCategorias[ relDeptosCategoriasPK=" + relDeptosCategoriasPK + " ]";
    }
    
}
