/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_CONTRATO", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBRE"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContrato.findAll", query = "SELECT t FROM TipoContrato t"),
    @NamedQuery(name = "TipoContrato.findByCodCia", query = "SELECT t FROM TipoContrato t WHERE t.tipoContratoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoContrato.findByCodigo", query = "SELECT t FROM TipoContrato t WHERE t.tipoContratoPK.codigo = :codigo"),
    @NamedQuery(name = "TipoContrato.findByNombre", query = "SELECT t FROM TipoContrato t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoContrato.findByDescripcion", query = "SELECT t FROM TipoContrato t WHERE t.descripcion = :descripcion")})
public class TipoContrato implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContrato")
    private List<Contrato> contratoList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoContratoPK tipoContratoPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;

    public TipoContrato() {
    }

    public TipoContrato(TipoContratoPK tipoContratoPK) {
        this.tipoContratoPK = tipoContratoPK;
    }

    public TipoContrato(TipoContratoPK tipoContratoPK, String nombre) {
        this.tipoContratoPK = tipoContratoPK;
        this.nombre = nombre;
    }

    public TipoContrato(long codCia, long codigo) {
        this.tipoContratoPK = new TipoContratoPK(codCia, codigo);
    }

    public TipoContratoPK getTipoContratoPK() {
        return tipoContratoPK;
    }

    public void setTipoContratoPK(TipoContratoPK tipoContratoPK) {
        this.tipoContratoPK = tipoContratoPK;
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
        hash += (tipoContratoPK != null ? tipoContratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContrato)) {
            return false;
        }
        TipoContrato other = (TipoContrato) object;
        if ((this.tipoContratoPK == null && other.tipoContratoPK != null) || (this.tipoContratoPK != null && !this.tipoContratoPK.equals(other.tipoContratoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoContrato[ tipoContratoPK=" + tipoContratoPK + " ]";
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }
    
}
