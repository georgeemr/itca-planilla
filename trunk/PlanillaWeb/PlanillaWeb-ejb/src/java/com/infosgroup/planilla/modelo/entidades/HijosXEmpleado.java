/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "HIJOS_X_EMPLEADO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HijosXEmpleado.findAll", query = "SELECT h FROM HijosXEmpleado h"),
    @NamedQuery(name = "HijosXEmpleado.findByCodCia", query = "SELECT h FROM HijosXEmpleado h WHERE h.hijosXEmpleadoPK.codCia = :codCia"),
    @NamedQuery(name = "HijosXEmpleado.findByCodEmp", query = "SELECT h FROM HijosXEmpleado h WHERE h.hijosXEmpleadoPK.codEmp = :codEmp"),
    @NamedQuery(name = "HijosXEmpleado.findByCorrelativo", query = "SELECT h FROM HijosXEmpleado h WHERE h.hijosXEmpleadoPK.correlativo = :correlativo"),
    @NamedQuery(name = "HijosXEmpleado.findByNombre", query = "SELECT h FROM HijosXEmpleado h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HijosXEmpleado.findBySexo", query = "SELECT h FROM HijosXEmpleado h WHERE h.sexo = :sexo"),
    @NamedQuery(name = "HijosXEmpleado.findByFechaNacimiento", query = "SELECT h FROM HijosXEmpleado h WHERE h.fechaNacimiento = :fechaNacimiento")})
public class HijosXEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HijosXEmpleadoPK hijosXEmpleadoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEXO", nullable = false, length = 1)
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public HijosXEmpleado() {
    }

    public HijosXEmpleado(HijosXEmpleadoPK hijosXEmpleadoPK) {
        this.hijosXEmpleadoPK = hijosXEmpleadoPK;
    }

    public HijosXEmpleado(HijosXEmpleadoPK hijosXEmpleadoPK, String nombre, String sexo, Date fechaNacimiento) {
        this.hijosXEmpleadoPK = hijosXEmpleadoPK;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public HijosXEmpleado(short codCia, int codEmp, short correlativo) {
        this.hijosXEmpleadoPK = new HijosXEmpleadoPK(codCia, codEmp, correlativo);
    }

    public HijosXEmpleadoPK getHijosXEmpleadoPK() {
        return hijosXEmpleadoPK;
    }

    public void setHijosXEmpleadoPK(HijosXEmpleadoPK hijosXEmpleadoPK) {
        this.hijosXEmpleadoPK = hijosXEmpleadoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
        hash += (hijosXEmpleadoPK != null ? hijosXEmpleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HijosXEmpleado)) {
            return false;
        }
        HijosXEmpleado other = (HijosXEmpleado) object;
        if ((this.hijosXEmpleadoPK == null && other.hijosXEmpleadoPK != null) || (this.hijosXEmpleadoPK != null && !this.hijosXEmpleadoPK.equals(other.hijosXEmpleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HijosXEmpleado[ hijosXEmpleadoPK=" + hijosXEmpleadoPK + " ]";
    }
    
}
