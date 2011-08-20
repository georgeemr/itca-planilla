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
    @NamedQuery(name = "Empleado.findByIdCompania", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.idCompania = :idCompania"),
    @NamedQuery(name = "Empleado.findByIdSucursal", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNomEmpleado", query = "SELECT e FROM Empleado e WHERE e.nomEmpleado = :nomEmpleado"),
    @NamedQuery(name = "Empleado.findByApeEmpleado", query = "SELECT e FROM Empleado e WHERE e.apeEmpleado = :apeEmpleado"),
    @NamedQuery(name = "Empleado.findByDetEmpleado", query = "SELECT e FROM Empleado e WHERE e.detEmpleado = :detEmpleado"),
    @NamedQuery(name = "Empleado.findBySexo", query = "SELECT e FROM Empleado e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "Empleado.findByFecNacimiento", query = "SELECT e FROM Empleado e WHERE e.fecNacimiento = :fecNacimiento")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoPK empleadoPK;
    @Size(max = 100)
    @Column(name = "nom_empleado", length = 100)
    private String nomEmpleado;
    @Size(max = 100)
    @Column(name = "ape_empleado", length = 100)
    private String apeEmpleado;
    @Size(max = 100)
    @Column(name = "det_empleado", length = 100)
    private String detEmpleado;
    @Size(max = 1)
    @Column(name = "sexo", length = 1)
    private String sexo;
    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fecNacimiento;
    @ManyToMany(mappedBy = "empleadoList", fetch = FetchType.EAGER)
    private List<Direccion> direccionList;
    @JoinTable(name = "empleado_telefono", joinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false),
        @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_telefono", referencedColumnName = "id_telefono", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Telefono> telefonoList;
    @JoinTable(name = "planilla", joinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false),
        @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_tipo_planilla", referencedColumnName = "id_tipo_planilla", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TipoPlanilla> tipoPlanillaList;
    @JoinTable(name = "empleado_nivel_academico", joinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false),
        @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_nivel_academico", referencedColumnName = "id_nivel_academico", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<NivelAcademico> nivelAcademicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<SalarioBase> salarioBaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<DocumentoEmpleado> documentoEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PuestoEmpleado> puestoEmpleadoList;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sucursal sucursal;
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id_estado_civil", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoCivil idEstadoCivil;

    public Empleado() {
    }

    public Empleado(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public Empleado(int idCompania, int idSucursal, int idEmpleado) {
        this.empleadoPK = new EmpleadoPK(idCompania, idSucursal, idEmpleado);
    }

    public EmpleadoPK getEmpleadoPK() {
        return empleadoPK;
    }

    public void setEmpleadoPK(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getApeEmpleado() {
        return apeEmpleado;
    }

    public void setApeEmpleado(String apeEmpleado) {
        this.apeEmpleado = apeEmpleado;
    }

    public String getDetEmpleado() {
        return detEmpleado;
    }

    public void setDetEmpleado(String detEmpleado) {
        this.detEmpleado = detEmpleado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @XmlTransient
    public List<TipoPlanilla> getTipoPlanillaList() {
        return tipoPlanillaList;
    }

    public void setTipoPlanillaList(List<TipoPlanilla> tipoPlanillaList) {
        this.tipoPlanillaList = tipoPlanillaList;
    }

    @XmlTransient
    public List<NivelAcademico> getNivelAcademicoList() {
        return nivelAcademicoList;
    }

    public void setNivelAcademicoList(List<NivelAcademico> nivelAcademicoList) {
        this.nivelAcademicoList = nivelAcademicoList;
    }

    @XmlTransient
    public List<SalarioBase> getSalarioBaseList() {
        return salarioBaseList;
    }

    public void setSalarioBaseList(List<SalarioBase> salarioBaseList) {
        this.salarioBaseList = salarioBaseList;
    }

    @XmlTransient
    public List<DocumentoEmpleado> getDocumentoEmpleadoList() {
        return documentoEmpleadoList;
    }

    public void setDocumentoEmpleadoList(List<DocumentoEmpleado> documentoEmpleadoList) {
        this.documentoEmpleadoList = documentoEmpleadoList;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<PuestoEmpleado> getPuestoEmpleadoList() {
        return puestoEmpleadoList;
    }

    public void setPuestoEmpleadoList(List<PuestoEmpleado> puestoEmpleadoList) {
        this.puestoEmpleadoList = puestoEmpleadoList;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public EstadoCivil getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(EstadoCivil idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
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
