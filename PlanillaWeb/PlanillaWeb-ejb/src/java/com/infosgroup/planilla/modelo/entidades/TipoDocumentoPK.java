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
public class TipoDocumentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_DOCUMENTO", nullable = false)
    private short codTipoDocumento;

    public TipoDocumentoPK() {
    }

    public TipoDocumentoPK(short codCia, short codTipoDocumento) {
        this.codCia = codCia;
        this.codTipoDocumento = codTipoDocumento;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(short codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoDocumento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentoPK)) {
            return false;
        }
        TipoDocumentoPK other = (TipoDocumentoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoDocumento != other.codTipoDocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoDocumentoPK[ codCia=" + codCia + ", codTipoDocumento=" + codTipoDocumento + " ]";
    }
    
}
