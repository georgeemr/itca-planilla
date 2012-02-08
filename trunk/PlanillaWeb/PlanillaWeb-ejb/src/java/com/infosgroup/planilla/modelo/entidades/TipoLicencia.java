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
@Table(name = "TIPO_LICENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLicencia.findAll", query = "SELECT t FROM TipoLicencia t"),
    @NamedQuery(name = "TipoLicencia.findByCodCia", query = "SELECT t FROM TipoLicencia t WHERE t.tipoLicenciaPK.codCia = :codCia"),
    @NamedQuery(name = "TipoLicencia.findByCodTipoLic", query = "SELECT t FROM TipoLicencia t WHERE t.tipoLicenciaPK.codTipoLic = :codTipoLic"),
    @NamedQuery(name = "TipoLicencia.findByDescTipo", query = "SELECT t FROM TipoLicencia t WHERE t.descTipo = :descTipo")})
public class TipoLicencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoLicenciaPK tipoLicenciaPK;
    @Column(name = "DESC_TIPO", length = 60)
    private String descTipo;

    public TipoLicencia() {
    }

    public TipoLicencia(TipoLicenciaPK tipoLicenciaPK) {
        this.tipoLicenciaPK = tipoLicenciaPK;
    }

    public TipoLicencia(short codCia, String codTipoLic) {
        this.tipoLicenciaPK = new TipoLicenciaPK(codCia, codTipoLic);
    }

    public TipoLicenciaPK getTipoLicenciaPK() {
        return tipoLicenciaPK;
    }

    public void setTipoLicenciaPK(TipoLicenciaPK tipoLicenciaPK) {
        this.tipoLicenciaPK = tipoLicenciaPK;
    }

    public String getDescTipo() {
        return descTipo;
    }

    public void setDescTipo(String descTipo) {
        this.descTipo = descTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoLicenciaPK != null ? tipoLicenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLicencia)) {
            return false;
        }
        TipoLicencia other = (TipoLicencia) object;
        if ((this.tipoLicenciaPK == null && other.tipoLicenciaPK != null) || (this.tipoLicenciaPK != null && !this.tipoLicenciaPK.equals(other.tipoLicenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoLicencia[ tipoLicenciaPK=" + tipoLicenciaPK + " ]";
    }
    
}
