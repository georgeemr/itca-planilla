/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "RESUMEN_ASISTENCIA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "ResumenAsistencia.findAll", query = "SELECT r FROM ResumenAsistencia r"),
    @NamedQuery(name = "ResumenAsistencia.findByIdCompania", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.idCompania = :idCompania"),
    @NamedQuery(name = "ResumenAsistencia.findByAnio", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.anio = :anio"),
    @NamedQuery(name = "ResumenAsistencia.findByMes", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.mes = :mes"),
    @NamedQuery(name = "ResumenAsistencia.findByNumPlanilla", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "ResumenAsistencia.findByCodEmp", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.codEmp = :codEmp"),
    @NamedQuery(name = "ResumenAsistencia.findByIdSucursal", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "ResumenAsistencia.findByIdTipoPuesto", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.idTipoPuesto = :idTipoPuesto"),
    @NamedQuery(name = "ResumenAsistencia.findByIdPuesto", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.idPuesto = :idPuesto"),
    @NamedQuery(name = "ResumenAsistencia.findByDLaborados", query = "SELECT r FROM ResumenAsistencia r WHERE r.dLaborados = :dLaborados"),
    @NamedQuery(name = "ResumenAsistencia.findByDnLaborados", query = "SELECT r FROM ResumenAsistencia r WHERE r.dnLaborados = :dnLaborados"),
    @NamedQuery(name = "ResumenAsistencia.findByHXsencillas", query = "SELECT r FROM ResumenAsistencia r WHERE r.hXsencillas = :hXsencillas"),
    @NamedQuery(name = "ResumenAsistencia.findByHXdobles", query = "SELECT r FROM ResumenAsistencia r WHERE r.hXdobles = :hXdobles"),
    @NamedQuery(name = "ResumenAsistencia.findByViaticos", query = "SELECT r FROM ResumenAsistencia r WHERE r.viaticos = :viaticos"),
    @NamedQuery(name = "ResumenAsistencia.findByEstadoPla", query = "SELECT r FROM ResumenAsistencia r WHERE r.estadoPla = :estadoPla"),
    @NamedQuery(name = "ResumenAsistencia.findByEstadoEmp", query = "SELECT r FROM ResumenAsistencia r WHERE r.estadoEmp = :estadoEmp"),
    @NamedQuery(name = "ResumenAsistencia.findByHXf150", query = "SELECT r FROM ResumenAsistencia r WHERE r.hXf150 = :hXf150"),
    @NamedQuery(name = "ResumenAsistencia.findByHXf250", query = "SELECT r FROM ResumenAsistencia r WHERE r.hXf250 = :hXf250"),
    @NamedQuery(name = "ResumenAsistencia.findByDAguinaldo", query = "SELECT r FROM ResumenAsistencia r WHERE r.dAguinaldo = :dAguinaldo"),
    @NamedQuery(name = "ResumenAsistencia.findByHAusencia", query = "SELECT r FROM ResumenAsistencia r WHERE r.hAusencia = :hAusencia"),
    @NamedQuery(name = "ResumenAsistencia.findByDNocturnidad", query = "SELECT r FROM ResumenAsistencia r WHERE r.dNocturnidad = :dNocturnidad"),
    @NamedQuery(name = "ResumenAsistencia.findByVacaciones", query = "SELECT r FROM ResumenAsistencia r WHERE r.vacaciones = :vacaciones"),
    @NamedQuery(name = "ResumenAsistencia.findByAguinaldo", query = "SELECT r FROM ResumenAsistencia r WHERE r.aguinaldo = :aguinaldo")
    })
public class ResumenAsistencia implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ResumenAsistenciaPK resumenAsistenciaPK;

    @Column(name = "D_LABORADOS")
    private Long dLaborados;

    @Column(name = "DN_LABORADOS")
    private Long dnLaborados;

    @Column(name = "H_XSENCILLAS")
    private Long hXsencillas;

    @Column(name = "H_XDOBLES")
    private Long hXdobles;

    @Column(name = "VIATICOS")
    private Long viaticos;

    @Size(max = 100)
    @Column(name = "ESTADO_PLA", length = 100)
    private String estadoPla;

    @Size(max = 100)
    @Column(name = "ESTADO_EMP", length = 100)
    private String estadoEmp;

    @Column(name = "H_XF150")
    private Long hXf150;

    @Column(name = "H_XF250")
    private Long hXf250;

    @Column(name = "D_AGUINALDO")
    private Long dAguinaldo;

    @Column(name = "H_AUSENCIA")
    private Long hAusencia;

    @Column(name = "D_NOCTURNIDAD")
    private Long dNocturnidad;

    @Column(name = "VACACIONES")
    private Long vacaciones;

    @Size(max = 100)
    @Column(name = "AGUINALDO", length = 100)
    private String aguinaldo;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sucursal sucursal;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "ID_EMPLEADO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_TIPO_PUESTO", referencedColumnName = "ID_TIPO_PUESTO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_PUESTO", referencedColumnName = "ID_PUESTO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PuestoEmpleado puestoEmpleado;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "MES", referencedColumnName = "MES", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NUM_PLANILLA", referencedColumnName = "NUM_PLANILLA", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Planilla planilla;

    public ResumenAsistencia()
    {
    }

    public ResumenAsistencia(ResumenAsistenciaPK resumenAsistenciaPK)
    {
        this.resumenAsistenciaPK = resumenAsistenciaPK;
    }

    public ResumenAsistencia(long idCompania, long anio, long mes, long numPlanilla, long codEmp, long idSucursal, long idTipoPuesto, long idPuesto)
    {
        this.resumenAsistenciaPK = new ResumenAsistenciaPK(idCompania, anio, mes, numPlanilla, codEmp, idSucursal, idTipoPuesto, idPuesto);
    }

    public ResumenAsistenciaPK getResumenAsistenciaPK()
    {
        return resumenAsistenciaPK;
    }

    public void setResumenAsistenciaPK(ResumenAsistenciaPK resumenAsistenciaPK)
    {
        this.resumenAsistenciaPK = resumenAsistenciaPK;
    }

    public Long getDLaborados()
    {
        return dLaborados;
    }

    public void setDLaborados(Long dLaborados)
    {
        this.dLaborados = dLaborados;
    }

    public Long getDnLaborados()
    {
        return dnLaborados;
    }

    public void setDnLaborados(Long dnLaborados)
    {
        this.dnLaborados = dnLaborados;
    }

    public Long getHXsencillas()
    {
        return hXsencillas;
    }

    public void setHXsencillas(Long hXsencillas)
    {
        this.hXsencillas = hXsencillas;
    }

    public Long getHXdobles()
    {
        return hXdobles;
    }

    public void setHXdobles(Long hXdobles)
    {
        this.hXdobles = hXdobles;
    }

    public Long getViaticos()
    {
        return viaticos;
    }

    public void setViaticos(Long viaticos)
    {
        this.viaticos = viaticos;
    }

    public String getEstadoPla()
    {
        return estadoPla;
    }

    public void setEstadoPla(String estadoPla)
    {
        this.estadoPla = estadoPla;
    }

    public String getEstadoEmp()
    {
        return estadoEmp;
    }

    public void setEstadoEmp(String estadoEmp)
    {
        this.estadoEmp = estadoEmp;
    }

    public Long getHXf150()
    {
        return hXf150;
    }

    public void setHXf150(Long hXf150)
    {
        this.hXf150 = hXf150;
    }

    public Long getHXf250()
    {
        return hXf250;
    }

    public void setHXf250(Long hXf250)
    {
        this.hXf250 = hXf250;
    }

    public Long getDAguinaldo()
    {
        return dAguinaldo;
    }

    public void setDAguinaldo(Long dAguinaldo)
    {
        this.dAguinaldo = dAguinaldo;
    }

    public Long getHAusencia()
    {
        return hAusencia;
    }

    public void setHAusencia(Long hAusencia)
    {
        this.hAusencia = hAusencia;
    }

    public Long getDNocturnidad()
    {
        return dNocturnidad;
    }

    public void setDNocturnidad(Long dNocturnidad)
    {
        this.dNocturnidad = dNocturnidad;
    }

    public Long getVacaciones()
    {
        return vacaciones;
    }

    public void setVacaciones(Long vacaciones)
    {
        this.vacaciones = vacaciones;
    }

    public String getAguinaldo()
    {
        return aguinaldo;
    }

    public void setAguinaldo(String aguinaldo)
    {
        this.aguinaldo = aguinaldo;
    }

    public Sucursal getSucursal()
    {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal)
    {
        this.sucursal = sucursal;
    }

    public PuestoEmpleado getPuestoEmpleado()
    {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(PuestoEmpleado puestoEmpleado)
    {
        this.puestoEmpleado = puestoEmpleado;
    }

    public Planilla getPlanilla()
    {
        return planilla;
    }

    public void setPlanilla(Planilla planilla)
    {
        this.planilla = planilla;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (resumenAsistenciaPK != null ? resumenAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenAsistencia))
            {
            return false;
            }
        ResumenAsistencia other = (ResumenAsistencia) object;
        if ((this.resumenAsistenciaPK == null && other.resumenAsistenciaPK != null) || (this.resumenAsistenciaPK != null && !this.resumenAsistenciaPK.equals(other.resumenAsistenciaPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.ResumenAsistencia[ resumenAsistenciaPK=" + resumenAsistenciaPK + " ]";
    }
    
}
