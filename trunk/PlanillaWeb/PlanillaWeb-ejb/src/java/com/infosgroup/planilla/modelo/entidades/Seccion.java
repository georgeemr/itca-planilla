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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "SECCION")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s"),
    @NamedQuery(name = "Seccion.findByCodCia", query = "SELECT s FROM Seccion s WHERE s.seccionPK.codCia = :codCia"),
    @NamedQuery(name = "Seccion.findByCodDepto", query = "SELECT s FROM Seccion s WHERE s.seccionPK.codDepto = :codDepto"),
    @NamedQuery(name = "Seccion.findByCodSeccion", query = "SELECT s FROM Seccion s WHERE s.seccionPK.codSeccion = :codSeccion"),
    @NamedQuery(name = "Seccion.findByNomSeccion", query = "SELECT s FROM Seccion s WHERE s.nomSeccion = :nomSeccion")
    })
public class Seccion implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SeccionPK seccionPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_SECCION", nullable = false, length = 200)
    private String nomSeccion;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "ID_DEPARTAMENTO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Departamento departamento;

    public Seccion()
    {
    }

    public Seccion(SeccionPK seccionPK)
    {
        this.seccionPK = seccionPK;
    }

    public Seccion(SeccionPK seccionPK, String nomSeccion)
    {
        this.seccionPK = seccionPK;
        this.nomSeccion = nomSeccion;
    }

    public Seccion(long codCia, long codDepto, long codSeccion)
    {
        this.seccionPK = new SeccionPK(codCia, codDepto, codSeccion);
    }

    public SeccionPK getSeccionPK()
    {
        return seccionPK;
    }

    public void setSeccionPK(SeccionPK seccionPK)
    {
        this.seccionPK = seccionPK;
    }

    public String getNomSeccion()
    {
        return nomSeccion;
    }

    public void setNomSeccion(String nomSeccion)
    {
        this.nomSeccion = nomSeccion;
    }

    public Departamento getDepartamento()
    {
        return departamento;
    }

    public void setDepartamento(Departamento departamento)
    {
        this.departamento = departamento;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (seccionPK != null ? seccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion))
            {
            return false;
            }
        Seccion other = (Seccion) object;
        if ((this.seccionPK == null && other.seccionPK != null) || (this.seccionPK != null && !this.seccionPK.equals(other.seccionPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Seccion[ seccionPK=" + seccionPK + " ]";
    }
    
}
