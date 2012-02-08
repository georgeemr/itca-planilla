/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "RELACION_LABORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacionLaboral.findAll", query = "SELECT r FROM RelacionLaboral r"),
    @NamedQuery(name = "RelacionLaboral.findByCodCia", query = "SELECT r FROM RelacionLaboral r WHERE r.relacionLaboralPK.codCia = :codCia"),
    @NamedQuery(name = "RelacionLaboral.findByCodEmp", query = "SELECT r FROM RelacionLaboral r WHERE r.relacionLaboralPK.codEmp = :codEmp"),
    @NamedQuery(name = "RelacionLaboral.findByCorrelativo", query = "SELECT r FROM RelacionLaboral r WHERE r.relacionLaboralPK.correlativo = :correlativo"),
    @NamedQuery(name = "RelacionLaboral.findByFechaIni", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaIni = :fechaIni"),
    @NamedQuery(name = "RelacionLaboral.findByFechaFin", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "RelacionLaboral.findBySalario", query = "SELECT r FROM RelacionLaboral r WHERE r.salario = :salario"),
    @NamedQuery(name = "RelacionLaboral.findByFechaAgui", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaAgui = :fechaAgui"),
    @NamedQuery(name = "RelacionLaboral.findByFechaVac", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaVac = :fechaVac")})
public class RelacionLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelacionLaboralPK relacionLaboralPK;
    @Column(name = "FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO", precision = 16, scale = 2)
    private BigDecimal salario;
    @Column(name = "FECHA_AGUI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAgui;
    @Column(name = "FECHA_VAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVac;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public RelacionLaboral() {
    }

    public RelacionLaboral(RelacionLaboralPK relacionLaboralPK) {
        this.relacionLaboralPK = relacionLaboralPK;
    }

    public RelacionLaboral(short codCia, int codEmp, int correlativo) {
        this.relacionLaboralPK = new RelacionLaboralPK(codCia, codEmp, correlativo);
    }

    public RelacionLaboralPK getRelacionLaboralPK() {
        return relacionLaboralPK;
    }

    public void setRelacionLaboralPK(RelacionLaboralPK relacionLaboralPK) {
        this.relacionLaboralPK = relacionLaboralPK;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Date getFechaAgui() {
        return fechaAgui;
    }

    public void setFechaAgui(Date fechaAgui) {
        this.fechaAgui = fechaAgui;
    }

    public Date getFechaVac() {
        return fechaVac;
    }

    public void setFechaVac(Date fechaVac) {
        this.fechaVac = fechaVac;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relacionLaboralPK != null ? relacionLaboralPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionLaboral)) {
            return false;
        }
        RelacionLaboral other = (RelacionLaboral) object;
        if ((this.relacionLaboralPK == null && other.relacionLaboralPK != null) || (this.relacionLaboralPK != null && !this.relacionLaboralPK.equals(other.relacionLaboralPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RelacionLaboral[ relacionLaboralPK=" + relacionLaboralPK + " ]";
    }
    
}
