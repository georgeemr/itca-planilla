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
public class DetPlantillaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_EVALUACION", nullable = false)
    private short codTipoEvaluacion;
    @Basic(optional = false)
    @Column(name = "PERIODO", nullable = false)
    private int periodo;
    @Basic(optional = false)
    @Column(name = "COD_PLANTILLA", nullable = false)
    private short codPlantilla;
    @Basic(optional = false)
    @Column(name = "COD_DET_PLANTILLA", nullable = false)
    private short codDetPlantilla;

    public DetPlantillaPK() {
    }

    public DetPlantillaPK(short codCia, short codTipoEvaluacion, int periodo, short codPlantilla, short codDetPlantilla) {
        this.codCia = codCia;
        this.codTipoEvaluacion = codTipoEvaluacion;
        this.periodo = periodo;
        this.codPlantilla = codPlantilla;
        this.codDetPlantilla = codDetPlantilla;
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

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public short getCodPlantilla() {
        return codPlantilla;
    }

    public void setCodPlantilla(short codPlantilla) {
        this.codPlantilla = codPlantilla;
    }

    public short getCodDetPlantilla() {
        return codDetPlantilla;
    }

    public void setCodDetPlantilla(short codDetPlantilla) {
        this.codDetPlantilla = codDetPlantilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoEvaluacion;
        hash += (int) periodo;
        hash += (int) codPlantilla;
        hash += (int) codDetPlantilla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlantillaPK)) {
            return false;
        }
        DetPlantillaPK other = (DetPlantillaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoEvaluacion != other.codTipoEvaluacion) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.codPlantilla != other.codPlantilla) {
            return false;
        }
        if (this.codDetPlantilla != other.codDetPlantilla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetPlantillaPK[ codCia=" + codCia + ", codTipoEvaluacion=" + codTipoEvaluacion + ", periodo=" + periodo + ", codPlantilla=" + codPlantilla + ", codDetPlantilla=" + codDetPlantilla + " ]";
    }
    
}
