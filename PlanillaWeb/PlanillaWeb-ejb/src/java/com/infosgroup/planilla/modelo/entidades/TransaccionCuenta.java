/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "TRANSACCION_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionCuenta.findAll", query = "SELECT t FROM TransaccionCuenta t"),
    @NamedQuery(name = "TransaccionCuenta.findByCodCia", query = "SELECT t FROM TransaccionCuenta t WHERE t.transaccionCuentaPK.codCia = :codCia"),
    @NamedQuery(name = "TransaccionCuenta.findByCodTipoTransaccion", query = "SELECT t FROM TransaccionCuenta t WHERE t.transaccionCuentaPK.codTipoTransaccion = :codTipoTransaccion"),
    @NamedQuery(name = "TransaccionCuenta.findByCodTransaccion", query = "SELECT t FROM TransaccionCuenta t WHERE t.transaccionCuentaPK.codTransaccion = :codTransaccion"),
    @NamedQuery(name = "TransaccionCuenta.findByCodTipoCuenta", query = "SELECT t FROM TransaccionCuenta t WHERE t.transaccionCuentaPK.codTipoCuenta = :codTipoCuenta"),
    @NamedQuery(name = "TransaccionCuenta.findByCodCuenta", query = "SELECT t FROM TransaccionCuenta t WHERE t.transaccionCuentaPK.codCuenta = :codCuenta")})
public class TransaccionCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionCuentaPK transaccionCuentaPK;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_TRANSACCION", referencedColumnName = "COD_TIPO_TRANSACCION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TRANSACCION", referencedColumnName = "COD_TRANSACCION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Transaccion transaccion;

    public TransaccionCuenta() {
    }

    public TransaccionCuenta(TransaccionCuentaPK transaccionCuentaPK) {
        this.transaccionCuentaPK = transaccionCuentaPK;
    }

    public TransaccionCuenta(long codCia, long codTipoTransaccion, long codTransaccion, long codTipoCuenta, long codCuenta) {
        this.transaccionCuentaPK = new TransaccionCuentaPK(codCia, codTipoTransaccion, codTransaccion, codTipoCuenta, codCuenta);
    }

    public TransaccionCuentaPK getTransaccionCuentaPK() {
        return transaccionCuentaPK;
    }

    public void setTransaccionCuentaPK(TransaccionCuentaPK transaccionCuentaPK) {
        this.transaccionCuentaPK = transaccionCuentaPK;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionCuentaPK != null ? transaccionCuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionCuenta)) {
            return false;
        }
        TransaccionCuenta other = (TransaccionCuenta) object;
        if ((this.transaccionCuentaPK == null && other.transaccionCuentaPK != null) || (this.transaccionCuentaPK != null && !this.transaccionCuentaPK.equals(other.transaccionCuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TransaccionCuenta[ transaccionCuentaPK=" + transaccionCuentaPK + " ]";
    }
    
}
