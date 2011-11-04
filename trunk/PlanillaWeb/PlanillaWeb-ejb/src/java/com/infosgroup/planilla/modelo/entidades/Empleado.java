/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByCodCia", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.codCia = :codCia"),
    @NamedQuery(name = "Empleado.findByCodEmp", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.codEmp = :codEmp"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByApCasada", query = "SELECT e FROM Empleado e WHERE e.apCasada = :apCasada"),
    @NamedQuery(name = "Empleado.findByFechaNac", query = "SELECT e FROM Empleado e WHERE e.fechaNac = :fechaNac"),
    @NamedQuery(name = "Empleado.findByFecIngreso", query = "SELECT e FROM Empleado e WHERE e.fecIngreso = :fecIngreso"),
    @NamedQuery(name = "Empleado.findByFecSalida", query = "SELECT e FROM Empleado e WHERE e.fecSalida = :fecSalida"),
    @NamedQuery(name = "Empleado.findByObservacion", query = "SELECT e FROM Empleado e WHERE e.observacion = :observacion")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoPK empleadoPK;
    @Size(max = 2147483647)
    @Column(name = "nombres", length = 2147483647)
    private String nombres;
    @Size(max = 2147483647)
    @Column(name = "apellidos", length = 2147483647)
    private String apellidos;
    @Size(max = 2147483647)
    @Column(name = "ap_casada", length = 2147483647)
    private String apCasada;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "fec_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fecIngreso;
    @Column(name = "fec_salida")
    @Temporal(TemporalType.DATE)
    private Date fecSalida;
    @Size(max = 2147483647)
    @Column(name = "observacion", length = 2147483647)
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1")
    private List<Evaluacion> evaluacionList;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public Empleado() {
    }

    public Empleado(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public Empleado(int codCia, int codEmp) {
        this.empleadoPK = new EmpleadoPK(codCia, codEmp);
    }

    public EmpleadoPK getEmpleadoPK() {
        return empleadoPK;
    }

    public void setEmpleadoPK(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApCasada() {
        return apCasada;
    }

    public void setApCasada(String apCasada) {
        this.apCasada = apCasada;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(Date fecSalida) {
        this.fecSalida = fecSalida;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoPK != null ? empleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empleadoPK == null && other.empleadoPK != null) || (this.empleadoPK != null && !this.empleadoPK.equals(other.empleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Empleado[ empleadoPK=" + empleadoPK + " ]";
    }
    
}
