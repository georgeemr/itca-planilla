/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EMPLEADO", uniqueConstraints =
    {
    @UniqueConstraint(columnNames =
        {
        "USUARIO"
        })
    })
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByCodCia", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.codCia = :codCia"),
    @NamedQuery(name = "Empleado.findByCodEmp", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.codEmp = :codEmp"),
    @NamedQuery(name = "Empleado.findByUsuario", query = "SELECT e FROM Empleado e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByApCasada", query = "SELECT e FROM Empleado e WHERE e.apCasada = :apCasada"),
    @NamedQuery(name = "Empleado.findByFechaNac", query = "SELECT e FROM Empleado e WHERE e.fechaNac = :fechaNac"),
    @NamedQuery(name = "Empleado.findByFecIngreso", query = "SELECT e FROM Empleado e WHERE e.fecIngreso = :fecIngreso"),
    @NamedQuery(name = "Empleado.findByFecSalida", query = "SELECT e FROM Empleado e WHERE e.fecSalida = :fecSalida"),
    @NamedQuery(name = "Empleado.findByObservacion", query = "SELECT e FROM Empleado e WHERE e.observacion = :observacion"),
    @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo")
    })
public class Empleado implements Serializable
{
    @Column(name =     "FECHA_NAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Column(name =     "FEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Column(name =     "FEC_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSalida;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EmpleadoPK empleadoPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "USUARIO", nullable = false, length = 200)
    private String usuario;

    @Size(max = 200)
    @Column(name = "NOMBRES", length = 200)
    private String nombres;

    @Size(max = 200)
    @Column(name = "APELLIDOS", length = 200)
    private String apellidos;

    @Size(max = 200)
    @Column(name = "AP_CASADA", length = 200)
    private String apCasada;

    @Size(max = 200)
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;

    @Size(max = 200)
    @Column(name = "CORREO", length = 200)
    private String correo;

    @JoinTable(name = "EVALUADOR_EVALUACIONES", joinColumns =
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "EVALUADOR", referencedColumnName = "COD_EMP", nullable = false)
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false),
        @JoinColumn(name = "CAMPANIA", referencedColumnName = "COD_CAMPANIA", nullable = false),
        @JoinColumn(name = "TIPO_EVALUACION", referencedColumnName = "TIPO_EVALUACION", nullable = false),
        @JoinColumn(name = "PLANTILLA", referencedColumnName = "PLANTILLA", nullable = false),
        @JoinColumn(name = "EMPLEADO", referencedColumnName = "EMPLEADO", nullable = false)
        })
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Evaluacion> evaluacionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<AccionPersonal> accionPersonalList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<DetPlanilla> detPlanillaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Contrato> contratoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Evaluacion> evaluacionList1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PuestoEmpleado> puestoEmpleadoList;

    @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    public Empleado()
    {
    }

    public Empleado(EmpleadoPK empleadoPK)
    {
        this.empleadoPK = empleadoPK;
    }

    public Empleado(EmpleadoPK empleadoPK, String usuario)
    {
        this.empleadoPK = empleadoPK;
        this.usuario = usuario;
    }

    public Empleado(long codCia, long codEmp)
    {
        this.empleadoPK = new EmpleadoPK(codCia, codEmp);
    }

    public EmpleadoPK getEmpleadoPK()
    {
        return empleadoPK;
    }

    public void setEmpleadoPK(EmpleadoPK empleadoPK)
    {
        this.empleadoPK = empleadoPK;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public String getApCasada()
    {
        return apCasada;
    }

    public void setApCasada(String apCasada)
    {
        this.apCasada = apCasada;
    }

    public Date getFechaNac()
    {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac)
    {
        this.fechaNac = fechaNac;
    }

    public Date getFecIngreso()
    {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso)
    {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecSalida()
    {
        return fecSalida;
    }

    public void setFecSalida(Date fecSalida)
    {
        this.fecSalida = fecSalida;
    }

    public String getObservacion()
    {
        return observacion;
    }

    public void setObservacion(String observacion)
    {
        this.observacion = observacion;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList()
    {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList)
    {
        this.evaluacionList = evaluacionList;
    }

    @XmlTransient
    public List<AccionPersonal> getAccionPersonalList()
    {
        return accionPersonalList;
    }

    public void setAccionPersonalList(List<AccionPersonal> accionPersonalList)
    {
        this.accionPersonalList = accionPersonalList;
    }

    @XmlTransient
    public List<DetPlanilla> getDetPlanillaList()
    {
        return detPlanillaList;
    }

    public void setDetPlanillaList(List<DetPlanilla> detPlanillaList)
    {
        this.detPlanillaList = detPlanillaList;
    }

    @XmlTransient
    public List<Contrato> getContratoList()
    {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList)
    {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList1()
    {
        return evaluacionList1;
    }

    public void setEvaluacionList1(List<Evaluacion> evaluacionList1)
    {
        this.evaluacionList1 = evaluacionList1;
    }

    @XmlTransient
    public List<PuestoEmpleado> getPuestoEmpleadoList()
    {
        return puestoEmpleadoList;
    }

    public void setPuestoEmpleadoList(List<PuestoEmpleado> puestoEmpleadoList)
    {
        this.puestoEmpleadoList = puestoEmpleadoList;
    }

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (empleadoPK != null ? empleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado))
            {
            return false;
            }
        Empleado other = (Empleado) object;
        if ((this.empleadoPK == null && other.empleadoPK != null) || (this.empleadoPK != null && !this.empleadoPK.equals(other.empleadoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Empleado[ empleadoPK=" + empleadoPK + " ]";
    }
    
    @Transient
    private String nombreCompleto;

    public String getNombreCompleto()
    {
        nombreCompleto = getNombres() + ((getApellidos() != null) ? " " + getApellidos() : "" );
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;
    }
    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
}
