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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_PRUEBA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPrueba.findAll", query = "SELECT t FROM TipoPrueba t"),
    @NamedQuery(name = "TipoPrueba.findByCodCia", query = "SELECT t FROM TipoPrueba t WHERE t.tipoPruebaPK.codCia = :codCia"),
    @NamedQuery(name = "TipoPrueba.findByCodTipoPrueba", query = "SELECT t FROM TipoPrueba t WHERE t.tipoPruebaPK.codTipoPrueba = :codTipoPrueba"),
    @NamedQuery(name = "TipoPrueba.findByNomTipoPrueba", query = "SELECT t FROM TipoPrueba t WHERE t.nomTipoPrueba = :nomTipoPrueba")})
public class TipoPrueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoPruebaPK tipoPruebaPK;
    @Basic(optional = false)
    @Column(name = "NOM_TIPO_PRUEBA", nullable = false, length = 200)
    private String nomTipoPrueba;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPrueba")
    private List<TipoPruebaXCandidato> tipoPruebaXCandidatoList;

    public TipoPrueba() {
    }

    public TipoPrueba(TipoPruebaPK tipoPruebaPK) {
        this.tipoPruebaPK = tipoPruebaPK;
    }

    public TipoPrueba(TipoPruebaPK tipoPruebaPK, String nomTipoPrueba) {
        this.tipoPruebaPK = tipoPruebaPK;
        this.nomTipoPrueba = nomTipoPrueba;
    }

    public TipoPrueba(short codCia, short codTipoPrueba) {
        this.tipoPruebaPK = new TipoPruebaPK(codCia, codTipoPrueba);
    }

    public TipoPruebaPK getTipoPruebaPK() {
        return tipoPruebaPK;
    }

    public void setTipoPruebaPK(TipoPruebaPK tipoPruebaPK) {
        this.tipoPruebaPK = tipoPruebaPK;
    }

    public String getNomTipoPrueba() {
        return nomTipoPrueba;
    }

    public void setNomTipoPrueba(String nomTipoPrueba) {
        this.nomTipoPrueba = nomTipoPrueba;
    }

    @XmlTransient
    public List<TipoPruebaXCandidato> getTipoPruebaXCandidatoList() {
        return tipoPruebaXCandidatoList;
    }

    public void setTipoPruebaXCandidatoList(List<TipoPruebaXCandidato> tipoPruebaXCandidatoList) {
        this.tipoPruebaXCandidatoList = tipoPruebaXCandidatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPruebaPK != null ? tipoPruebaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPrueba)) {
            return false;
        }
        TipoPrueba other = (TipoPrueba) object;
        if ((this.tipoPruebaPK == null && other.tipoPruebaPK != null) || (this.tipoPruebaPK != null && !this.tipoPruebaPK.equals(other.tipoPruebaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoPrueba[ tipoPruebaPK=" + tipoPruebaPK + " ]";
    }
    
}
