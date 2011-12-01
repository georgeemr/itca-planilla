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
@Table(name = "rango_edad")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "RangoEdad.findAll", query = "SELECT r FROM RangoEdad r"),
    @NamedQuery(name = "RangoEdad.findByCodRangoEdad", query = "SELECT r FROM RangoEdad r WHERE r.codRangoEdad = :codRangoEdad"),
    @NamedQuery(name = "RangoEdad.findByDescripcion", query = "SELECT r FROM RangoEdad r WHERE r.descripcion = :descripcion")
    })
public class RangoEdad implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_rango_edad", nullable = false)
    private Integer codRangoEdad;

    @Size(max = 2147483647)
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;

    @OneToMany(mappedBy = "rangoEdad")
    private List<Puesto> puestoList;

    public RangoEdad()
    {
    }

    public RangoEdad(Integer codRangoEdad)
    {
        this.codRangoEdad = codRangoEdad;
    }

    public Integer getCodRangoEdad()
    {
        return codRangoEdad;
    }

    public void setCodRangoEdad(Integer codRangoEdad)
    {
        this.codRangoEdad = codRangoEdad;
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
        hash += (codRangoEdad != null ? codRangoEdad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangoEdad))
            {
            return false;
            }
        RangoEdad other = (RangoEdad) object;
        if ((this.codRangoEdad == null && other.codRangoEdad != null) || (this.codRangoEdad != null && !this.codRangoEdad.equals(other.codRangoEdad)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.RangoEdad[ codRangoEdad=" + codRangoEdad + " ]";
    }
    
}
