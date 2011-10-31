/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class TipoPlanillaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_planilla", nullable = false)
    private int idTipoPlanilla;

    public TipoPlanillaPK() {
    }

    public TipoPlanillaPK(int idCompania, int idTipoPlanilla) {
        this.idCompania = idCompania;
        this.idTipoPlanilla = idTipoPlanilla;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public int getIdTipoPlanilla() {
        return idTipoPlanilla;
    }

    public void setIdTipoPlanilla(int idTipoPlanilla) {
        this.idTipoPlanilla = idTipoPlanilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoPlanilla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlanillaPK)) {
            return false;
        }
        TipoPlanillaPK other = (TipoPlanillaPK) object;
        if (this.idCompania != other.idCompania) {
            return false;
        }
        if (this.idTipoPlanilla != other.idTipoPlanilla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK[ idCompania=" + idCompania + ", idTipoPlanilla=" + idTipoPlanilla + " ]";
    }
    
}