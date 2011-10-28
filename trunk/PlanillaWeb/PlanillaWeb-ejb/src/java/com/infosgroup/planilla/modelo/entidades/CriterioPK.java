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
public class CriterioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_criterio", nullable = false)
    private int codCriterio;

    public CriterioPK() {
    }

    public CriterioPK(int codCia, int codCriterio) {
        this.codCia = codCia;
        this.codCriterio = codCriterio;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getCodCriterio() {
        return codCriterio;
    }

    public void setCodCriterio(int codCriterio) {
        this.codCriterio = codCriterio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCriterio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioPK)) {
            return false;
        }
        CriterioPK other = (CriterioPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCriterio != other.codCriterio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CriterioPK[ codCia=" + codCia + ", codCriterio=" + codCriterio + " ]";
    }
    
}
