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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "TipoPlanilla.findAll", query = "SELECT t FROM TipoPlanilla t"),
    @NamedQuery(name = "TipoPlanilla.findByIdCompania", query = "SELECT t FROM TipoPlanilla t WHERE t.tipoPlanillaPK.idCompania = :idCompania"),
    @NamedQuery(name = "TipoPlanilla.findByIdTipoPlanilla", query = "SELECT t FROM TipoPlanilla t WHERE t.tipoPlanillaPK.idTipoPlanilla = :idTipoPlanilla"),
    @NamedQuery(name = "TipoPlanilla.findByNomTipoPlanilla", query = "SELECT t FROM TipoPlanilla t WHERE t.nomTipoPlanilla = :nomTipoPlanilla")
    })
public class TipoPlanilla implements Serializable
{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPlanilla")
    private List<Contrato> contratoList;

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TipoPlanillaPK tipoPlanillaPK;

    @Size(max = 100)
    @Column(name = "NOM_TIPO_PLANILLA", length = 100)
    private String nomTipoPlanilla;

    @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPlanilla")
    private List<Planilla> planillaList;

    public TipoPlanilla()
    {
    }

    public TipoPlanilla(TipoPlanillaPK tipoPlanillaPK)
    {
        this.tipoPlanillaPK = tipoPlanillaPK;
    }

    public TipoPlanilla(long idCompania, long idTipoPlanilla)
    {
        this.tipoPlanillaPK = new TipoPlanillaPK(idCompania, idTipoPlanilla);
    }

    public TipoPlanillaPK getTipoPlanillaPK()
    {
        return tipoPlanillaPK;
    }

    public void setTipoPlanillaPK(TipoPlanillaPK tipoPlanillaPK)
    {
        this.tipoPlanillaPK = tipoPlanillaPK;
    }

    public String getNomTipoPlanilla()
    {
        return nomTipoPlanilla;
    }

    public void setNomTipoPlanilla(String nomTipoPlanilla)
    {
        this.nomTipoPlanilla = nomTipoPlanilla;
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
    public List<Planilla> getPlanillaList()
    {
        return planillaList;
    }

    public void setPlanillaList(List<Planilla> planillaList)
    {
        this.planillaList = planillaList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (tipoPlanillaPK != null ? tipoPlanillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlanilla))
            {
            return false;
            }
        TipoPlanilla other = (TipoPlanilla) object;
        if ((this.tipoPlanillaPK == null && other.tipoPlanillaPK != null) || (this.tipoPlanillaPK != null && !this.tipoPlanillaPK.equals(other.tipoPlanillaPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TipoPlanilla[ tipoPlanillaPK=" + tipoPlanillaPK + " ]";
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }
    
}
