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
@Table(name = "DET_INSTITUCION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetInstitucion.findAll", query = "SELECT d FROM DetInstitucion d"),
    @NamedQuery(name = "DetInstitucion.findByCodCia", query = "SELECT d FROM DetInstitucion d WHERE d.detInstitucionPK.codCia = :codCia"),
    @NamedQuery(name = "DetInstitucion.findByCodInsti", query = "SELECT d FROM DetInstitucion d WHERE d.detInstitucionPK.codInsti = :codInsti"),
    @NamedQuery(name = "DetInstitucion.findByCodPais", query = "SELECT d FROM DetInstitucion d WHERE d.detInstitucionPK.codPais = :codPais"),
    @NamedQuery(name = "DetInstitucion.findByCodDepartamento", query = "SELECT d FROM DetInstitucion d WHERE d.detInstitucionPK.codDepartamento = :codDepartamento"),
    @NamedQuery(name = "DetInstitucion.findByNumeroPatronal", query = "SELECT d FROM DetInstitucion d WHERE d.numeroPatronal = :numeroPatronal")})
public class DetInstitucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetInstitucionPK detInstitucionPK;
    @Column(name = "NUMERO_PATRONAL", length = 15)
    private String numeroPatronal;
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
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetInstitucion[ detInstitucionPK=" + detInstitucionPK + " ]";
    }
    
}
