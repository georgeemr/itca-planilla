/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_CRITERIO", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBRE"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCriterio.findAll", query = "SELECT t FROM TipoCriterio t"),
    @NamedQuery(name = "TipoCriterio.findByCodCia", query = "SELECT t FROM TipoCriterio t WHERE t.tipoCriterioPK.codCia = :codCia"),
    @NamedQuery(name = "TipoCriterio.findByCodigo", query = "SELECT t FROM TipoCriterio t WHERE t.tipoCriterioPK.codigo = :codigo"),
    @NamedQuery(name = "TipoCriterio.findByNombre", query = "SELECT t FROM TipoCriterio t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoCriterio.findByDescripcion", query = "SELECT t FROM TipoCriterio t WHERE t.descripcion = :descripcion")})
public class TipoCriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoCriterioPK tipoCriterioPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;

    public TipoCriterio() {
    }

    public TipoCriterio(TipoCriterioPK tipoCriterioPK) {
        this.tipoCriterioPK = tipoCriterioPK;
    }

    public TipoCriterio(TipoCriterioPK tipoCriterioPK, String nombre) {
        this.tipoCriterioPK = tipoCriterioPK;
        this.nombre = nombre;
    }

    public TipoCriterio(long codCia, long codigo) {
        this.tipoCriterioPK = new TipoCriterioPK(codCia, codigo);
    }

    public TipoCriterioPK getTipoCriterioPK() {
        return tipoCriterioPK;
    }

    public void setTipoCriterioPK(TipoCriterioPK tipoCriterioPK) {
        this.tipoCriterioPK = tipoCriterioPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (tipoCriterioPK != null ? tipoCriterioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCriterio)) {
            return false;
        }
        TipoCriterio other = (TipoCriterio) object;
        if ((this.tipoCriterioPK == null && other.tipoCriterioPK != null) || (this.tipoCriterioPK != null && !this.tipoCriterioPK.equals(other.tipoCriterioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoCriterio[ tipoCriterioPK=" + tipoCriterioPK + " ]";
    }
    
}
