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
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class SupervisionObraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_OBRA", nullable = false, length = 2)
    private String tipoObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_OBRA", nullable = false)
    private int codObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_PROY", nullable = false)
    private short subProy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SUPERVI", nullable = false)
    private int codSupervi;

    public SupervisionObraPK() {
    }

    public SupervisionObraPK(short codCia, short anio, String tipoObra, int codObra, short subProy, int codSupervi) {
        this.codCia = codCia;
        this.anio = anio;
        this.tipoObra = tipoObra;
        this.codObra = codObra;
        this.subProy = subProy;
        this.codSupervi = codSupervi;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public String getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    public int getCodObra() {
        return codObra;
    }

    public void setCodObra(int codObra) {
        this.codObra = codObra;
    }

    public short getSubProy() {
        return subProy;
    }

    public void setSubProy(short subProy) {
        this.subProy = subProy;
    }

    public int getCodSupervi() {
        return codSupervi;
    }

    public void setCodSupervi(int codSupervi) {
        this.codSupervi = codSupervi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) anio;
        hash += (tipoObra != null ? tipoObra.hashCode() : 0);
        hash += (int) codObra;
        hash += (int) subProy;
        hash += (int) codSupervi;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupervisionObraPK)) {
            return false;
        }
        SupervisionObraPK other = (SupervisionObraPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if ((this.tipoObra == null && other.tipoObra != null) || (this.tipoObra != null && !this.tipoObra.equals(other.tipoObra))) {
            return false;
        }
        if (this.codObra != other.codObra) {
            return false;
        }
        if (this.subProy != other.subProy) {
            return false;
        }
        if (this.codSupervi != other.codSupervi) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.SupervisionObraPK[ codCia=" + codCia + ", anio=" + anio + ", tipoObra=" + tipoObra + ", codObra=" + codObra + ", subProy=" + subProy + ", codSupervi=" + codSupervi + " ]";
    }
    
}
