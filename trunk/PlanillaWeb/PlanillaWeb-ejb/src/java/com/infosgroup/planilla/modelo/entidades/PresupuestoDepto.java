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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PRESUPUESTO_DEPTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoDepto.findAll", query = "SELECT p FROM PresupuestoDepto p"),
    @NamedQuery(name = "PresupuestoDepto.findByCodCia", query = "SELECT p FROM PresupuestoDepto p WHERE p.presupuestoDeptoPK.codCia = :codCia"),
    @NamedQuery(name = "PresupuestoDepto.findByPeriodo", query = "SELECT p FROM PresupuestoDepto p WHERE p.presupuestoDeptoPK.periodo = :periodo"),
    @NamedQuery(name = "PresupuestoDepto.findByCodDepto", query = "SELECT p FROM PresupuestoDepto p WHERE p.presupuestoDeptoPK.codDepto = :codDepto"),
    @NamedQuery(name = "PresupuestoDepto.findByObservacion", query = "SELECT p FROM PresupuestoDepto p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PresupuestoDepto.findByEstado", query = "SELECT p FROM PresupuestoDepto p WHERE p.estado = :estado")})
public class PresupuestoDepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoDeptoPK presupuestoDeptoPK;
    @Column(name = "OBSERVACION", length = 100)
    private String observacion;
    @Column(name = "ESTADO", length = 3)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestoDepto")
    private List<PresupuestoPuesto> presupuestoPuestoList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PresupuestoPlanilla presupuestoPlanilla;

    public PresupuestoDepto() {
    }

    public PresupuestoDepto(PresupuestoDeptoPK presupuestoDeptoPK) {
        this.presupuestoDeptoPK = presupuestoDeptoPK;
    }

    public PresupuestoDepto(short codCia, short periodo, short codDepto) {
        this.presupuestoDeptoPK = new PresupuestoDeptoPK(codCia, periodo, codDepto);
    }

    public PresupuestoDeptoPK getPresupuestoDeptoPK() {
        return presupuestoDeptoPK;
    }

    public void setPresupuestoDeptoPK(PresupuestoDeptoPK presupuestoDeptoPK) {
        this.presupuestoDeptoPK = presupuestoDeptoPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<PresupuestoPuesto> getPresupuestoPuestoList() {
        return presupuestoPuestoList;
    }

    public void setPresupuestoPuestoList(List<PresupuestoPuesto> presupuestoPuestoList) {
        this.presupuestoPuestoList = presupuestoPuestoList;
    }

    public PresupuestoPlanilla getPresupuestoPlanilla() {
        return presupuestoPlanilla;
    }

    public void setPresupuestoPlanilla(PresupuestoPlanilla presupuestoPlanilla) {
        this.presupuestoPlanilla = presupuestoPlanilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestoDeptoPK != null ? presupuestoDeptoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoDepto)) {
            return false;
        }
        PresupuestoDepto other = (PresupuestoDepto) object;
        if ((this.presupuestoDeptoPK == null && other.presupuestoDeptoPK != null) || (this.presupuestoDeptoPK != null && !this.presupuestoDeptoPK.equals(other.presupuestoDeptoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PresupuestoDepto[ presupuestoDeptoPK=" + presupuestoDeptoPK + " ]";
    }
    
}
