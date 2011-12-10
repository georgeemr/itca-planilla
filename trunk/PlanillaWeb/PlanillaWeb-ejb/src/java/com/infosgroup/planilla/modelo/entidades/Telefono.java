/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TELEFONO")
@NamedQueries(
    {
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByIdTelefono", query = "SELECT t FROM Telefono t WHERE t.idTelefono = :idTelefono"),
    @NamedQuery(name = "Telefono.findByNumTelefono", query = "SELECT t FROM Telefono t WHERE t.numTelefono = :numTelefono")
    })
public class Telefono implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TELEFONO", nullable = false)
    private Long idTelefono;

    @Size(max = 20)
    @Column(name = "NUM_TELEFONO", length = 20)
    private String numTelefono;

    @ManyToMany(mappedBy = "telefonoList")
    private List<Sucursal> sucursalList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telefono")
    private List<EmpleadoTelefono> empleadoTelefonoList;

    public Telefono()
    {
    }

    public Telefono(Long idTelefono)
    {
        this.idTelefono = idTelefono;
    }

    public Long getIdTelefono()
    {
        return idTelefono;
    }

    public void setIdTelefono(Long idTelefono)
    {
        this.idTelefono = idTelefono;
    }

    public String getNumTelefono()
    {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono)
    {
        this.numTelefono = numTelefono;
    }

    public List<Sucursal> getSucursalList()
    {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList)
    {
        this.sucursalList = sucursalList;
    }

    public List<EmpleadoTelefono> getEmpleadoTelefonoList()
    {
        return empleadoTelefonoList;
    }

    public void setEmpleadoTelefonoList(List<EmpleadoTelefono> empleadoTelefonoList)
    {
        this.empleadoTelefonoList = empleadoTelefonoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono))
            {
            return false;
            }
        Telefono other = (Telefono) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Telefono[ idTelefono=" + idTelefono + " ]";
    }
    
}
