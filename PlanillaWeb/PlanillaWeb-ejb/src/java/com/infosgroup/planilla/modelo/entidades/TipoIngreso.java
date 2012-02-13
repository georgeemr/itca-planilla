/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TIPO_INGRESO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIngreso.findAll", query = "SELECT t FROM TipoIngreso t"),
    @NamedQuery(name = "TipoIngreso.findByCodCia", query = "SELECT t FROM TipoIngreso t WHERE t.tipoIngresoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoIngreso.findByTipoIngreso", query = "SELECT t FROM TipoIngreso t WHERE t.tipoIngresoPK.tipoIngreso = :tipoIngreso"),
    @NamedQuery(name = "TipoIngreso.findByNomIngreso", query = "SELECT t FROM TipoIngreso t WHERE t.nomIngreso = :nomIngreso"),
    @NamedQuery(name = "TipoIngreso.findByVpr", query = "SELECT t FROM TipoIngreso t WHERE t.vpr = :vpr"),
    @NamedQuery(name = "TipoIngreso.findByFactor", query = "SELECT t FROM TipoIngreso t WHERE t.factor = :factor")})
public class TipoIngreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoIngresoPK tipoIngresoPK;
    @Column(name = "NOM_INGRESO", length = 200)
    private String nomIngreso;
    @Column(name = "VPR", length = 1)
    private String vpr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FACTOR", precision = 8, scale = 4)
    private BigDecimal factor;

    public TipoIngreso() {
    }

    public TipoIngreso(TipoIngresoPK tipoIngresoPK) {
        this.tipoIngresoPK = tipoIngresoPK;
    }

    public TipoIngreso(short codCia, short tipoIngreso) {
        this.tipoIngresoPK = new TipoIngresoPK(codCia, tipoIngreso);
    }

    public TipoIngresoPK getTipoIngresoPK() {
        return tipoIngresoPK;
    }

    public void setTipoIngresoPK(TipoIngresoPK tipoIngresoPK) {
        this.tipoIngresoPK = tipoIngresoPK;
    }

    public String getNomIngreso() {
        return nomIngreso;
    }

    public void setNomIngreso(String nomIngreso) {
        this.nomIngreso = nomIngreso;
    }

    public String getVpr() {
        return vpr;
    }

    public void setVpr(String vpr) {
        this.vpr = vpr;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoIngresoPK != null ? tipoIngresoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIngreso)) {
            return false;
        }
        TipoIngreso other = (TipoIngreso) object;
        if ((this.tipoIngresoPK == null && other.tipoIngresoPK != null) || (this.tipoIngresoPK != null && !this.tipoIngresoPK.equals(other.tipoIngresoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoIngreso[ tipoIngresoPK=" + tipoIngresoPK + " ]";
    }
    
}
