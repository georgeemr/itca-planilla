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
public class TipoEvaluacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_EVALUACION", nullable = false)
    private short codTipoEvaluacion;

    public TipoEvaluacionPK() {
    }

    public TipoEvaluacionPK(short codCia, short codTipoEvaluacion) {
        this.codCia = codCia;
        this.codTipoEvaluacion = codTipoEvaluacion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodTipoEvaluacion() {
        return codTipoEvaluacion;
    }

    public void setCodTipoEvaluacion(short codTipoEvaluacion) {
        this.codTipoEvaluacion = codTipoEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoEvaluacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvaluacionPK)) {
            return false;
        }
        TipoEvaluacionPK other = (TipoEvaluacionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoEvaluacion != other.codTipoEvaluacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoEvaluacionPK[ codCia=" + codCia + ", codTipoEvaluacion=" + codTipoEvaluacion + " ]";
    }
    
}
