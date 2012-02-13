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
@Table(name = "PRESUPUESTO_PLANILLA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoPlanilla.findAll", query = "SELECT p FROM PresupuestoPlanilla p"),
    @NamedQuery(name = "PresupuestoPlanilla.findByCodCia", query = "SELECT p FROM PresupuestoPlanilla p WHERE p.presupuestoPlanillaPK.codCia = :codCia"),
    @NamedQuery(name = "PresupuestoPlanilla.findByPeriodo", query = "SELECT p FROM PresupuestoPlanilla p WHERE p.presupuestoPlanillaPK.periodo = :periodo"),
    @NamedQuery(name = "PresupuestoPlanilla.findByObservacion", query = "SELECT p FROM PresupuestoPlanilla p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PresupuestoPlanilla.findByEstado", query = "SELECT p FROM PresupuestoPlanilla p WHERE p.estado = :estado")})
public class PresupuestoPlanilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoPlanillaPK presupuestoPlanillaPK;
    @Column(name = "OBSERVACION", length = 100)
    private String observacion;
    @Column(name = "ESTADO", length = 3)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestoPlanilla")
    private List<PresupuestoDepto> presupuestoDeptoList;

    public PresupuestoPlanilla() {
    }

    public PresupuestoPlanilla(PresupuestoPlanillaPK presupuestoPlanillaPK) {
        this.presupuestoPlanillaPK = presupuestoPlanillaPK;
    }

    public PresupuestoPlanilla(short codCia, short periodo) {
        this.presupuestoPlanillaPK = new PresupuestoPlanillaPK(codCia, periodo);
    }

    public PresupuestoPlanillaPK getPresupuestoPlanillaPK() {
        return presupuestoPlanillaPK;
    }

    public void setPresupuestoPlanillaPK(PresupuestoPlanillaPK presupuestoPlanillaPK) {
        this.presupuestoPlanillaPK = presupuestoPlanillaPK;
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
    public List<PresupuestoDepto> getPresupuestoDeptoList() {
        return presupuestoDeptoList;
    }

    public void setPresupuestoDeptoList(List<PresupuestoDepto> presupuestoDeptoList) {
        this.presupuestoDeptoList = presupuestoDeptoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestoPlanillaPK != null ? presupuestoPlanillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoPlanilla)) {
            return false;
        }
        PresupuestoPlanilla other = (PresupuestoPlanilla) object;
        if ((this.presupuestoPlanillaPK == null && other.presupuestoPlanillaPK != null) || (this.presupuestoPlanillaPK != null && !this.presupuestoPlanillaPK.equals(other.presupuestoPlanillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PresupuestoPlanilla[ presupuestoPlanillaPK=" + presupuestoPlanillaPK + " ]";
    }
    
}
