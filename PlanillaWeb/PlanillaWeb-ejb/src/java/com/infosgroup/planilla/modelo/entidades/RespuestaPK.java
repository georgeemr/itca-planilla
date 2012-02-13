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
public class RespuestaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_RESPUESTA", nullable = false)
    private short codTipoRespuesta;
    @Basic(optional = false)
    @Column(name = "COD_RESPUESTA", nullable = false)
    private short codRespuesta;

    public RespuestaPK() {
    }

    public RespuestaPK(short codCia, short codTipoRespuesta, short codRespuesta) {
        this.codCia = codCia;
        this.codTipoRespuesta = codTipoRespuesta;
        this.codRespuesta = codRespuesta;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodTipoRespuesta() {
        return codTipoRespuesta;
    }

    public void setCodTipoRespuesta(short codTipoRespuesta) {
        this.codTipoRespuesta = codTipoRespuesta;
    }

    public short getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(short codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoRespuesta;
        hash += (int) codRespuesta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaPK)) {
            return false;
        }
        RespuestaPK other = (RespuestaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoRespuesta != other.codTipoRespuesta) {
            return false;
        }
        if (this.codRespuesta != other.codRespuesta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.RespuestaPK[ codCia=" + codCia + ", codTipoRespuesta=" + codTipoRespuesta + ", codRespuesta=" + codRespuesta + " ]";
    }
    
}
