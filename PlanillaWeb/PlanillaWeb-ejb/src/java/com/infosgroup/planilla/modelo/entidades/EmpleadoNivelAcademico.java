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
@Table(name = "EMPLEADO_NIVEL_ACADEMICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoNivelAcademico.findAll", query = "SELECT e FROM EmpleadoNivelAcademico e"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByCodCia", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.codCia = :codCia"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByCodSucursal", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.codSucursal = :codSucursal"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByCodEmpleado", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.codEmpleado = :codEmpleado"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByCodNivelAcademico", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.codNivelAcademico = :codNivelAcademico")})
public class EmpleadoNivelAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoNivelAcademicoPK empleadoNivelAcademicoPK;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_NIVEL_ACADEMICO", referencedColumnName = "COD_NIVEL_ACADEMICO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private NivelAcademico nivelAcademico;

    public EmpleadoNivelAcademico() {
    }

    public EmpleadoNivelAcademico(EmpleadoNivelAcademicoPK empleadoNivelAcademicoPK) {
        this.empleadoNivelAcademicoPK = empleadoNivelAcademicoPK;
    }

    public EmpleadoNivelAcademico(long codCia, long codSucursal, long codEmpleado, long codNivelAcademico) {
        this.empleadoNivelAcademicoPK = new EmpleadoNivelAcademicoPK(codCia, codSucursal, codEmpleado, codNivelAcademico);
    }

    public EmpleadoNivelAcademicoPK getEmpleadoNivelAcademicoPK() {
        return empleadoNivelAcademicoPK;
    }

    public void setEmpleadoNivelAcademicoPK(EmpleadoNivelAcademicoPK empleadoNivelAcademicoPK) {
        this.empleadoNivelAcademicoPK = empleadoNivelAcademicoPK;
    }

    public NivelAcademico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoNivelAcademicoPK != null ? empleadoNivelAcademicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoNivelAcademico)) {
            return false;
        }
        EmpleadoNivelAcademico other = (EmpleadoNivelAcademico) object;
        if ((this.empleadoNivelAcademicoPK == null && other.empleadoNivelAcademicoPK != null) || (this.empleadoNivelAcademicoPK != null && !this.empleadoNivelAcademicoPK.equals(other.empleadoNivelAcademicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EmpleadoNivelAcademico[ empleadoNivelAcademicoPK=" + empleadoNivelAcademicoPK + " ]";
    }
    
}
