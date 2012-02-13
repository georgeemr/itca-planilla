/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_DOCUMENTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByCodCia", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoDocumento.findByCodTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoPK.codTipoDocumento = :codTipoDocumento"),
    @NamedQuery(name = "TipoDocumento.findByNomTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.nomTipoDocumento = :nomTipoDocumento")})
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoDocumentoPK tipoDocumentoPK;
    @Basic(optional = false)
    @Column(name = "NOM_TIPO_DOCUMENTO", nullable = false, length = 200)
    private String nomTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private List<DocumentoPresentado> documentoPresentadoList;

    public TipoDocumento() {
    }

    public TipoDocumento(TipoDocumentoPK tipoDocumentoPK) {
        this.tipoDocumentoPK = tipoDocumentoPK;
    }

    public TipoDocumento(TipoDocumentoPK tipoDocumentoPK, String nomTipoDocumento) {
        this.tipoDocumentoPK = tipoDocumentoPK;
        this.nomTipoDocumento = nomTipoDocumento;
    }

    public TipoDocumento(short codCia, short codTipoDocumento) {
        this.tipoDocumentoPK = new TipoDocumentoPK(codCia, codTipoDocumento);
    }

    public TipoDocumentoPK getTipoDocumentoPK() {
        return tipoDocumentoPK;
    }

    public void setTipoDocumentoPK(TipoDocumentoPK tipoDocumentoPK) {
        this.tipoDocumentoPK = tipoDocumentoPK;
    }

    public String getNomTipoDocumento() {
        return nomTipoDocumento;
    }

    public void setNomTipoDocumento(String nomTipoDocumento) {
        this.nomTipoDocumento = nomTipoDocumento;
    }

    @XmlTransient
    public List<DocumentoPresentado> getDocumentoPresentadoList() {
        return documentoPresentadoList;
    }

    public void setDocumentoPresentadoList(List<DocumentoPresentado> documentoPresentadoList) {
        this.documentoPresentadoList = documentoPresentadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumentoPK != null ? tipoDocumentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tipoDocumentoPK == null && other.tipoDocumentoPK != null) || (this.tipoDocumentoPK != null && !this.tipoDocumentoPK.equals(other.tipoDocumentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoDocumento[ tipoDocumentoPK=" + tipoDocumentoPK + " ]";
    }
    
}
