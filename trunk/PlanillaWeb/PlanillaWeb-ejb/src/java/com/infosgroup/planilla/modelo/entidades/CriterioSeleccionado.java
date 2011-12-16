/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CRITERIO_SELECCIONADO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "CriterioSeleccionado.findAll", query = "SELECT c FROM CriterioSeleccionado c"),
    @NamedQuery(name = "CriterioSeleccionado.findByCodCia", query = "SELECT c FROM CriterioSeleccionado c WHERE c.criterioSeleccionadoPK.codCia = :codCia"),
    @NamedQuery(name = "CriterioSeleccionado.findByCodigo", query = "SELECT c FROM CriterioSeleccionado c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CriterioSeleccionado.findByTipo", query = "SELECT c FROM CriterioSeleccionado c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "CriterioSeleccionado.findByCorrelativo", query = "SELECT c FROM CriterioSeleccionado c WHERE c.criterioSeleccionadoPK.correlativo = :correlativo"),
    @NamedQuery(name = "CriterioSeleccionado.findByUsuario", query = "SELECT c FROM CriterioSeleccionado c WHERE c.criterioSeleccionadoPK.usuario = :usuario")
    })
public class CriterioSeleccionado implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CriterioSeleccionadoPK criterioSeleccionadoPK;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
    private long codigo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO", nullable = false)
    private long tipo;

    public CriterioSeleccionado()
    {
    }

    public CriterioSeleccionado(CriterioSeleccionadoPK criterioSeleccionadoPK)
    {
        this.criterioSeleccionadoPK = criterioSeleccionadoPK;
    }

    public CriterioSeleccionado(CriterioSeleccionadoPK criterioSeleccionadoPK, long codigo, long tipo)
    {
        this.criterioSeleccionadoPK = criterioSeleccionadoPK;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public CriterioSeleccionado(long codCia, long correlativo, String usuario)
    {
        this.criterioSeleccionadoPK = new CriterioSeleccionadoPK(codCia, correlativo, usuario);
    }

    public CriterioSeleccionadoPK getCriterioSeleccionadoPK()
    {
        return criterioSeleccionadoPK;
    }

    public void setCriterioSeleccionadoPK(CriterioSeleccionadoPK criterioSeleccionadoPK)
    {
        this.criterioSeleccionadoPK = criterioSeleccionadoPK;
    }

    public long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(long codigo)
    {
        this.codigo = codigo;
    }

    public long getTipo()
    {
        return tipo;
    }

    public void setTipo(long tipo)
    {
        this.tipo = tipo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (criterioSeleccionadoPK != null ? criterioSeleccionadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeleccionado))
            {
            return false;
            }
        CriterioSeleccionado other = (CriterioSeleccionado) object;
        if ((this.criterioSeleccionadoPK == null && other.criterioSeleccionadoPK != null) || (this.criterioSeleccionadoPK != null && !this.criterioSeleccionadoPK.equals(other.criterioSeleccionadoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.CriterioSeleccionado[ criterioSeleccionadoPK=" + criterioSeleccionadoPK + " ]";
    }
    
}
