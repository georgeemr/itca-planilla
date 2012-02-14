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
public class TipoLicenciaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "COD_TIPO_LIC", nullable = false, length = 2)
    private String codTipoLic;

    public TipoLicenciaPK() {
    }

    public TipoLicenciaPK(short codCia, String codTipoLic) {
        this.codCia = codCia;
        this.codTipoLic = codTipoLic;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public String getCodTipoLic() {
        return codTipoLic;
    }

    public void setCodTipoLic(String codTipoLic) {
        this.codTipoLic = codTipoLic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (codTipoLic != null ? codTipoLic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLicenciaPK)) {
            return false;
        }
        TipoLicenciaPK other = (TipoLicenciaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.codTipoLic == null && other.codTipoLic != null) || (this.codTipoLic != null && !this.codTipoLic.equals(other.codTipoLic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoLicenciaPK[ codCia=" + codCia + ", codTipoLic=" + codTipoLic + " ]";
    }
    
}
