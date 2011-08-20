/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tipo_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t"),
    @NamedQuery(name = "TipoCuenta.findByIdCompania", query = "SELECT t FROM TipoCuenta t WHERE t.tipoCuentaPK.idCompania = :idCompania"),
    @NamedQuery(name = "TipoCuenta.findByIdTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.tipoCuentaPK.idTipoCuenta = :idTipoCuenta"),
    @NamedQuery(name = "TipoCuenta.findByNomTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.nomTipoCuenta = :nomTipoCuenta"),
    @NamedQuery(name = "TipoCuenta.findByDetTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.detTipoCuenta = :detTipoCuenta")})
public class TipoCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoCuentaPK tipoCuentaPK;
    @Size(max = 100)
    @Column(name = "nom_tipo_cuenta", length = 100)
    private String nomTipoCuenta;
    @Size(max = 200)
    @Column(name = "det_tipo_cuenta", length = 200)
    private String detTipoCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCuenta", fetch = FetchType.EAGER)
    private List<Cuenta> cuentaList;
    @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    public TipoCuenta() {
    }

    public TipoCuenta(TipoCuentaPK tipoCuentaPK) {
        this.tipoCuentaPK = tipoCuentaPK;
    }

    public TipoCuenta(int idCompania, int idTipoCuenta) {
        this.tipoCuentaPK = new TipoCuentaPK(idCompania, idTipoCuenta);
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

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
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
