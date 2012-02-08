/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_REQUISITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRequisito.findAll", query = "SELECT t FROM TipoRequisito t"),
    @NamedQuery(name = "TipoRequisito.findByCodCia", query = "SELECT t FROM TipoRequisito t WHERE t.tipoRequisitoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoRequisito.findByCodTipoReq", query = "SELECT t FROM TipoRequisito t WHERE t.tipoRequisitoPK.codTipoReq = :codTipoReq"),
    @NamedQuery(name = "TipoRequisito.findByNomReq", query = "SELECT t FROM TipoRequisito t WHERE t.nomReq = :nomReq")})
public class TipoRequisito implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoRequisitoPK tipoRequisitoPK;
    @Column(name = "NOM_REQ", length = 100)
    private String nomReq;

    public TipoRequisito() {
    }

    public TipoRequisito(TipoRequisitoPK tipoRequisitoPK) {
        this.tipoRequisitoPK = tipoRequisitoPK;
    }

    public TipoRequisito(short codCia, int codTipoReq) {
        this.tipoRequisitoPK = new TipoRequisitoPK(codCia, codTipoReq);
    }

    public TipoRequisitoPK getTipoRequisitoPK() {
        return tipoRequisitoPK;
    }

    public void setTipoRequisitoPK(TipoRequisitoPK tipoRequisitoPK) {
        this.tipoRequisitoPK = tipoRequisitoPK;
    }

    public String getNomReq() {
        return nomReq;
    }

    public void setNomReq(String nomReq) {
        this.nomReq = nomReq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoRequisitoPK != null ? tipoRequisitoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRequisito)) {
            return false;
        }
        TipoRequisito other = (TipoRequisito) object;
        if ((this.tipoRequisitoPK == null && other.tipoRequisitoPK != null) || (this.tipoRequisitoPK != null && !this.tipoRequisitoPK.equals(other.tipoRequisitoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoRequisito[ tipoRequisitoPK=" + tipoRequisitoPK + " ]";
    }
    
}
