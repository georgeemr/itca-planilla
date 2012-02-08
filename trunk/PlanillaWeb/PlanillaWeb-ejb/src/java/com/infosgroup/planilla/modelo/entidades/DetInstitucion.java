/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "DET_INSTITUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetInstitucion.findAll", query = "SELECT d FROM DetInstitucion d"),
    @NamedQuery(name = "DetInstitucion.findByCodCia", query = "SELECT d FROM DetInstitucion d WHERE d.detInstitucionPK.codCia = :codCia"),
    @NamedQuery(name = "DetInstitucion.findByCodInsti", query = "SELECT d FROM DetInstitucion d WHERE d.detInstitucionPK.codInsti = :codInsti"),
    @NamedQuery(name = "DetInstitucion.findByCodPais", query = "SELECT d FROM DetInstitucion d WHERE d.detInstitucionPK.codPais = :codPais"),
    @NamedQuery(name = "DetInstitucion.findByCodDepartamento", query = "SELECT d FROM DetInstitucion d WHERE d.detInstitucionPK.codDepartamento = :codDepartamento"),
    @NamedQuery(name = "DetInstitucion.findByNumeroPatronal", query = "SELECT d FROM DetInstitucion d WHERE d.numeroPatronal = :numeroPatronal"),
    @NamedQuery(name = "DetInstitucion.findByCta1", query = "SELECT d FROM DetInstitucion d WHERE d.cta1 = :cta1"),
    @NamedQuery(name = "DetInstitucion.findByCta2", query = "SELECT d FROM DetInstitucion d WHERE d.cta2 = :cta2"),
    @NamedQuery(name = "DetInstitucion.findByCta3", query = "SELECT d FROM DetInstitucion d WHERE d.cta3 = :cta3"),
    @NamedQuery(name = "DetInstitucion.findByCta4", query = "SELECT d FROM DetInstitucion d WHERE d.cta4 = :cta4"),
    @NamedQuery(name = "DetInstitucion.findByCta5", query = "SELECT d FROM DetInstitucion d WHERE d.cta5 = :cta5"),
    @NamedQuery(name = "DetInstitucion.findByCta6", query = "SELECT d FROM DetInstitucion d WHERE d.cta6 = :cta6"),
    @NamedQuery(name = "DetInstitucion.findByCta7", query = "SELECT d FROM DetInstitucion d WHERE d.cta7 = :cta7"),
    @NamedQuery(name = "DetInstitucion.findByCta8", query = "SELECT d FROM DetInstitucion d WHERE d.cta8 = :cta8")})
public class DetInstitucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetInstitucionPK detInstitucionPK;
    @Column(name = "NUMERO_PATRONAL", length = 15)
    private String numeroPatronal;
    @Column(name = "CTA_1", length = 2)
    private String cta1;
    @Column(name = "CTA_2", length = 3)
    private String cta2;
    @Column(name = "CTA_3", length = 4)
    private String cta3;
    @Column(name = "CTA_4", length = 4)
    private String cta4;
    @Column(name = "CTA_5", length = 5)
    private String cta5;
    @Column(name = "CTA_6", length = 5)
    private String cta6;
    @Column(name = "CTA_7", length = 5)
    private String cta7;
    @Column(name = "CTA_8", length = 5)
    private String cta8;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_INSTI", referencedColumnName = "COD_INSTI", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instituciones instituciones;

    public DetInstitucion() {
    }

    public DetInstitucion(DetInstitucionPK detInstitucionPK) {
        this.detInstitucionPK = detInstitucionPK;
    }

    public DetInstitucion(short codCia, short codInsti, short codPais, short codDepartamento) {
        this.detInstitucionPK = new DetInstitucionPK(codCia, codInsti, codPais, codDepartamento);
    }

    public DetInstitucionPK getDetInstitucionPK() {
        return detInstitucionPK;
    }

    public void setDetInstitucionPK(DetInstitucionPK detInstitucionPK) {
        this.detInstitucionPK = detInstitucionPK;
    }

    public String getNumeroPatronal() {
        return numeroPatronal;
    }

    public void setNumeroPatronal(String numeroPatronal) {
        this.numeroPatronal = numeroPatronal;
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

    public Instituciones getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(Instituciones instituciones) {
        this.instituciones = instituciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detInstitucionPK != null ? detInstitucionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetInstitucion)) {
            return false;
        }
        DetInstitucion other = (DetInstitucion) object;
        if ((this.detInstitucionPK == null && other.detInstitucionPK != null) || (this.detInstitucionPK != null && !this.detInstitucionPK.equals(other.detInstitucionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetInstitucion[ detInstitucionPK=" + detInstitucionPK + " ]";
    }
    
}
