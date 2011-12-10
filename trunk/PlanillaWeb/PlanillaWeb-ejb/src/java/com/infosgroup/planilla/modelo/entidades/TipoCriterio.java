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
@Table(name = "TIPO_CRITERIO", uniqueConstraints =
    {
    @UniqueConstraint(columnNames =
        {
        "NOMBRE"
        })
    })
@NamedQueries(
    {
    @NamedQuery(name = "TipoCriterio.findAll", query = "SELECT t FROM TipoCriterio t"),
    @NamedQuery(name = "TipoCriterio.findByCodCia", query = "SELECT t FROM TipoCriterio t WHERE t.tipoCriterioPK.codCia = :codCia"),
    @NamedQuery(name = "TipoCriterio.findByCodigo", query = "SELECT t FROM TipoCriterio t WHERE t.tipoCriterioPK.codigo = :codigo"),
    @NamedQuery(name = "TipoCriterio.findByNombre", query = "SELECT t FROM TipoCriterio t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoCriterio.findByDescripcion", query = "SELECT t FROM TipoCriterio t WHERE t.descripcion = :descripcion")
    })
public class TipoCriterio implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TipoCriterioPK tipoCriterioPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCriterio")
    private List<Criterio> criterioList;

    @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public TipoCriterio()
    {
    }

    public TipoCriterio(TipoCriterioPK tipoCriterioPK)
    {
        this.tipoCriterioPK = tipoCriterioPK;
    }

    public TipoCriterio(TipoCriterioPK tipoCriterioPK, String nombre)
    {
        this.tipoCriterioPK = tipoCriterioPK;
        this.nombre = nombre;
    }

    public TipoCriterio(long codCia, long codigo)
    {
        this.tipoCriterioPK = new TipoCriterioPK(codCia, codigo);
    }

    public TipoCriterioPK getTipoCriterioPK()
    {
        return tipoCriterioPK;
    }

    public void setTipoCriterioPK(TipoCriterioPK tipoCriterioPK)
    {
        this.tipoCriterioPK = tipoCriterioPK;
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

    public List<Criterio> getCriterioList()
    {
        return criterioList;
    }

    public void setCriterioList(List<Criterio> criterioList)
    {
        this.criterioList = criterioList;
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
        hash += (tipoCriterioPK != null ? tipoCriterioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCriterio))
            {
            return false;
            }
        TipoCriterio other = (TipoCriterio) object;
        if ((this.tipoCriterioPK == null && other.tipoCriterioPK != null) || (this.tipoCriterioPK != null && !this.tipoCriterioPK.equals(other.tipoCriterioPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TipoCriterio[ tipoCriterioPK=" + tipoCriterioPK + " ]";
    }
    
}
