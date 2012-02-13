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
public class TipoHorarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "TIPO_HORARIO", nullable = false, length = 1)
    private String tipoHorario;

    public TipoHorarioPK() {
    }

    public TipoHorarioPK(short codCia, String tipoHorario) {
        this.codCia = codCia;
        this.tipoHorario = tipoHorario;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public String getTipoHorario() {
        return tipoHorario;
    }

    public void setTipoHorario(String tipoHorario) {
        this.tipoHorario = tipoHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (tipoHorario != null ? tipoHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHorarioPK)) {
            return false;
        }
        TipoHorarioPK other = (TipoHorarioPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.tipoHorario == null && other.tipoHorario != null) || (this.tipoHorario != null && !this.tipoHorario.equals(other.tipoHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoHorarioPK[ codCia=" + codCia + ", tipoHorario=" + tipoHorario + " ]";
    }
    
}
