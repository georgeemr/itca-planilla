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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "PROFESIONES_X_CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesionesXCandidato.findAll", query = "SELECT p FROM ProfesionesXCandidato p"),
    @NamedQuery(name = "ProfesionesXCandidato.findByCodCia", query = "SELECT p FROM ProfesionesXCandidato p WHERE p.profesionesXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "ProfesionesXCandidato.findByCodCandidato", query = "SELECT p FROM ProfesionesXCandidato p WHERE p.profesionesXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "ProfesionesXCandidato.findByCodProfesion", query = "SELECT p FROM ProfesionesXCandidato p WHERE p.profesionesXCandidatoPK.codProfesion = :codProfesion"),
    @NamedQuery(name = "ProfesionesXCandidato.findByFecha", query = "SELECT p FROM ProfesionesXCandidato p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "ProfesionesXCandidato.findByIncorporado", query = "SELECT p FROM ProfesionesXCandidato p WHERE p.incorporado = :incorporado"),
    @NamedQuery(name = "ProfesionesXCandidato.findByCodUniversidad", query = "SELECT p FROM ProfesionesXCandidato p WHERE p.codUniversidad = :codUniversidad")})
public class ProfesionesXCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfesionesXCandidatoPK profesionesXCandidatoPK;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "INCORPORADO", length = 1)
    private String incorporado;
    @Column(name = "COD_UNIVERSIDAD")
    private Short codUniversidad;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public ProfesionesXCandidato() {
    }

    public ProfesionesXCandidato(ProfesionesXCandidatoPK profesionesXCandidatoPK) {
        this.profesionesXCandidatoPK = profesionesXCandidatoPK;
    }

    public ProfesionesXCandidato(short codCia, int codCandidato, short codProfesion) {
        this.profesionesXCandidatoPK = new ProfesionesXCandidatoPK(codCia, codCandidato, codProfesion);
    }

    public ProfesionesXCandidatoPK getProfesionesXCandidatoPK() {
        return profesionesXCandidatoPK;
    }

    public void setProfesionesXCandidatoPK(ProfesionesXCandidatoPK profesionesXCandidatoPK) {
        this.profesionesXCandidatoPK = profesionesXCandidatoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIncorporado() {
        return incorporado;
    }

    public void setIncorporado(String incorporado) {
        this.incorporado = incorporado;
    }

    public Short getCodUniversidad() {
        return codUniversidad;
    }

    public void setCodUniversidad(Short codUniversidad) {
        this.codUniversidad = codUniversidad;
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
        hash += (profesionesXCandidatoPK != null ? profesionesXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesionesXCandidato)) {
            return false;
        }
        ProfesionesXCandidato other = (ProfesionesXCandidato) object;
        if ((this.profesionesXCandidatoPK == null && other.profesionesXCandidatoPK != null) || (this.profesionesXCandidatoPK != null && !this.profesionesXCandidatoPK.equals(other.profesionesXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ProfesionesXCandidato[ profesionesXCandidatoPK=" + profesionesXCandidatoPK + " ]";
    }
    
}
