/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TRANSACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByCodCia", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.codCia = :codCia"),
    @NamedQuery(name = "Transaccion.findByCodTipoTransaccion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.codTipoTransaccion = :codTipoTransaccion"),
    @NamedQuery(name = "Transaccion.findByCodTransaccion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.codTransaccion = :codTransaccion"),
    @NamedQuery(name = "Transaccion.findByDetalle", query = "SELECT t FROM Transaccion t WHERE t.detalle = :detalle"),
    @NamedQuery(name = "Transaccion.findByValor", query = "SELECT t FROM Transaccion t WHERE t.valor = :valor"),
    @NamedQuery(name = "Transaccion.findByFechatransaccion", query = "SELECT t FROM Transaccion t WHERE t.fechatransaccion = :fechatransaccion")})
public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionPK transaccionPK;
    @Column(name = "DETALLE", length = 500)
    private String detalle;
    @Column(name = "VALOR")
    private Long valor;
    @Column(name = "FECHATRANSACCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechatransaccion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_TRANSACCION", referencedColumnName = "COD_TIPO_TRANSACCION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoTransaccion tipoTransaccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaccion")
    private List<TransaccionCuenta> transaccionCuentaList;

    public Transaccion() {
    }

    public Transaccion(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Transaccion(long codCia, long codTipoTransaccion, long codTransaccion) {
        this.transaccionPK = new TransaccionPK(codCia, codTipoTransaccion, codTransaccion);
    }

    public TransaccionPK getTransaccionPK() {
        return transaccionPK;
    }

    public void setTransaccionPK(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Date getFechatransaccion() {
        return fechatransaccion;
    }

    public void setFechatransaccion(Date fechatransaccion) {
        this.fechatransaccion = fechatransaccion;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @XmlTransient
    public List<TransaccionCuenta> getTransaccionCuentaList() {
        return transaccionCuentaList;
    }

    public void setTransaccionCuentaList(List<TransaccionCuenta> transaccionCuentaList) {
        this.transaccionCuentaList = transaccionCuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionPK != null ? transaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.transaccionPK == null && other.transaccionPK != null) || (this.transaccionPK != null && !this.transaccionPK.equals(other.transaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Transaccion[ transaccionPK=" + transaccionPK + " ]";
    }
    
}
