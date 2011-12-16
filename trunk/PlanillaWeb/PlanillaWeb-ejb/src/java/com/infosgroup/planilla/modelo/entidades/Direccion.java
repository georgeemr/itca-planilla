/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DIRECCION")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByIdPais", query = "SELECT d FROM Direccion d WHERE d.direccionPK.idPais = :idPais"),
    @NamedQuery(name = "Direccion.findByIdProvincia", query = "SELECT d FROM Direccion d WHERE d.direccionPK.idProvincia = :idProvincia"),
    @NamedQuery(name = "Direccion.findByIdMunicipio", query = "SELECT d FROM Direccion d WHERE d.direccionPK.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Direccion.findByIdBarrio", query = "SELECT d FROM Direccion d WHERE d.direccionPK.idBarrio = :idBarrio"),
    @NamedQuery(name = "Direccion.findByNumCasa", query = "SELECT d FROM Direccion d WHERE d.direccionPK.numCasa = :numCasa"),
    @NamedQuery(name = "Direccion.findByNumCodpostal", query = "SELECT d FROM Direccion d WHERE d.numCodpostal = :numCodpostal"),
    @NamedQuery(name = "Direccion.findByDetDireccion", query = "SELECT d FROM Direccion d WHERE d.detDireccion = :detDireccion")
    })
public class Direccion implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DireccionPK direccionPK;

    @Size(max = 200)
    @Column(name = "NUM_CODPOSTAL", length = 200)
    private String numCodpostal;

    @Size(max = 200)
    @Column(name = "DET_DIRECCION", length = 200)
    private String detDireccion;

    @JoinTable(name = "DIRECCION_SUCURSAL", joinColumns =
        {
        @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS", nullable = false),
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", nullable = false),
        @JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID_MUNICIPIO", nullable = false),
        @JoinColumn(name = "ID_BARRIO", referencedColumnName = "ID_BARRIO", nullable = false),
        @JoinColumn(name = "NUM_CASA", referencedColumnName = "NUM_CASA", nullable = false)
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false),
        @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL", nullable = false)
        })
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Sucursal> sucursalList;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID_MUNICIPIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_BARRIO", referencedColumnName = "ID_BARRIO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Barrio barrio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccion", fetch = FetchType.EAGER)
    private List<DireccionEmpleado> direccionEmpleadoList;

    public Direccion()
    {
    }

    public Direccion(DireccionPK direccionPK)
    {
        this.direccionPK = direccionPK;
    }

    public Direccion(long idPais, long idProvincia, long idMunicipio, long idBarrio, String numCasa)
    {
        this.direccionPK = new DireccionPK(idPais, idProvincia, idMunicipio, idBarrio, numCasa);
    }

    public DireccionPK getDireccionPK()
    {
        return direccionPK;
    }

    public void setDireccionPK(DireccionPK direccionPK)
    {
        this.direccionPK = direccionPK;
    }

    public String getNumCodpostal()
    {
        return numCodpostal;
    }

    public void setNumCodpostal(String numCodpostal)
    {
        this.numCodpostal = numCodpostal;
    }

    public String getDetDireccion()
    {
        return detDireccion;
    }

    public void setDetDireccion(String detDireccion)
    {
        this.detDireccion = detDireccion;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList()
    {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList)
    {
        this.sucursalList = sucursalList;
    }

    public Barrio getBarrio()
    {
        return barrio;
    }

    public void setBarrio(Barrio barrio)
    {
        this.barrio = barrio;
    }

    @XmlTransient
    public List<DireccionEmpleado> getDireccionEmpleadoList()
    {
        return direccionEmpleadoList;
    }

    public void setDireccionEmpleadoList(List<DireccionEmpleado> direccionEmpleadoList)
    {
        this.direccionEmpleadoList = direccionEmpleadoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (direccionPK != null ? direccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion))
            {
            return false;
            }
        Direccion other = (Direccion) object;
        if ((this.direccionPK == null && other.direccionPK != null) || (this.direccionPK != null && !this.direccionPK.equals(other.direccionPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Direccion[ direccionPK=" + direccionPK + " ]";
    }
    
}
