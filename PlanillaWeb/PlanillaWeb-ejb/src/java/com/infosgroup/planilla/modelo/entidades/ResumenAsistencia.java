/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author root
 */
@Entity
@Table(name = "resumen_asistencia")
@NamedQueries({
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
    @NamedQuery(name = "ResumenAsistencia.findByAguinaldo", query = "SELECT r FROM ResumenAsistencia r WHERE r.aguinaldo = :aguinaldo")})
public class ResumenAsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResumenAsistenciaPK resumenAsistenciaPK;
    @Column(name = "d_laborados")
    private Integer dLaborados;
    @Column(name = "dn_laborados")
    private Integer dnLaborados;
    @Column(name = "h_xsencillas")
    private Integer hXsencillas;
    @Column(name = "h_xdobles")
    private Integer hXdobles;
    @Column(name = "viaticos")
    private Integer viaticos;
    @Column(name = "estado_pla")
    private Character estadoPla;
    @Column(name = "estado_emp")
    private Character estadoEmp;
    @Column(name = "h_xf150")
    private Integer hXf150;
    @Column(name = "h_xf250")
    private Integer hXf250;
    @Column(name = "d_aguinaldo")
    private Integer dAguinaldo;
    @Column(name = "h_ausencia")
    private Integer hAusencia;
    @Column(name = "d_nocturnidad")
    private Integer dNocturnidad;
    @Column(name = "vacaciones")
    private Integer vacaciones;
    @Column(name = "aguinaldo")
    private Character aguinaldo;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_emp", referencedColumnName = "id_empleado", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_tipo_puesto", referencedColumnName = "id_tipo_puesto", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PuestoEmpleado puestoEmpleado;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "anio", referencedColumnName = "anio", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "mes", referencedColumnName = "mes", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "num_planilla", referencedColumnName = "num_planilla", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Planilla planilla;
//    private List<ResumenAsistencia> resumenList;
//
//    public List<ResumenAsistencia> getResumenList() {
//        return resumenList;
//    }
//
//    public void setResumenList(List<ResumenAsistencia> resumenList) {
//        this.resumenList = resumenList;
//    }

    public ResumenAsistencia() {
    }

    public ResumenAsistencia(ResumenAsistenciaPK resumenAsistenciaPK) {
        this.resumenAsistenciaPK = resumenAsistenciaPK;
    }

    public ResumenAsistencia(int idCompania, int anio, int mes, int numPlanilla, int codEmp, int idSucursal, int idTipoPuesto, int idPuesto) {
        this.resumenAsistenciaPK = new ResumenAsistenciaPK(idCompania, anio, mes, numPlanilla, codEmp, idSucursal, idTipoPuesto, idPuesto);
    }

    public ResumenAsistenciaPK getResumenAsistenciaPK() {
        return resumenAsistenciaPK;
    }

    public void setResumenAsistenciaPK(ResumenAsistenciaPK resumenAsistenciaPK) {
        this.resumenAsistenciaPK = resumenAsistenciaPK;
    }

    public Integer getDLaborados() {
        return dLaborados;
    }

    public void setDLaborados(Integer dLaborados) {
        this.dLaborados = dLaborados;
    }

    public Integer getDnLaborados() {
        return dnLaborados;
    }

    public void setDnLaborados(Integer dnLaborados) {
        this.dnLaborados = dnLaborados;
    }

    public Integer getHXsencillas() {
        return hXsencillas;
    }

    public void setHXsencillas(Integer hXsencillas) {
        this.hXsencillas = hXsencillas;
    }

    public Integer getHXdobles() {
        return hXdobles;
    }

    public void setHXdobles(Integer hXdobles) {
        this.hXdobles = hXdobles;
    }

    public Integer getViaticos() {
        return viaticos;
    }

    public void setViaticos(Integer viaticos) {
        this.viaticos = viaticos;
    }

    public Character getEstadoPla() {
        return estadoPla;
    }

    public void setEstadoPla(Character estadoPla) {
        this.estadoPla = estadoPla;
    }

    public Character getEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(Character estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public Integer getHXf150() {
        return hXf150;
    }

    public void setHXf150(Integer hXf150) {
        this.hXf150 = hXf150;
    }

    public Integer getHXf250() {
        return hXf250;
    }

    public void setHXf250(Integer hXf250) {
        this.hXf250 = hXf250;
    }

    public Integer getDAguinaldo() {
        return dAguinaldo;
    }

    public void setDAguinaldo(Integer dAguinaldo) {
        this.dAguinaldo = dAguinaldo;
    }

    public Integer getHAusencia() {
        return hAusencia;
    }

    public void setHAusencia(Integer hAusencia) {
        this.hAusencia = hAusencia;
    }

    public Integer getDNocturnidad() {
        return dNocturnidad;
    }

    public void setDNocturnidad(Integer dNocturnidad) {
        this.dNocturnidad = dNocturnidad;
    }

    public Integer getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(Integer vacaciones) {
        this.vacaciones = vacaciones;
    }

    public Character getAguinaldo() {
        return aguinaldo;
    }

    public void setAguinaldo(Character aguinaldo) {
        this.aguinaldo = aguinaldo;
    }

    public PuestoEmpleado getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(PuestoEmpleado puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resumenAsistenciaPK != null ? resumenAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenAsistencia)) {
            return false;
        }
        ResumenAsistencia other = (ResumenAsistencia) object;
        if ((this.resumenAsistenciaPK == null && other.resumenAsistenciaPK != null) || (this.resumenAsistenciaPK != null && !this.resumenAsistenciaPK.equals(other.resumenAsistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ResumenAsistencia[ resumenAsistenciaPK=" + resumenAsistenciaPK + " ]";
    }
    
}
