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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tipo_transaccion", catalog = "planilla", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TipoTransaccion.findAll", query = "SELECT t FROM TipoTransaccion t"),
    @NamedQuery(name = "TipoTransaccion.findByIdCompania", query = "SELECT t FROM TipoTransaccion t WHERE t.tipoTransaccionPK.idCompania = :idCompania"),
    @NamedQuery(name = "TipoTransaccion.findByIdTipoTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.tipoTransaccionPK.idTipoTransaccion = :idTipoTransaccion"),
    @NamedQuery(name = "TipoTransaccion.findByNomTipoTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.nomTipoTransaccion = :nomTipoTransaccion"),
    @NamedQuery(name = "TipoTransaccion.findByDetTipoTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.detTipoTransaccion = :detTipoTransaccion")})
public class TipoTransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoTransaccionPK tipoTransaccionPK;
    @Size(max = 100)
    @Column(name = "nom_tipo_transaccion", length = 100)
    private String nomTipoTransaccion;
    @Size(max = 200)
    @Column(name = "det_tipo_transaccion", length = 200)
    private String detTipoTransaccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTransaccion")
    private List<Transaccion> transaccionList;
    @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public TipoTransaccion() {
    }

    public TipoTransaccion(TipoTransaccionPK tipoTransaccionPK) {
        this.tipoTransaccionPK = tipoTransaccionPK;
    }

    public TipoTransaccion(int idCompania, int idTipoTransaccion) {
        this.tipoTransaccionPK = new TipoTransaccionPK(idCompania, idTipoTransaccion);
    }

    public TipoTransaccionPK getTipoTransaccionPK() {
        return tipoTransaccionPK;
    }

    public void setTipoTransaccionPK(TipoTransaccionPK tipoTransaccionPK) {
        this.tipoTransaccionPK = tipoTransaccionPK;
    }

    public String getNomTipoTransaccion() {
        return nomTipoTransaccion;
    }

    public void setNomTipoTransaccion(String nomTipoTransaccion) {
        this.nomTipoTransaccion = nomTipoTransaccion;
    }

    public String getDetTipoTransaccion() {
        return detTipoTransaccion;
    }

    public void setDetTipoTransaccion(String detTipoTransaccion) {
        this.detTipoTransaccion = detTipoTransaccion;
    }

    public List<Transaccion> getTransaccionList() {
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
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
        hash += (tipoTransaccionPK != null ? tipoTransaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccion)) {
            return false;
        }
        TipoTransaccion other = (TipoTransaccion) object;
        if ((this.tipoTransaccionPK == null && other.tipoTransaccionPK != null) || (this.tipoTransaccionPK != null && !this.tipoTransaccionPK.equals(other.tipoTransaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoTransaccion[ tipoTransaccionPK=" + tipoTransaccionPK + " ]";
    }
    
}
