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
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByTipoProyecto", query = "SELECT p FROM Proyecto p WHERE p.tipoProyecto = :tipoProyecto"),
    @NamedQuery(name = "Proyecto.findByProyecto", query = "SELECT p FROM Proyecto p WHERE p.proyectoPK.proyecto = :proyecto"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Proyecto.findByEncargado", query = "SELECT p FROM Proyecto p WHERE p.encargado = :encargado"),
    @NamedQuery(name = "Proyecto.findBySupervisor", query = "SELECT p FROM Proyecto p WHERE p.supervisor = :supervisor"),
    @NamedQuery(name = "Proyecto.findByMontoInicial", query = "SELECT p FROM Proyecto p WHERE p.montoInicial = :montoInicial"),
    @NamedQuery(name = "Proyecto.findByCodCia", query = "SELECT p FROM Proyecto p WHERE p.proyectoPK.codCia = :codCia"),
    @NamedQuery(name = "Proyecto.findBySubproyecto", query = "SELECT p FROM Proyecto p WHERE p.subproyecto = :subproyecto"),
    @NamedQuery(name = "Proyecto.findByStatus", query = "SELECT p FROM Proyecto p WHERE p.status = :status"),
    @NamedQuery(name = "Proyecto.findByUsuarioCrea", query = "SELECT p FROM Proyecto p WHERE p.usuarioCrea = :usuarioCrea"),
    @NamedQuery(name = "Proyecto.findByUsuarioMod", query = "SELECT p FROM Proyecto p WHERE p.usuarioMod = :usuarioMod"),
    @NamedQuery(name = "Proyecto.findByFechaCrea", query = "SELECT p FROM Proyecto p WHERE p.fechaCrea = :fechaCrea"),
    @NamedQuery(name = "Proyecto.findByFechaMod", query = "SELECT p FROM Proyecto p WHERE p.fechaMod = :fechaMod")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoPK proyectoPK;
    @Basic(optional = false)
    @Column(name = "TIPO_PROYECTO", nullable = false, length = 10)
    private String tipoProyecto;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "ENCARGADO", length = 50)
    private String encargado;
    @Column(name = "SUPERVISOR", length = 50)
    private String supervisor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_INICIAL", precision = 12, scale = 2)
    private BigDecimal montoInicial;
    @Column(name = "SUBPROYECTO", length = 1)
    private String subproyecto;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "USUARIO_CREA", length = 50)
    private String usuarioCrea;
    @Column(name = "USUARIO_MOD", length = 50)
    private String usuarioMod;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "FECHA_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMod;

    public Proyecto() {
    }

    public Proyecto(ProyectoPK proyectoPK) {
        this.proyectoPK = proyectoPK;
    }

    public Proyecto(ProyectoPK proyectoPK, String tipoProyecto, String nombre) {
        this.proyectoPK = proyectoPK;
        this.tipoProyecto = tipoProyecto;
        this.nombre = nombre;
    }

    public Proyecto(String proyecto, short codCia) {
        this.proyectoPK = new ProyectoPK(proyecto, codCia);
    }

    public ProyectoPK getProyectoPK() {
        return proyectoPK;
    }

    public void setProyectoPK(ProyectoPK proyectoPK) {
        this.proyectoPK = proyectoPK;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public BigDecimal getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public String getSubproyecto() {
        return subproyecto;
    }

    public void setSubproyecto(String subproyecto) {
        this.subproyecto = subproyecto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getUsuarioMod() {
        return usuarioMod;
    }

    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoPK != null ? proyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proyectoPK == null && other.proyectoPK != null) || (this.proyectoPK != null && !this.proyectoPK.equals(other.proyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Proyecto[ proyectoPK=" + proyectoPK + " ]";
    }
    
}
