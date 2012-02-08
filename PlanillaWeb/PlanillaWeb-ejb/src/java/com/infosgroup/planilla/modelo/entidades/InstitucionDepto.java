/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "INSTITUCION_DEPTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionDepto.findAll", query = "SELECT i FROM InstitucionDepto i"),
    @NamedQuery(name = "InstitucionDepto.findByCodCia", query = "SELECT i FROM InstitucionDepto i WHERE i.institucionDeptoPK.codCia = :codCia"),
    @NamedQuery(name = "InstitucionDepto.findByCodInsti", query = "SELECT i FROM InstitucionDepto i WHERE i.institucionDeptoPK.codInsti = :codInsti"),
    @NamedQuery(name = "InstitucionDepto.findByCodDepto", query = "SELECT i FROM InstitucionDepto i WHERE i.institucionDeptoPK.codDepto = :codDepto")})
public class InstitucionDepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstitucionDeptoPK institucionDeptoPK;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_INSTI", referencedColumnName = "COD_INSTI", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instituciones instituciones;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CTA_1", referencedColumnName = "CTA_1"),
        @JoinColumn(name = "CTA_2", referencedColumnName = "CTA_2"),
        @JoinColumn(name = "CTA_3", referencedColumnName = "CTA_3"),
        @JoinColumn(name = "CTA_4", referencedColumnName = "CTA_4"),
        @JoinColumn(name = "CTA_5", referencedColumnName = "CTA_5"),
        @JoinColumn(name = "CTA_6", referencedColumnName = "CTA_6"),
        @JoinColumn(name = "CTA_7", referencedColumnName = "CTA_7"),
        @JoinColumn(name = "CTA_8", referencedColumnName = "CTA_8")})
    @ManyToOne(optional = false)
    private Dmgcuentas dmgcuentas;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Departamentos departamentos;

    public InstitucionDepto() {
    }

    public InstitucionDepto(InstitucionDeptoPK institucionDeptoPK) {
        this.institucionDeptoPK = institucionDeptoPK;
    }

    public InstitucionDepto(short codCia, short codInsti, short codDepto) {
        this.institucionDeptoPK = new InstitucionDeptoPK(codCia, codInsti, codDepto);
    }

    public InstitucionDeptoPK getInstitucionDeptoPK() {
        return institucionDeptoPK;
    }

    public void setInstitucionDeptoPK(InstitucionDeptoPK institucionDeptoPK) {
        this.institucionDeptoPK = institucionDeptoPK;
    }

    public Instituciones getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(Instituciones instituciones) {
        this.instituciones = instituciones;
    }

    public Dmgcuentas getDmgcuentas() {
        return dmgcuentas;
    }

    public void setDmgcuentas(Dmgcuentas dmgcuentas) {
        this.dmgcuentas = dmgcuentas;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institucionDeptoPK != null ? institucionDeptoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionDepto)) {
            return false;
        }
        InstitucionDepto other = (InstitucionDepto) object;
        if ((this.institucionDeptoPK == null && other.institucionDeptoPK != null) || (this.institucionDeptoPK != null && !this.institucionDeptoPK.equals(other.institucionDeptoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.InstitucionDepto[ institucionDeptoPK=" + institucionDeptoPK + " ]";
    }
    
}
