/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DOCUMENTO_PRESENTADO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoPresentado.findAll", query = "SELECT d FROM DocumentoPresentado d"),
    @NamedQuery(name = "DocumentoPresentado.findByCodCia", query = "SELECT d FROM DocumentoPresentado d WHERE d.documentoPresentadoPK.codCia = :codCia"),
    @NamedQuery(name = "DocumentoPresentado.findByCodDocumentoPres", query = "SELECT d FROM DocumentoPresentado d WHERE d.documentoPresentadoPK.codDocumentoPres = :codDocumentoPres"),
    @NamedQuery(name = "DocumentoPresentado.findByCodCandidato", query = "SELECT d FROM DocumentoPresentado d WHERE d.documentoPresentadoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "DocumentoPresentado.findByObservacion", query = "SELECT d FROM DocumentoPresentado d WHERE d.observacion = :observacion")})
public class DocumentoPresentado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoPresentadoPK documentoPresentadoPK;
    @Size(max = 500)
    @Column(name = "OBSERVACION", length = 500)
    private String observacion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_DOCUMENTO", referencedColumnName = "COD_TIPO_DOCUMENTO")})
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public DocumentoPresentado() {
    }

    public DocumentoPresentado(DocumentoPresentadoPK documentoPresentadoPK) {
        this.documentoPresentadoPK = documentoPresentadoPK;
    }

    public DocumentoPresentado(short codCia, int codDocumentoPres, int codCandidato) {
        this.documentoPresentadoPK = new DocumentoPresentadoPK(codCia, codDocumentoPres, codCandidato);
    }

    public DocumentoPresentadoPK getDocumentoPresentadoPK() {
        return documentoPresentadoPK;
    }

    public void setDocumentoPresentadoPK(DocumentoPresentadoPK documentoPresentadoPK) {
        this.documentoPresentadoPK = documentoPresentadoPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPresentadoPK != null ? documentoPresentadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPresentado)) {
            return false;
        }
        DocumentoPresentado other = (DocumentoPresentado) object;
        if ((this.documentoPresentadoPK == null && other.documentoPresentadoPK != null) || (this.documentoPresentadoPK != null && !this.documentoPresentadoPK.equals(other.documentoPresentadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DocumentoPresentado[ documentoPresentadoPK=" + documentoPresentadoPK + " ]";
    }
    
}
