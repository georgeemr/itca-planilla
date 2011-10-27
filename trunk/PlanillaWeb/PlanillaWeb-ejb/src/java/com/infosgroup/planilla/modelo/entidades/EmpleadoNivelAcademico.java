/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "empleado_nivel_academico", catalog = "planilla", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EmpleadoNivelAcademico.findAll", query = "SELECT e FROM EmpleadoNivelAcademico e"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByIdCompania", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.idCompania = :idCompania"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByIdSucursal", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByIdEmpleado", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByIdNivelAcademico", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.idNivelAcademico = :idNivelAcademico")})
public class EmpleadoNivelAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoNivelAcademicoPK empleadoNivelAcademicoPK;
    @JoinColumn(name = "id_nivel_academico", referencedColumnName = "id_nivel_academico", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NivelAcademico nivelAcademico;

    public EmpleadoNivelAcademico() {
    }

    public EmpleadoNivelAcademico(EmpleadoNivelAcademicoPK empleadoNivelAcademicoPK) {
        this.empleadoNivelAcademicoPK = empleadoNivelAcademicoPK;
    }

    public EmpleadoNivelAcademico(int idCompania, int idSucursal, int idEmpleado, int idNivelAcademico) {
        this.empleadoNivelAcademicoPK = new EmpleadoNivelAcademicoPK(idCompania, idSucursal, idEmpleado, idNivelAcademico);
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
