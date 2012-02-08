/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "AFP_COTIZADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AfpCotizadas.findAll", query = "SELECT a FROM AfpCotizadas a"),
    @NamedQuery(name = "AfpCotizadas.findByCodCia", query = "SELECT a FROM AfpCotizadas a WHERE a.afpCotizadasPK.codCia = :codCia"),
    @NamedQuery(name = "AfpCotizadas.findByCodDp", query = "SELECT a FROM AfpCotizadas a WHERE a.afpCotizadasPK.codDp = :codDp")})
public class AfpCotizadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AfpCotizadasPK afpCotizadasPK;

    public AfpCotizadas() {
    }

    public AfpCotizadas(AfpCotizadasPK afpCotizadasPK) {
        this.afpCotizadasPK = afpCotizadasPK;
    }

    public AfpCotizadas(short codCia, short codDp) {
        this.afpCotizadasPK = new AfpCotizadasPK(codCia, codDp);
    }

    public AfpCotizadasPK getAfpCotizadasPK() {
        return afpCotizadasPK;
    }

    public void setAfpCotizadasPK(AfpCotizadasPK afpCotizadasPK) {
        this.afpCotizadasPK = afpCotizadasPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afpCotizadasPK != null ? afpCotizadasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AfpCotizadas)) {
            return false;
        }
        AfpCotizadas other = (AfpCotizadas) object;
        if ((this.afpCotizadasPK == null && other.afpCotizadasPK != null) || (this.afpCotizadasPK != null && !this.afpCotizadasPK.equals(other.afpCotizadasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.AfpCotizadas[ afpCotizadasPK=" + afpCotizadasPK + " ]";
    }
    
}
