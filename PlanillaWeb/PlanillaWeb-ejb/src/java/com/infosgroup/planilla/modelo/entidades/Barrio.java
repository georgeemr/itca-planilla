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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "BARRIO")
@NamedQueries(
    {
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b"),
    @NamedQuery(name = "Barrio.findByIdPais", query = "SELECT b FROM Barrio b WHERE b.barrioPK.idPais = :idPais"),
    @NamedQuery(name = "Barrio.findByIdProvincia", query = "SELECT b FROM Barrio b WHERE b.barrioPK.idProvincia = :idProvincia"),
    @NamedQuery(name = "Barrio.findByIdMunicipio", query = "SELECT b FROM Barrio b WHERE b.barrioPK.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Barrio.findByIdBarrio", query = "SELECT b FROM Barrio b WHERE b.barrioPK.idBarrio = :idBarrio"),
    @NamedQuery(name = "Barrio.findByNomBarrio", query = "SELECT b FROM Barrio b WHERE b.nomBarrio = :nomBarrio"),
    @NamedQuery(name = "Barrio.findByDetBarrio", query = "SELECT b FROM Barrio b WHERE b.detBarrio = :detBarrio")
    })
public class Barrio implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected BarrioPK barrioPK;

    @Size(max = 200)
    @Column(name = "NOM_BARRIO", length = 200)
    private String nomBarrio;

    @Size(max = 200)
    @Column(name = "DET_BARRIO", length = 200)
    private String detBarrio;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID_MUNICIPIO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Municipio municipio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barrio")
    private List<Direccion> direccionList;

    public Barrio()
    {
    }

    public Barrio(BarrioPK barrioPK)
    {
        this.barrioPK = barrioPK;
    }

    public Barrio(long idPais, long idProvincia, long idMunicipio, long idBarrio)
    {
        this.barrioPK = new BarrioPK(idPais, idProvincia, idMunicipio, idBarrio);
    }

    public BarrioPK getBarrioPK()
    {
        return barrioPK;
    }

    public void setBarrioPK(BarrioPK barrioPK)
    {
        this.barrioPK = barrioPK;
    }

    public String getNomBarrio()
    {
        return nomBarrio;
    }

    public void setNomBarrio(String nomBarrio)
    {
        this.nomBarrio = nomBarrio;
    }

    public String getDetBarrio()
    {
        return detBarrio;
    }

    public void setDetBarrio(String detBarrio)
    {
        this.detBarrio = detBarrio;
    }

    public Municipio getMunicipio()
    {
        return municipio;
    }

    public void setMunicipio(Municipio municipio)
    {
        this.municipio = municipio;
    }

    public List<Direccion> getDireccionList()
    {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList)
    {
        this.direccionList = direccionList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (barrioPK != null ? barrioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio))
            {
            return false;
            }
        Barrio other = (Barrio) object;
        if ((this.barrioPK == null && other.barrioPK != null) || (this.barrioPK != null && !this.barrioPK.equals(other.barrioPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Barrio[ barrioPK=" + barrioPK + " ]";
    }
    
}
