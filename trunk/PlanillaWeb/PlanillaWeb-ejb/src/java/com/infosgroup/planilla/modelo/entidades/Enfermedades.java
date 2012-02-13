/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ENFERMEDADES", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedades.findAll", query = "SELECT e FROM Enfermedades e"),
    @NamedQuery(name = "Enfermedades.findByCodEnfermedad", query = "SELECT e FROM Enfermedades e WHERE e.codEnfermedad = :codEnfermedad"),
    @NamedQuery(name = "Enfermedades.findByNomEnfermedad", query = "SELECT e FROM Enfermedades e WHERE e.nomEnfermedad = :nomEnfermedad")})
public class Enfermedades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_ENFERMEDAD", nullable = false)
    private Integer codEnfermedad;
    @Column(name = "NOM_ENFERMEDAD", length = 100)
    private String nomEnfermedad;
    @OneToMany(mappedBy = "codEnfermedad")
    private List<EmpleadoEnfermedades> empleadoEnfermedadesList;

    public Enfermedades() {
    }

    public Enfermedades(Integer codEnfermedad) {
        this.codEnfermedad = codEnfermedad;
    }

    public Integer getCodEnfermedad() {
        return codEnfermedad;
    }

    public void setCodEnfermedad(Integer codEnfermedad) {
        this.codEnfermedad = codEnfermedad;
    }

    public String getNomEnfermedad() {
        return nomEnfermedad;
    }

    public void setNomEnfermedad(String nomEnfermedad) {
        this.nomEnfermedad = nomEnfermedad;
    }

    @XmlTransient
    public List<EmpleadoEnfermedades> getEmpleadoEnfermedadesList() {
        return empleadoEnfermedadesList;
    }

    public void setEmpleadoEnfermedadesList(List<EmpleadoEnfermedades> empleadoEnfermedadesList) {
        this.empleadoEnfermedadesList = empleadoEnfermedadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEnfermedad != null ? codEnfermedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedades)) {
            return false;
        }
        Enfermedades other = (Enfermedades) object;
        if ((this.codEnfermedad == null && other.codEnfermedad != null) || (this.codEnfermedad != null && !this.codEnfermedad.equals(other.codEnfermedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Enfermedades[ codEnfermedad=" + codEnfermedad + " ]";
    }
    
}
