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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "empleado_telefono")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "EmpleadoTelefono.findAll", query = "SELECT e FROM EmpleadoTelefono e"),
    @NamedQuery(name = "EmpleadoTelefono.findByIdCompania", query = "SELECT e FROM EmpleadoTelefono e WHERE e.empleadoTelefonoPK.idCompania = :idCompania"),
    @NamedQuery(name = "EmpleadoTelefono.findByIdSucursal", query = "SELECT e FROM EmpleadoTelefono e WHERE e.empleadoTelefonoPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "EmpleadoTelefono.findByIdEmpleado", query = "SELECT e FROM EmpleadoTelefono e WHERE e.empleadoTelefonoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "EmpleadoTelefono.findByIdTelefono", query = "SELECT e FROM EmpleadoTelefono e WHERE e.empleadoTelefonoPK.idTelefono = :idTelefono")
    })
public class EmpleadoTelefono implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EmpleadoTelefonoPK empleadoTelefonoPK;

    @JoinColumn(name = "id_telefono", referencedColumnName = "id_telefono", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Telefono telefono;

    public EmpleadoTelefono()
    {
    }

    public EmpleadoTelefono(EmpleadoTelefonoPK empleadoTelefonoPK)
    {
        this.empleadoTelefonoPK = empleadoTelefonoPK;
    }

    public EmpleadoTelefono(int idCompania, int idSucursal, int idEmpleado, int idTelefono)
    {
        this.empleadoTelefonoPK = new EmpleadoTelefonoPK(idCompania, idSucursal, idEmpleado, idTelefono);
    }

    public EmpleadoTelefonoPK getEmpleadoTelefonoPK()
    {
        return empleadoTelefonoPK;
    }

    public void setEmpleadoTelefonoPK(EmpleadoTelefonoPK empleadoTelefonoPK)
    {
        this.empleadoTelefonoPK = empleadoTelefonoPK;
    }

    public Telefono getTelefono()
    {
        return telefono;
    }

    public void setTelefono(Telefono telefono)
    {
        this.telefono = telefono;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (empleadoTelefonoPK != null ? empleadoTelefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoTelefono))
            {
            return false;
            }
        EmpleadoTelefono other = (EmpleadoTelefono) object;
        if ((this.empleadoTelefonoPK == null && other.empleadoTelefonoPK != null) || (this.empleadoTelefonoPK != null && !this.empleadoTelefonoPK.equals(other.empleadoTelefonoPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.EmpleadoTelefono[ empleadoTelefonoPK=" + empleadoTelefonoPK + " ]";
    }
    
}
