/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@NamedQueries(
    {
    @NamedQuery(name = "EmpleadoNivelAcademico.findAll", query = "SELECT e FROM EmpleadoNivelAcademico e"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByIdCompania", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.idCompania = :idCompania"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByIdSucursal", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByIdEmpleado", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "EmpleadoNivelAcademico.findByIdNivelAcademico", query = "SELECT e FROM EmpleadoNivelAcademico e WHERE e.empleadoNivelAcademicoPK.idNivelAcademico = :idNivelAcademico")
    })
public class EmpleadoNivelAcademico implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EmpleadoNivelAcademicoPK empleadoNivelAcademicoPK;

    @JoinColumn(name = "ID_NIVEL_ACADEMICO", referencedColumnName = "ID_NIVEL_ACADEMICO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private NivelAcademico nivelAcademico;

    public EmpleadoNivelAcademico()
    {
    }

    public EmpleadoNivelAcademico(EmpleadoNivelAcademicoPK empleadoNivelAcademicoPK)
    {
        this.empleadoNivelAcademicoPK = empleadoNivelAcademicoPK;
    }

    public EmpleadoNivelAcademico(long idCompania, long idSucursal, long idEmpleado, long idNivelAcademico)
    {
        this.empleadoNivelAcademicoPK = new EmpleadoNivelAcademicoPK(idCompania, idSucursal, idEmpleado, idNivelAcademico);
    }

    public EmpleadoNivelAcademicoPK getEmpleadoNivelAcademicoPK()
    {
        return empleadoNivelAcademicoPK;
    }

    public void setEmpleadoNivelAcademicoPK(EmpleadoNivelAcademicoPK empleadoNivelAcademicoPK)
    {
        this.empleadoNivelAcademicoPK = empleadoNivelAcademicoPK;
    }

    public NivelAcademico getNivelAcademico()
    {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico)
    {
        this.nivelAcademico = nivelAcademico;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (empleadoNivelAcademicoPK != null ? empleadoNivelAcademicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoNivelAcademico))
            {
            return false;
            }
        EmpleadoNivelAcademico other = (EmpleadoNivelAcademico) object;
        if ((this.empleadoNivelAcademicoPK == null && other.empleadoNivelAcademicoPK != null) || (this.empleadoNivelAcademicoPK != null && !this.empleadoNivelAcademicoPK.equals(other.empleadoNivelAcademicoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.EmpleadoNivelAcademico[ empleadoNivelAcademicoPK=" + empleadoNivelAcademicoPK + " ]";
    }
    
}
