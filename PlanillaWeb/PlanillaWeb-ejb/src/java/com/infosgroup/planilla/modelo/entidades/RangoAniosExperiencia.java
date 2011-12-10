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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "RANGO_ANIOS_EXPERIENCIA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "RangoAniosExperiencia.findAll", query = "SELECT r FROM RangoAniosExperiencia r"),
    @NamedQuery(name = "RangoAniosExperiencia.findByCodRangoAnios", query = "SELECT r FROM RangoAniosExperiencia r WHERE r.codRangoAnios = :codRangoAnios"),
    @NamedQuery(name = "RangoAniosExperiencia.findByDescripcion", query = "SELECT r FROM RangoAniosExperiencia r WHERE r.descripcion = :descripcion")
    })
public class RangoAniosExperiencia implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_RANGO_ANIOS", nullable = false)
    private Long codRangoAnios;

    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "rangoAnios")
    private List<Puesto> puestoList;

    public RangoAniosExperiencia()
    {
    }

    public RangoAniosExperiencia(Long codRangoAnios)
    {
        this.codRangoAnios = codRangoAnios;
    }

    public Long getCodRangoAnios()
    {
        return codRangoAnios;
    }

    public void setCodRangoAnios(Long codRangoAnios)
    {
        this.codRangoAnios = codRangoAnios;
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
    public List<Puesto> getPuestoList()
    {
        return puestoList;
    }

    public void setPuestoList(List<Puesto> puestoList)
    {
        this.puestoList = puestoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (codRangoAnios != null ? codRangoAnios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangoAniosExperiencia))
            {
            return false;
            }
        RangoAniosExperiencia other = (RangoAniosExperiencia) object;
        if ((this.codRangoAnios == null && other.codRangoAnios != null) || (this.codRangoAnios != null && !this.codRangoAnios.equals(other.codRangoAnios)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.RangoAniosExperiencia[ codRangoAnios=" + codRangoAnios + " ]";
    }
    
}
