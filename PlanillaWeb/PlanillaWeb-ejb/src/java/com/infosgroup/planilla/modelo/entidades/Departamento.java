/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdCompania", query = "SELECT d FROM Departamento d WHERE d.departamentoPK.idCompania = :idCompania"),
    @NamedQuery(name = "Departamento.findByIdDepartamento", query = "SELECT d FROM Departamento d WHERE d.departamentoPK.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Departamento.findByNomDepartamento", query = "SELECT d FROM Departamento d WHERE d.nomDepartamento = :nomDepartamento"),
    @NamedQuery(name = "Departamento.findByDetDepartamento", query = "SELECT d FROM Departamento d WHERE d.detDepartamento = :detDepartamento")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DepartamentoPK departamentoPK;
    @Size(max = 100)
    @Column(name = "nom_departamento", length = 100)
    private String nomDepartamento;
    @Size(max = 200)
    @Column(name = "det_departamento", length = 200)
    private String detDepartamento;
    @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    public Departamento() {
    }

    public Departamento(DepartamentoPK departamentoPK) {
        this.departamentoPK = departamentoPK;
    }

    public Departamento(int idCompania, int idDepartamento) {
        this.departamentoPK = new DepartamentoPK(idCompania, idDepartamento);
    }

    public DepartamentoPK getDepartamentoPK() {
        return departamentoPK;
    }

    public void setDepartamentoPK(DepartamentoPK departamentoPK) {
        this.departamentoPK = departamentoPK;
    }

    public String getNomDepartamento() {
        return nomDepartamento;
    }

    public void setNomDepartamento(String nomDepartamento) {
        this.nomDepartamento = nomDepartamento;
    }

    public String getDetDepartamento() {
        return detDepartamento;
    }

    public void setDetDepartamento(String detDepartamento) {
        this.detDepartamento = detDepartamento;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departamentoPK != null ? departamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.departamentoPK == null && other.departamentoPK != null) || (this.departamentoPK != null && !this.departamentoPK.equals(other.departamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Departamento[ departamentoPK=" + departamentoPK + " ]";
    }
    
}
