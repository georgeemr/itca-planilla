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
public class DocumentoPresentadoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DOCUMENTO_PRES", nullable = false)
    private int codDocumentoPres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CANDIDATO", nullable = false)
    private int codCandidato;

    public DocumentoPresentadoPK() {
    }

    public DocumentoPresentadoPK(short codCia, int codDocumentoPres, int codCandidato) {
        this.codCia = codCia;
        this.codDocumentoPres = codDocumentoPres;
        this.codCandidato = codCandidato;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodDocumentoPres() {
        return codDocumentoPres;
    }

    public void setCodDocumentoPres(int codDocumentoPres) {
        this.codDocumentoPres = codDocumentoPres;
    }

    public int getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(int codCandidato) {
        this.codCandidato = codCandidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codDocumentoPres;
        hash += (int) codCandidato;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPresentadoPK)) {
            return false;
        }
        DocumentoPresentadoPK other = (DocumentoPresentadoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codDocumentoPres != other.codDocumentoPres) {
            return false;
        }
        if (this.codCandidato != other.codCandidato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DocumentoPresentadoPK[ codCia=" + codCia + ", codDocumentoPres=" + codDocumentoPres + ", codCandidato=" + codCandidato + " ]";
    }
    
}
