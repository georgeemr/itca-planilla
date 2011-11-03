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
public class TipoRespuestaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_respuesta", nullable = false)
    private int codTipoRespuesta;

    public TipoRespuestaPK() {
    }

    public TipoRespuestaPK(int codCia, int codTipoRespuesta) {
        this.codCia = codCia;
        this.codTipoRespuesta = codTipoRespuesta;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getCodTipoRespuesta() {
        return codTipoRespuesta;
    }

    public void setCodTipoRespuesta(int codTipoRespuesta) {
        this.codTipoRespuesta = codTipoRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoRespuesta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRespuestaPK)) {
            return false;
        }
        TipoRespuestaPK other = (TipoRespuestaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoRespuesta != other.codTipoRespuesta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoRespuestaPK[ codCia=" + codCia + ", codTipoRespuesta=" + codTipoRespuesta + " ]";
    }
    
}