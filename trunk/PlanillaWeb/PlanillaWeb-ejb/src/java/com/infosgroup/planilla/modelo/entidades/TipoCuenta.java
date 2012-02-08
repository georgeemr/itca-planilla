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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t"),
    @NamedQuery(name = "TipoCuenta.findByCodCia", query = "SELECT t FROM TipoCuenta t WHERE t.tipoCuentaPK.codCia = :codCia"),
    @NamedQuery(name = "TipoCuenta.findByCodTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.tipoCuentaPK.codTipoCuenta = :codTipoCuenta"),
    @NamedQuery(name = "TipoCuenta.findByNomTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.nomTipoCuenta = :nomTipoCuenta"),
    @NamedQuery(name = "TipoCuenta.findByDetTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.detTipoCuenta = :detTipoCuenta")})
public class TipoCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoCuentaPK tipoCuentaPK;
    @Column(name = "NOM_TIPO_CUENTA", length = 100)
    private String nomTipoCuenta;
    @Column(name = "DET_TIPO_CUENTA", length = 200)
    private String detTipoCuenta;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;

    public TipoCuenta() {
    }

    public TipoCuenta(TipoCuentaPK tipoCuentaPK) {
        this.tipoCuentaPK = tipoCuentaPK;
    }

    public TipoCuenta(long codCia, long codTipoCuenta) {
        this.tipoCuentaPK = new TipoCuentaPK(codCia, codTipoCuenta);
    }

    public TipoCuentaPK getTipoCuentaPK() {
        return tipoCuentaPK;
    }

    public void setTipoCuentaPK(TipoCuentaPK tipoCuentaPK) {
        this.tipoCuentaPK = tipoCuentaPK;
    }

    public String getNomTipoCuenta() {
        return nomTipoCuenta;
    }

    public void setNomTipoCuenta(String nomTipoCuenta) {
        this.nomTipoCuenta = nomTipoCuenta;
    }

    public String getDetTipoCuenta() {
        return detTipoCuenta;
    }

    public void setDetTipoCuenta(String detTipoCuenta) {
        this.detTipoCuenta = detTipoCuenta;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCuentaPK != null ? tipoCuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.tipoCuentaPK == null && other.tipoCuentaPK != null) || (this.tipoCuentaPK != null && !this.tipoCuentaPK.equals(other.tipoCuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoCuenta[ tipoCuentaPK=" + tipoCuentaPK + " ]";
    }
    
}
