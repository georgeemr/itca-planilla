/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class CriteriosXPuestoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_PUESTO", nullable = false)
    private short codPuesto;
    @Basic(optional = false)
    @Column(name = "CRITERIO", nullable = false)
    private int criterio;

    public CriteriosXPuestoPK() {
    }

    public CriteriosXPuestoPK(short codCia, short codPuesto, int criterio) {
        this.codCia = codCia;
        this.codPuesto = codPuesto;
        this.criterio = criterio;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(short codPuesto) {
        this.codPuesto = codPuesto;
    }

    public int getCriterio() {
        return criterio;
    }

    public void setCriterio(int criterio) {
        this.criterio = criterio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codPuesto;
        hash += (int) criterio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXPuestoPK)) {
            return false;
        }
        CriteriosXPuestoPK other = (CriteriosXPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPuesto != other.codPuesto) {
            return false;
        }
        if (this.criterio != other.criterio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.infosgroup.modelocandidatojpa.entidades.CriteriosXPuestoGbPK[ codCia=" + codCia + ", codPuesto=" + codPuesto + ", criterio=" + criterio + " ]";
    }
    
}
