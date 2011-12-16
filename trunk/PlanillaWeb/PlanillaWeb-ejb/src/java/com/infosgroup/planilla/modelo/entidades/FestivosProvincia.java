/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FESTIVOS_PROVINCIA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "FestivosProvincia.findAll", query = "SELECT f FROM FestivosProvincia f"),
    @NamedQuery(name = "FestivosProvincia.findByIdCompania", query = "SELECT f FROM FestivosProvincia f WHERE f.festivosProvinciaPK.idCompania = :idCompania"),
    @NamedQuery(name = "FestivosProvincia.findByIdPais", query = "SELECT f FROM FestivosProvincia f WHERE f.festivosProvinciaPK.idPais = :idPais"),
    @NamedQuery(name = "FestivosProvincia.findByIdProvincia", query = "SELECT f FROM FestivosProvincia f WHERE f.festivosProvinciaPK.idProvincia = :idProvincia"),
    @NamedQuery(name = "FestivosProvincia.findByAnio", query = "SELECT f FROM FestivosProvincia f WHERE f.festivosProvinciaPK.anio = :anio"),
    @NamedQuery(name = "FestivosProvincia.findByMes", query = "SELECT f FROM FestivosProvincia f WHERE f.festivosProvinciaPK.mes = :mes"),
    @NamedQuery(name = "FestivosProvincia.findByDia", query = "SELECT f FROM FestivosProvincia f WHERE f.festivosProvinciaPK.dia = :dia")
    })
public class FestivosProvincia implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected FestivosProvinciaPK festivosProvinciaPK;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Provincia provincia;

    @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    public FestivosProvincia()
    {
    }

    public FestivosProvincia(FestivosProvinciaPK festivosProvinciaPK)
    {
        this.festivosProvinciaPK = festivosProvinciaPK;
    }

    public FestivosProvincia(short idCompania, short idPais, int idProvincia, short anio, short mes, short dia)
    {
        this.festivosProvinciaPK = new FestivosProvinciaPK(idCompania, idPais, idProvincia, anio, mes, dia);
    }

    public FestivosProvinciaPK getFestivosProvinciaPK()
    {
        return festivosProvinciaPK;
    }

    public void setFestivosProvinciaPK(FestivosProvinciaPK festivosProvinciaPK)
    {
        this.festivosProvinciaPK = festivosProvinciaPK;
    }

    public Provincia getProvincia()
    {
        return provincia;
    }

    public void setProvincia(Provincia provincia)
    {
        this.provincia = provincia;
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
        hash += (festivosProvinciaPK != null ? festivosProvinciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FestivosProvincia))
            {
            return false;
            }
        FestivosProvincia other = (FestivosProvincia) object;
        if ((this.festivosProvinciaPK == null && other.festivosProvinciaPK != null) || (this.festivosProvinciaPK != null && !this.festivosProvinciaPK.equals(other.festivosProvinciaPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.FestivosProvincia[ festivosProvinciaPK=" + festivosProvinciaPK + " ]";
    }
    
}
