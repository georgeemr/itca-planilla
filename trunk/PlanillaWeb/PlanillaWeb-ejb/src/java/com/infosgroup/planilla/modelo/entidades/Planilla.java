/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@Table(name = "planilla", catalog = "planilla", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p"),
    @NamedQuery(name = "Planilla.findByIdCompania", query = "SELECT p FROM Planilla p WHERE p.planillaPK.idCompania = :idCompania"),
    @NamedQuery(name = "Planilla.findByIdTipoPlanilla", query = "SELECT p FROM Planilla p WHERE p.planillaPK.idTipoPlanilla = :idTipoPlanilla"),
    @NamedQuery(name = "Planilla.findByIdSucursal", query = "SELECT p FROM Planilla p WHERE p.planillaPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "Planilla.findByIdEmpleado", query = "SELECT p FROM Planilla p WHERE p.planillaPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Planilla.findByFecha", query = "SELECT p FROM Planilla p WHERE p.fecha = :fecha")})
public class Planilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanillaPK planillaPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_tipo_planilla", referencedColumnName = "id_tipo_planilla", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoPlanilla tipoPlanilla;

    public Planilla() {
    }

    public Planilla(PlanillaPK planillaPK) {
        this.planillaPK = planillaPK;
    }

    public Planilla(int idCompania, int idTipoPlanilla, int idSucursal, int idEmpleado) {
        this.planillaPK = new PlanillaPK(idCompania, idTipoPlanilla, idSucursal, idEmpleado);
    }

    public PlanillaPK getPlanillaPK() {
        return planillaPK;
    }

    public void setPlanillaPK(PlanillaPK planillaPK) {
        this.planillaPK = planillaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoPlanilla getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(TipoPlanilla tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planillaPK != null ? planillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.planillaPK == null && other.planillaPK != null) || (this.planillaPK != null && !this.planillaPK.equals(other.planillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Planilla[ planillaPK=" + planillaPK + " ]";
    }
    
}
