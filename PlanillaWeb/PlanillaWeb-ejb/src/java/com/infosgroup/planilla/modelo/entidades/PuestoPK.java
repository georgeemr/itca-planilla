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
public class PuestoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_puesto", nullable = false)
    private int idTipoPuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_puesto", nullable = false)
    private int idPuesto;

    public PuestoPK() {
    }

    public PuestoPK(int idTipoPuesto, int idPuesto) {
        this.idTipoPuesto = idTipoPuesto;
        this.idPuesto = idPuesto;
    }

    public int getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(int idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTipoPuesto;
        hash += (int) idPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuestoPK)) {
            return false;
        }
        PuestoPK other = (PuestoPK) object;
        if (this.idTipoPuesto != other.idTipoPuesto) {
            return false;
        }
        if (this.idPuesto != other.idPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PuestoPK[ idTipoPuesto=" + idTipoPuesto + ", idPuesto=" + idPuesto + " ]";
    }
    
}
