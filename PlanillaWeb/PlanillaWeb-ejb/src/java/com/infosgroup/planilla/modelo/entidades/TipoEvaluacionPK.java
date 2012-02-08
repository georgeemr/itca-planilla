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
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_EVALUACION", nullable = false)
    private long codTipoEvaluacion;

    public TipoEvaluacionPK() {
    }

    public TipoEvaluacionPK(long codCia, long codTipoEvaluacion) {
        this.codCia = codCia;
        this.codTipoEvaluacion = codTipoEvaluacion;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodTipoEvaluacion() {
        return codTipoEvaluacion;
    }

    public void setCodTipoEvaluacion(long codTipoEvaluacion) {
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
        return "com.infosgroup.planilla.modelo.entidades.TipoEvaluacionPK[ codCia=" + codCia + ", codTipoEvaluacion=" + codTipoEvaluacion + " ]";
    }
    
}
