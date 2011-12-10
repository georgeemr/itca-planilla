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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ESTADO_CONCURSO", uniqueConstraints =
    {
    @UniqueConstraint(columnNames =
        {
        "NOMBRE"
        })
    })
@NamedQueries(
    {
    @NamedQuery(name = "EstadoConcurso.findAll", query = "SELECT e FROM EstadoConcurso e"),
    @NamedQuery(name = "EstadoConcurso.findByCodCia", query = "SELECT e FROM EstadoConcurso e WHERE e.estadoConcursoPK.codCia = :codCia"),
    @NamedQuery(name = "EstadoConcurso.findByCodigo", query = "SELECT e FROM EstadoConcurso e WHERE e.estadoConcursoPK.codigo = :codigo"),
    @NamedQuery(name = "EstadoConcurso.findByNombre", query = "SELECT e FROM EstadoConcurso e WHERE e.nombre = :nombre")
    })
public class EstadoConcurso implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EstadoConcursoPK estadoConcursoPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoConcurso")
    private List<Concurso> concursoList;

    @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public EstadoConcurso()
    {
    }

    public EstadoConcurso(EstadoConcursoPK estadoConcursoPK)
    {
        this.estadoConcursoPK = estadoConcursoPK;
    }

    public EstadoConcurso(EstadoConcursoPK estadoConcursoPK, String nombre)
    {
        this.estadoConcursoPK = estadoConcursoPK;
        this.nombre = nombre;
    }

    public EstadoConcurso(long codCia, String codigo)
    {
        this.estadoConcursoPK = new EstadoConcursoPK(codCia, codigo);
    }

    public EstadoConcursoPK getEstadoConcursoPK()
    {
        return estadoConcursoPK;
    }

    public void setEstadoConcursoPK(EstadoConcursoPK estadoConcursoPK)
    {
        this.estadoConcursoPK = estadoConcursoPK;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public List<Concurso> getConcursoList()
    {
        return concursoList;
    }

    public void setConcursoList(List<Concurso> concursoList)
    {
        this.concursoList = concursoList;
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
        hash += (estadoConcursoPK != null ? estadoConcursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConcurso))
            {
            return false;
            }
        EstadoConcurso other = (EstadoConcurso) object;
        if ((this.estadoConcursoPK == null && other.estadoConcursoPK != null) || (this.estadoConcursoPK != null && !this.estadoConcursoPK.equals(other.estadoConcursoPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.EstadoConcurso[ estadoConcursoPK=" + estadoConcursoPK + " ]";
    }
    
}
