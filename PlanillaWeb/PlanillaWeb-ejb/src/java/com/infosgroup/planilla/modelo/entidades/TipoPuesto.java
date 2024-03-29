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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPuesto.findAll", query = "SELECT t FROM TipoPuesto t"),
    @NamedQuery(name = "TipoPuesto.findByCodCia", query = "SELECT t FROM TipoPuesto t WHERE t.tipoPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoPuesto.findByCodTipoPuesto", query = "SELECT t FROM TipoPuesto t WHERE t.tipoPuestoPK.codTipoPuesto = :codTipoPuesto"),
    @NamedQuery(name = "TipoPuesto.findByNomTipo", query = "SELECT t FROM TipoPuesto t WHERE t.nomTipo = :nomTipo")})
public class TipoPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoPuestoPK tipoPuestoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_TIPO", nullable = false, length = 200)
    private String nomTipo;

    public TipoPuesto() {
    }

    public TipoPuesto(TipoPuestoPK tipoPuestoPK) {
        this.tipoPuestoPK = tipoPuestoPK;
    }

    public TipoPuesto(TipoPuestoPK tipoPuestoPK, String nomTipo) {
        this.tipoPuestoPK = tipoPuestoPK;
        this.nomTipo = nomTipo;
    }

    public TipoPuesto(short codCia, short codTipoPuesto) {
        this.tipoPuestoPK = new TipoPuestoPK(codCia, codTipoPuesto);
    }

    public TipoPuestoPK getTipoPuestoPK() {
        return tipoPuestoPK;
    }

    public void setTipoPuestoPK(TipoPuestoPK tipoPuestoPK) {
        this.tipoPuestoPK = tipoPuestoPK;
    }

    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPuestoPK != null ? tipoPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPuesto)) {
            return false;
        }
        TipoPuesto other = (TipoPuesto) object;
        if ((this.tipoPuestoPK == null && other.tipoPuestoPK != null) || (this.tipoPuestoPK != null && !this.tipoPuestoPK.equals(other.tipoPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoPuesto[ tipoPuestoPK=" + tipoPuestoPK + " ]";
    }
    
}
