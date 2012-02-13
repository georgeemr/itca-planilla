/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "AGENCIAS", catalog = "", schema = "FACTUR")
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
    @NamedQuery(name = "Agencias.findByAbrev", query = "SELECT a FROM Agencias a WHERE a.abrev = :abrev")})
public class Agencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgenciasPK agenciasPK;
    @Column(name = "NOM_AGENCIA", length = 100)
    private String nomAgencia;
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
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
    @Column(name = "FEC_STATUS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecStatus;
    @Column(name = "ABREV", length = 10)
    private String abrev;

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
        return "com.infosgroup.planilla.modelo.entidades.factur.Agencias[ agenciasPK=" + agenciasPK + " ]";
    }
    
}
