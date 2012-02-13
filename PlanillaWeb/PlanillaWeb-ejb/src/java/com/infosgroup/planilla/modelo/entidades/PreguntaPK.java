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
public class PreguntaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_FACTOR", nullable = false)
    private short codFactor;
    @Basic(optional = false)
    @Column(name = "COD_PREGUNTA", nullable = false, length = 1)
    private String codPregunta;

    public PreguntaPK() {
    }

    public PreguntaPK(short codCia, short codFactor, String codPregunta) {
        this.codCia = codCia;
        this.codFactor = codFactor;
        this.codPregunta = codPregunta;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodFactor() {
        return codFactor;
    }

    public void setCodFactor(short codFactor) {
        this.codFactor = codFactor;
    }

    public String getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(String codPregunta) {
        this.codPregunta = codPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codFactor;
        hash += (codPregunta != null ? codPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaPK)) {
            return false;
        }
        PreguntaPK other = (PreguntaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codFactor != other.codFactor) {
            return false;
        }
        if ((this.codPregunta == null && other.codPregunta != null) || (this.codPregunta != null && !this.codPregunta.equals(other.codPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PreguntaPK[ codCia=" + codCia + ", codFactor=" + codFactor + ", codPregunta=" + codPregunta + " ]";
    }
    
}
