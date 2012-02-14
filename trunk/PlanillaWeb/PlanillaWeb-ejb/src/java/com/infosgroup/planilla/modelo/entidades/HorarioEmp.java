/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "HORARIO_EMP", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioEmp.findAll", query = "SELECT h FROM HorarioEmp h"),
    @NamedQuery(name = "HorarioEmp.findByCodEmp", query = "SELECT h FROM HorarioEmp h WHERE h.horarioEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "HorarioEmp.findByFecha", query = "SELECT h FROM HorarioEmp h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HorarioEmp.findByInicio", query = "SELECT h FROM HorarioEmp h WHERE h.inicio = :inicio"),
    @NamedQuery(name = "HorarioEmp.findByFin", query = "SELECT h FROM HorarioEmp h WHERE h.fin = :fin"),
    @NamedQuery(name = "HorarioEmp.findByHoras", query = "SELECT h FROM HorarioEmp h WHERE h.horas = :horas"),
    @NamedQuery(name = "HorarioEmp.findByStatus", query = "SELECT h FROM HorarioEmp h WHERE h.status = :status"),
    @NamedQuery(name = "HorarioEmp.findByCodCia", query = "SELECT h FROM HorarioEmp h WHERE h.horarioEmpPK.codCia = :codCia"),
    @NamedQuery(name = "HorarioEmp.findByCorrelat", query = "SELECT h FROM HorarioEmp h WHERE h.horarioEmpPK.correlat = :correlat")})
public class HorarioEmp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorarioEmpPK horarioEmpPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HORAS", precision = 4, scale = 2)
    private BigDecimal horas;
    @Size(max = 1)
    @Column(name = "STATUS", length = 1)
    private String status;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_HORARIO", referencedColumnName = "TIPO_HORARIO")})
    @ManyToOne(optional = false)
    private TipoHorario tipoHorario;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public HorarioEmp() {
    }

    public HorarioEmp(HorarioEmpPK horarioEmpPK) {
        this.horarioEmpPK = horarioEmpPK;
    }

    public HorarioEmp(HorarioEmpPK horarioEmpPK, Date fecha) {
        this.horarioEmpPK = horarioEmpPK;
        this.fecha = fecha;
    }

    public HorarioEmp(int codEmp, short codCia, int correlat) {
        this.horarioEmpPK = new HorarioEmpPK(codEmp, codCia, correlat);
    }

    public HorarioEmpPK getHorarioEmpPK() {
        return horarioEmpPK;
    }

    public void setHorarioEmpPK(HorarioEmpPK horarioEmpPK) {
        this.horarioEmpPK = horarioEmpPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipoHorario getTipoHorario() {
        return tipoHorario;
    }

    public void setTipoHorario(TipoHorario tipoHorario) {
        this.tipoHorario = tipoHorario;
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
        hash += (horarioEmpPK != null ? horarioEmpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioEmp)) {
            return false;
        }
        HorarioEmp other = (HorarioEmp) object;
        if ((this.horarioEmpPK == null && other.horarioEmpPK != null) || (this.horarioEmpPK != null && !this.horarioEmpPK.equals(other.horarioEmpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HorarioEmp[ horarioEmpPK=" + horarioEmpPK + " ]";
    }
    
}
