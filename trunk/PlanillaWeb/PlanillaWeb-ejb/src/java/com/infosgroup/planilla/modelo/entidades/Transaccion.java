/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByIdCompania", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.idCompania = :idCompania"),
    @NamedQuery(name = "Transaccion.findByIdTipoTransaccion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.idTipoTransaccion = :idTipoTransaccion"),
    @NamedQuery(name = "Transaccion.findByIdTransaccion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "Transaccion.findByDetalle", query = "SELECT t FROM Transaccion t WHERE t.detalle = :detalle"),
    @NamedQuery(name = "Transaccion.findByValor", query = "SELECT t FROM Transaccion t WHERE t.valor = :valor"),
    @NamedQuery(name = "Transaccion.findByFechatransaccion", query = "SELECT t FROM Transaccion t WHERE t.fechatransaccion = :fechatransaccion")})
public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionPK transaccionPK;
    @Size(max = 500)
    @Column(name = "detalle", length = 500)
    private String detalle;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "fechatransaccion")
    @Temporal(TemporalType.DATE)
    private Date fechatransaccion;
    @ManyToMany(mappedBy = "transaccionList", fetch = FetchType.EAGER)
    private List<Cuenta> cuentaList;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_tipo_transaccion", referencedColumnName = "id_tipo_transaccion", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoTransaccion tipoTransaccion;

    public Transaccion() {
    }

    public Transaccion(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Transaccion(int idCompania, int idTipoTransaccion, int idTransaccion) {
        this.transaccionPK = new TransaccionPK(idCompania, idTipoTransaccion, idTransaccion);
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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getFechatransaccion() {
        return fechatransaccion;
    }

    public void setFechatransaccion(Date fechatransaccion) {
        this.fechatransaccion = fechatransaccion;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
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
