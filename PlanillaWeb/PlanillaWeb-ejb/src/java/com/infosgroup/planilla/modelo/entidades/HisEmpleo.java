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
@Table(name = "HIS_EMPLEO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HisEmpleo.findAll", query = "SELECT h FROM HisEmpleo h"),
    @NamedQuery(name = "HisEmpleo.findByCodCia", query = "SELECT h FROM HisEmpleo h WHERE h.hisEmpleoPK.codCia = :codCia"),
    @NamedQuery(name = "HisEmpleo.findByCodHisEmpleo", query = "SELECT h FROM HisEmpleo h WHERE h.hisEmpleoPK.codHisEmpleo = :codHisEmpleo"),
    @NamedQuery(name = "HisEmpleo.findByNomEmpresa", query = "SELECT h FROM HisEmpleo h WHERE h.nomEmpresa = :nomEmpresa"),
    @NamedQuery(name = "HisEmpleo.findByFechIngreso", query = "SELECT h FROM HisEmpleo h WHERE h.fechIngreso = :fechIngreso"),
    @NamedQuery(name = "HisEmpleo.findByFechRetiro", query = "SELECT h FROM HisEmpleo h WHERE h.fechRetiro = :fechRetiro")})
public class HisEmpleo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HisEmpleoPK hisEmpleoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOM_EMPRESA", nullable = false, length = 100)
    private String nomEmpresa;
    @Column(name = "FECH_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechIngreso;
    @Column(name = "FECH_RETIRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechRetiro;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO")})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public HisEmpleo() {
    }

    public HisEmpleo(HisEmpleoPK hisEmpleoPK) {
        this.hisEmpleoPK = hisEmpleoPK;
    }

    public HisEmpleo(HisEmpleoPK hisEmpleoPK, String nomEmpresa) {
        this.hisEmpleoPK = hisEmpleoPK;
        this.nomEmpresa = nomEmpresa;
    }

    public HisEmpleo(short codCia, int codHisEmpleo) {
        this.hisEmpleoPK = new HisEmpleoPK(codCia, codHisEmpleo);
    }

    public HisEmpleoPK getHisEmpleoPK() {
        return hisEmpleoPK;
    }

    public void setHisEmpleoPK(HisEmpleoPK hisEmpleoPK) {
        this.hisEmpleoPK = hisEmpleoPK;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public Date getFechIngreso() {
        return fechIngreso;
    }

    public void setFechIngreso(Date fechIngreso) {
        this.fechIngreso = fechIngreso;
    }

    public Date getFechRetiro() {
        return fechRetiro;
    }

    public void setFechRetiro(Date fechRetiro) {
        this.fechRetiro = fechRetiro;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisEmpleoPK != null ? hisEmpleoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HisEmpleo)) {
            return false;
        }
        HisEmpleo other = (HisEmpleo) object;
        if ((this.hisEmpleoPK == null && other.hisEmpleoPK != null) || (this.hisEmpleoPK != null && !this.hisEmpleoPK.equals(other.hisEmpleoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HisEmpleo[ hisEmpleoPK=" + hisEmpleoPK + " ]";
    }
    
}
