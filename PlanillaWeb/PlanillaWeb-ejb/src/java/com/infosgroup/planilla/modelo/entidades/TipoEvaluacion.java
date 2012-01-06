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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_EVALUACION")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "TipoEvaluacion.findAll", query = "SELECT t FROM TipoEvaluacion t"),
    @NamedQuery(name = "TipoEvaluacion.findByCodCia", query = "SELECT t FROM TipoEvaluacion t WHERE t.tipoEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "TipoEvaluacion.findByCodTipoEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.tipoEvaluacionPK.codTipoEvaluacion = :codTipoEvaluacion"),
    @NamedQuery(name = "TipoEvaluacion.findByNomTipoEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.nomTipoEvaluacion = :nomTipoEvaluacion")
    })
public class TipoEvaluacion implements Serializable
{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEvaluacion1")
    private List<EscalaEvaluacion> escalaEvaluacionList;

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TipoEvaluacionPK tipoEvaluacionPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_TIPO_EVALUACION", nullable = false, length = 200)
    private String nomTipoEvaluacion;

    @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEvaluacion", fetch = FetchType.EAGER)
    private List<Plantilla> plantillaList;

    public TipoEvaluacion()
    {
    }

    public TipoEvaluacion(TipoEvaluacionPK tipoEvaluacionPK)
    {
        this.tipoEvaluacionPK = tipoEvaluacionPK;
    }

    public TipoEvaluacion(TipoEvaluacionPK tipoEvaluacionPK, String nomTipoEvaluacion)
    {
        this.tipoEvaluacionPK = tipoEvaluacionPK;
        this.nomTipoEvaluacion = nomTipoEvaluacion;
    }

    public TipoEvaluacion(long codCia, long codTipoEvaluacion)
    {
        this.tipoEvaluacionPK = new TipoEvaluacionPK(codCia, codTipoEvaluacion);
    }

    public TipoEvaluacionPK getTipoEvaluacionPK()
    {
        return tipoEvaluacionPK;
    }

    public void setTipoEvaluacionPK(TipoEvaluacionPK tipoEvaluacionPK)
    {
        this.tipoEvaluacionPK = tipoEvaluacionPK;
    }

    public String getNomTipoEvaluacion()
    {
        return nomTipoEvaluacion;
    }

    public void setNomTipoEvaluacion(String nomTipoEvaluacion)
    {
        this.nomTipoEvaluacion = nomTipoEvaluacion;
    }

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
    }

    @XmlTransient
    public List<Plantilla> getPlantillaList()
    {
        return plantillaList;
    }

    public void setPlantillaList(List<Plantilla> plantillaList)
    {
        this.plantillaList = plantillaList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (tipoEvaluacionPK != null ? tipoEvaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvaluacion))
            {
            return false;
            }
        TipoEvaluacion other = (TipoEvaluacion) object;
        if ((this.tipoEvaluacionPK == null && other.tipoEvaluacionPK != null) || (this.tipoEvaluacionPK != null && !this.tipoEvaluacionPK.equals(other.tipoEvaluacionPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TipoEvaluacion[ tipoEvaluacionPK=" + tipoEvaluacionPK + " ]";
    }

    @XmlTransient
    public List<EscalaEvaluacion> getEscalaEvaluacionList() {
        return escalaEvaluacionList;
    }

    public void setEscalaEvaluacionList(List<EscalaEvaluacion> escalaEvaluacionList) {
        this.escalaEvaluacionList = escalaEvaluacionList;
    }
    
}
