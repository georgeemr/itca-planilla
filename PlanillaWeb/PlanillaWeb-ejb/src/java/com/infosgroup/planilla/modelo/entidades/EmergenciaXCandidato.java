/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EMERGENCIA_X_CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmergenciaXCandidato.findAll", query = "SELECT e FROM EmergenciaXCandidato e"),
    @NamedQuery(name = "EmergenciaXCandidato.findByCodCia", query = "SELECT e FROM EmergenciaXCandidato e WHERE e.emergenciaXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "EmergenciaXCandidato.findByCodCandidato", query = "SELECT e FROM EmergenciaXCandidato e WHERE e.emergenciaXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "EmergenciaXCandidato.findByCodEmergencia", query = "SELECT e FROM EmergenciaXCandidato e WHERE e.emergenciaXCandidatoPK.codEmergencia = :codEmergencia"),
    @NamedQuery(name = "EmergenciaXCandidato.findByNombre", query = "SELECT e FROM EmergenciaXCandidato e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmergenciaXCandidato.findByTelefono", query = "SELECT e FROM EmergenciaXCandidato e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "EmergenciaXCandidato.findByCodParentesco", query = "SELECT e FROM EmergenciaXCandidato e WHERE e.codParentesco = :codParentesco")})
public class EmergenciaXCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmergenciaXCandidatoPK emergenciaXCandidatoPK;
    @Size(max = 200)
    @Column(name = "NOMBRE", length = 200)
    private String nombre;
    @Size(max = 20)
    @Column(name = "TELEFONO", length = 20)
    private String telefono;
    @Column(name = "COD_PARENTESCO")
    private Short codParentesco;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public EmergenciaXCandidato() {
    }

    public EmergenciaXCandidato(EmergenciaXCandidatoPK emergenciaXCandidatoPK) {
        this.emergenciaXCandidatoPK = emergenciaXCandidatoPK;
    }

    public EmergenciaXCandidato(short codCia, int codCandidato, int codEmergencia) {
        this.emergenciaXCandidatoPK = new EmergenciaXCandidatoPK(codCia, codCandidato, codEmergencia);
    }

    public EmergenciaXCandidatoPK getEmergenciaXCandidatoPK() {
        return emergenciaXCandidatoPK;
    }

    public void setEmergenciaXCandidatoPK(EmergenciaXCandidatoPK emergenciaXCandidatoPK) {
        this.emergenciaXCandidatoPK = emergenciaXCandidatoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Short getCodParentesco() {
        return codParentesco;
    }

    public void setCodParentesco(Short codParentesco) {
        this.codParentesco = codParentesco;
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
        hash += (emergenciaXCandidatoPK != null ? emergenciaXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmergenciaXCandidato)) {
            return false;
        }
        EmergenciaXCandidato other = (EmergenciaXCandidato) object;
        if ((this.emergenciaXCandidatoPK == null && other.emergenciaXCandidatoPK != null) || (this.emergenciaXCandidatoPK != null && !this.emergenciaXCandidatoPK.equals(other.emergenciaXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EmergenciaXCandidato[ emergenciaXCandidatoPK=" + emergenciaXCandidatoPK + " ]";
    }
    
}
