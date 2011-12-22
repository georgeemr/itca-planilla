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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ESTADO_CONTRATO", uniqueConstraints =
    {
    @UniqueConstraint(columnNames =
        {
        "NOMBRE"
        })
    })
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "EstadoContrato.findAll", query = "SELECT e FROM EstadoContrato e"),
    @NamedQuery(name = "EstadoContrato.findByCodCia", query = "SELECT e FROM EstadoContrato e WHERE e.estadoContratoPK.codCia = :codCia"),
    @NamedQuery(name = "EstadoContrato.findByCodigo", query = "SELECT e FROM EstadoContrato e WHERE e.estadoContratoPK.codigo = :codigo"),
    @NamedQuery(name = "EstadoContrato.findByNombre", query = "SELECT e FROM EstadoContrato e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoContrato.findByDescripcion", query = "SELECT e FROM EstadoContrato e WHERE e.descripcion = :descripcion")
    })
public class EstadoContrato implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EstadoContratoPK estadoContratoPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoContrato", fetch = FetchType.EAGER)
    private List<Contrato> contratoList;

    @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    public EstadoContrato()
    {
    }

    public EstadoContrato(EstadoContratoPK estadoContratoPK)
    {
        this.estadoContratoPK = estadoContratoPK;
    }

    public EstadoContrato(EstadoContratoPK estadoContratoPK, String nombre)
    {
        this.estadoContratoPK = estadoContratoPK;
        this.nombre = nombre;
    }

    public EstadoContrato(long codCia, long codigo)
    {
        this.estadoContratoPK = new EstadoContratoPK(codCia, codigo);
    }

    public EstadoContratoPK getEstadoContratoPK()
    {
        return estadoContratoPK;
    }

    public void setEstadoContratoPK(EstadoContratoPK estadoContratoPK)
    {
        this.estadoContratoPK = estadoContratoPK;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
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

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (estadoContratoPK != null ? estadoContratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoContrato))
            {
            return false;
            }
        EstadoContrato other = (EstadoContrato) object;
        if ((this.estadoContratoPK == null && other.estadoContratoPK != null) || (this.estadoContratoPK != null && !this.estadoContratoPK.equals(other.estadoContratoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.EstadoContrato[ estadoContratoPK=" + estadoContratoPK + " ]";
    }
    
}
