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
import javax.persistence.JoinColumns;
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
@Table(name = "CRITERIO", uniqueConstraints =
    {
    @UniqueConstraint(columnNames =
        {
        "NOMBRE"
        })
    })
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c"),
    @NamedQuery(name = "Criterio.findByCodCia", query = "SELECT c FROM Criterio c WHERE c.criterioPK.codCia = :codCia"),
    @NamedQuery(name = "Criterio.findByCodigo", query = "SELECT c FROM Criterio c WHERE c.criterioPK.codigo = :codigo"),
    @NamedQuery(name = "Criterio.findByTipo", query = "SELECT c FROM Criterio c WHERE c.criterioPK.tipo = :tipo"),
    @NamedQuery(name = "Criterio.findByNombre", query = "SELECT c FROM Criterio c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Criterio.findByOperador", query = "SELECT c FROM Criterio c WHERE c.operador = :operador"),
    @NamedQuery(name = "Criterio.findByClase", query = "SELECT c FROM Criterio c WHERE c.clase = :clase")
    })
public class Criterio implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CriterioPK criterioPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "OPERADOR", nullable = false, length = 200)
    private String operador;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CLASE", nullable = false, length = 200)
    private String clase;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private TipoCriterio tipoCriterio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterio1")
    private List<CriteriosXPuesto> criteriosXPuestoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterio1")
    private List<CriteriosXCandidato> criteriosXCandidatoList;

    public Criterio()
    {
    }

    public Criterio(CriterioPK criterioPK)
    {
        this.criterioPK = criterioPK;
    }

    public Criterio(CriterioPK criterioPK, String nombre, String operador, String clase)
    {
        this.criterioPK = criterioPK;
        this.nombre = nombre;
        this.operador = operador;
        this.clase = clase;
    }

    public Criterio(long codCia, long codigo, long tipo)
    {
        this.criterioPK = new CriterioPK(codCia, codigo, tipo);
    }

    public CriterioPK getCriterioPK()
    {
        return criterioPK;
    }

    public void setCriterioPK(CriterioPK criterioPK)
    {
        this.criterioPK = criterioPK;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getOperador()
    {
        return operador;
    }

    public void setOperador(String operador)
    {
        this.operador = operador;
    }

    public String getClase()
    {
        return clase;
    }

    public void setClase(String clase)
    {
        this.clase = clase;
    }

    public TipoCriterio getTipoCriterio()
    {
        return tipoCriterio;
    }

    public void setTipoCriterio(TipoCriterio tipoCriterio)
    {
        this.tipoCriterio = tipoCriterio;
    }

    @XmlTransient
    public List<CriteriosXPuesto> getCriteriosXPuestoList()
    {
        return criteriosXPuestoList;
    }

    public void setCriteriosXPuestoList(List<CriteriosXPuesto> criteriosXPuestoList)
    {
        this.criteriosXPuestoList = criteriosXPuestoList;
    }

    @XmlTransient
    public List<CriteriosXCandidato> getCriteriosXCandidatoList()
    {
        return criteriosXCandidatoList;
    }

    public void setCriteriosXCandidatoList(List<CriteriosXCandidato> criteriosXCandidatoList)
    {
        this.criteriosXCandidatoList = criteriosXCandidatoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (criterioPK != null ? criterioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterio))
            {
            return false;
            }
        Criterio other = (Criterio) object;
        if ((this.criterioPK == null && other.criterioPK != null) || (this.criterioPK != null && !this.criterioPK.equals(other.criterioPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Criterio[ criterioPK=" + criterioPK + " ]";
    }
    
}
