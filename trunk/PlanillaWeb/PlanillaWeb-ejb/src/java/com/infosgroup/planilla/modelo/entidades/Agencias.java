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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "AGENCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agencias.findAll", query = "SELECT a FROM Agencias a"),
    @NamedQuery(name = "Agencias.findByCodCia", query = "SELECT a FROM Agencias a WHERE a.agenciasPK.codCia = :codCia"),
    @NamedQuery(name = "Agencias.findByCodAgencia", query = "SELECT a FROM Agencias a WHERE a.agenciasPK.codAgencia = :codAgencia"),
    @NamedQuery(name = "Agencias.findByNomAgencia", query = "SELECT a FROM Agencias a WHERE a.nomAgencia = :nomAgencia"),
    @NamedQuery(name = "Agencias.findByFecCreacion", query = "SELECT a FROM Agencias a WHERE a.fecCreacion = :fecCreacion"),
    @NamedQuery(name = "Agencias.findByStatus", query = "SELECT a FROM Agencias a WHERE a.status = :status"),
    @NamedQuery(name = "Agencias.findByDirAgencia", query = "SELECT a FROM Agencias a WHERE a.dirAgencia = :dirAgencia"),
    @NamedQuery(name = "Agencias.findByTelAgencia", query = "SELECT a FROM Agencias a WHERE a.telAgencia = :telAgencia"),
    @NamedQuery(name = "Agencias.findByFaxAgencia", query = "SELECT a FROM Agencias a WHERE a.faxAgencia = :faxAgencia"),
    @NamedQuery(name = "Agencias.findByMailAgencia", query = "SELECT a FROM Agencias a WHERE a.mailAgencia = :mailAgencia"),
    @NamedQuery(name = "Agencias.findByEncargado", query = "SELECT a FROM Agencias a WHERE a.encargado = :encargado"),
    @NamedQuery(name = "Agencias.findByFecStatus", query = "SELECT a FROM Agencias a WHERE a.fecStatus = :fecStatus"),
    @NamedQuery(name = "Agencias.findByAbrev", query = "SELECT a FROM Agencias a WHERE a.abrev = :abrev"),
    @NamedQuery(name = "Agencias.findByCodPais", query = "SELECT a FROM Agencias a WHERE a.codPais = :codPais"),
    @NamedQuery(name = "Agencias.findByCodDepar", query = "SELECT a FROM Agencias a WHERE a.codDepar = :codDepar"),
    @NamedQuery(name = "Agencias.findByCodMuni", query = "SELECT a FROM Agencias a WHERE a.codMuni = :codMuni")})
public class Agencias implements Serializable {
    @Column(name =     "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name =     "FEC_STATUS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencias")
    private List<Empleados> empleadosList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgenciasPK agenciasPK;
    @Column(name = "NOM_AGENCIA", length = 100)
    private String nomAgencia;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "DIR_AGENCIA", length = 120)
    private String dirAgencia;
    @Column(name = "TEL_AGENCIA", length = 15)
    private String telAgencia;
    @Column(name = "FAX_AGENCIA", length = 15)
    private String faxAgencia;
    @Column(name = "MAIL_AGENCIA", length = 50)
    private String mailAgencia;
    @Column(name = "ENCARGADO", length = 100)
    private String encargado;
    @Column(name = "ABREV", length = 10)
    private String abrev;
    @Column(name = "COD_PAIS")
    private Short codPais;
    @Column(name = "COD_DEPAR")
    private Short codDepar;
    @Column(name = "COD_MUNI")
    private Short codMuni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencias")
    private List<Contrato> contratoList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ParamPlan paramPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencias")
    private List<PuestoEmpleado> puestoEmpleadoList;

    public Agencias() {
    }

    public Agencias(AgenciasPK agenciasPK) {
        this.agenciasPK = agenciasPK;
    }

    public Agencias(short codCia, short codAgencia) {
        this.agenciasPK = new AgenciasPK(codCia, codAgencia);
    }

    public AgenciasPK getAgenciasPK() {
        return agenciasPK;
    }

    public void setAgenciasPK(AgenciasPK agenciasPK) {
        this.agenciasPK = agenciasPK;
    }

    public String getNomAgencia() {
        return nomAgencia;
    }

    public void setNomAgencia(String nomAgencia) {
        this.nomAgencia = nomAgencia;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirAgencia() {
        return dirAgencia;
    }

    public void setDirAgencia(String dirAgencia) {
        this.dirAgencia = dirAgencia;
    }

    public String getTelAgencia() {
        return telAgencia;
    }

    public void setTelAgencia(String telAgencia) {
        this.telAgencia = telAgencia;
    }

    public String getFaxAgencia() {
        return faxAgencia;
    }

    public void setFaxAgencia(String faxAgencia) {
        this.faxAgencia = faxAgencia;
    }

    public String getMailAgencia() {
        return mailAgencia;
    }

    public void setMailAgencia(String mailAgencia) {
        this.mailAgencia = mailAgencia;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Date getFecStatus() {
        return fecStatus;
    }

    public void setFecStatus(Date fecStatus) {
        this.fecStatus = fecStatus;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public Short getCodPais() {
        return codPais;
    }

    public void setCodPais(Short codPais) {
        this.codPais = codPais;
    }

    public Short getCodDepar() {
        return codDepar;
    }

    public void setCodDepar(Short codDepar) {
        this.codDepar = codDepar;
    }

    public Short getCodMuni() {
        return codMuni;
    }

    public void setCodMuni(Short codMuni) {
        this.codMuni = codMuni;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public ParamPlan getParamPlan() {
        return paramPlan;
    }

    public void setParamPlan(ParamPlan paramPlan) {
        this.paramPlan = paramPlan;
    }

    @XmlTransient
    public List<PuestoEmpleado> getPuestoEmpleadoList() {
        return puestoEmpleadoList;
    }

    public void setPuestoEmpleadoList(List<PuestoEmpleado> puestoEmpleadoList) {
        this.puestoEmpleadoList = puestoEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agenciasPK != null ? agenciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agencias)) {
            return false;
        }
        Agencias other = (Agencias) object;
        if ((this.agenciasPK == null && other.agenciasPK != null) || (this.agenciasPK != null && !this.agenciasPK.equals(other.agenciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Agencias[ agenciasPK=" + agenciasPK + " ]";
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

}