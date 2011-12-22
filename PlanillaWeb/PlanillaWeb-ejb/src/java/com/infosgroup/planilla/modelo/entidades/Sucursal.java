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
@Table(name = "SUCURSAL")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdCompania", query = "SELECT s FROM Sucursal s WHERE s.sucursalPK.idCompania = :idCompania"),
    @NamedQuery(name = "Sucursal.findByIdSucursal", query = "SELECT s FROM Sucursal s WHERE s.sucursalPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "Sucursal.findByNomSucursal", query = "SELECT s FROM Sucursal s WHERE s.nomSucursal = :nomSucursal"),
    @NamedQuery(name = "Sucursal.findByDetSucursal", query = "SELECT s FROM Sucursal s WHERE s.detSucursal = :detSucursal")
    })
public class Sucursal implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SucursalPK sucursalPK;

    @Size(max = 100)
    @Column(name = "NOM_SUCURSAL", length = 100)
    private String nomSucursal;

    @Size(max = 200)
    @Column(name = "DET_SUCURSAL", length = 200)
    private String detSucursal;

    @ManyToMany(mappedBy = "sucursalList", fetch = FetchType.EAGER)
    private List<Direccion> direccionList;

    @JoinTable(name = "SUCURSAL_TELEFONO", joinColumns =
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false),
        @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL", nullable = false)
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "ID_TELEFONO", referencedColumnName = "ID_TELEFONO", nullable = false)
        })
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Telefono> telefonoList;

    @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.EAGER)
    private List<ResumenAsistencia> resumenAsistenciaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.EAGER)
    private List<Contrato> contratoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.EAGER)
    private List<PuestoEmpleado> puestoEmpleadoList;

    public Sucursal()
    {
    }

    public Sucursal(SucursalPK sucursalPK)
    {
        this.sucursalPK = sucursalPK;
    }

    public Sucursal(long idCompania, long idSucursal)
    {
        this.sucursalPK = new SucursalPK(idCompania, idSucursal);
    }

    public SucursalPK getSucursalPK()
    {
        return sucursalPK;
    }

    public void setSucursalPK(SucursalPK sucursalPK)
    {
        this.sucursalPK = sucursalPK;
    }

    public String getNomSucursal()
    {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal)
    {
        this.nomSucursal = nomSucursal;
    }

    public String getDetSucursal()
    {
        return detSucursal;
    }

    public void setDetSucursal(String detSucursal)
    {
        this.detSucursal = detSucursal;
    }

    @XmlTransient
    public List<Direccion> getDireccionList()
    {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList)
    {
        this.direccionList = direccionList;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList()
    {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList)
    {
        this.telefonoList = telefonoList;
    }

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
    }

    @XmlTransient
    public List<ResumenAsistencia> getResumenAsistenciaList()
    {
        return resumenAsistenciaList;
    }

    public void setResumenAsistenciaList(List<ResumenAsistencia> resumenAsistenciaList)
    {
        this.resumenAsistenciaList = resumenAsistenciaList;
    }

    @XmlTransient
    public List<Contrato> getContratoList()
    {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList)
    {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<PuestoEmpleado> getPuestoEmpleadoList()
    {
        return puestoEmpleadoList;
    }

    public void setPuestoEmpleadoList(List<PuestoEmpleado> puestoEmpleadoList)
    {
        this.puestoEmpleadoList = puestoEmpleadoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (sucursalPK != null ? sucursalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal))
            {
            return false;
            }
        Sucursal other = (Sucursal) object;
        if ((this.sucursalPK == null && other.sucursalPK != null) || (this.sucursalPK != null && !this.sucursalPK.equals(other.sucursalPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Sucursal[ sucursalPK=" + sucursalPK + " ]";
    }
    
}
