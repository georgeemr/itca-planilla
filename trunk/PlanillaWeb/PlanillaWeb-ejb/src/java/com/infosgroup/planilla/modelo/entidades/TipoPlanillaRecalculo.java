/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_PLANILLA_RECALCULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPlanillaRecalculo.findAll", query = "SELECT t FROM TipoPlanillaRecalculo t"),
    @NamedQuery(name = "TipoPlanillaRecalculo.findByCodCia", query = "SELECT t FROM TipoPlanillaRecalculo t WHERE t.tipoPlanillaRecalculoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoPlanillaRecalculo.findByCodTipopla", query = "SELECT t FROM TipoPlanillaRecalculo t WHERE t.tipoPlanillaRecalculoPK.codTipopla = :codTipopla")})
public class TipoPlanillaRecalculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoPlanillaRecalculoPK tipoPlanillaRecalculoPK;

    public TipoPlanillaRecalculo() {
    }

    public TipoPlanillaRecalculo(TipoPlanillaRecalculoPK tipoPlanillaRecalculoPK) {
        this.tipoPlanillaRecalculoPK = tipoPlanillaRecalculoPK;
    }

    public TipoPlanillaRecalculo(short codCia, short codTipopla) {
        this.tipoPlanillaRecalculoPK = new TipoPlanillaRecalculoPK(codCia, codTipopla);
    }

    public TipoPlanillaRecalculoPK getTipoPlanillaRecalculoPK() {
        return tipoPlanillaRecalculoPK;
    }

    public void setTipoPlanillaRecalculoPK(TipoPlanillaRecalculoPK tipoPlanillaRecalculoPK) {
        this.tipoPlanillaRecalculoPK = tipoPlanillaRecalculoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPlanillaRecalculoPK != null ? tipoPlanillaRecalculoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlanillaRecalculo)) {
            return false;
        }
        TipoPlanillaRecalculo other = (TipoPlanillaRecalculo) object;
        if ((this.tipoPlanillaRecalculoPK == null && other.tipoPlanillaRecalculoPK != null) || (this.tipoPlanillaRecalculoPK != null && !this.tipoPlanillaRecalculoPK.equals(other.tipoPlanillaRecalculoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoPlanillaRecalculo[ tipoPlanillaRecalculoPK=" + tipoPlanillaRecalculoPK + " ]";
    }
    
}
