/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PROGRAMA_ENTRENAMIENTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramaEntrenamiento.findAll", query = "SELECT p FROM ProgramaEntrenamiento p"),
    @NamedQuery(name = "ProgramaEntrenamiento.findByCodCia", query = "SELECT p FROM ProgramaEntrenamiento p WHERE p.programaEntrenamientoPK.codCia = :codCia"),
    @NamedQuery(name = "ProgramaEntrenamiento.findByPeriodo", query = "SELECT p FROM ProgramaEntrenamiento p WHERE p.programaEntrenamientoPK.periodo = :periodo"),
    @NamedQuery(name = "ProgramaEntrenamiento.findByCodDepto", query = "SELECT p FROM ProgramaEntrenamiento p WHERE p.programaEntrenamientoPK.codDepto = :codDepto"),
    @NamedQuery(name = "ProgramaEntrenamiento.findByEstado", query = "SELECT p FROM ProgramaEntrenamiento p WHERE p.estado = :estado"),
    @NamedQuery(name = "ProgramaEntrenamiento.findByObservacion", query = "SELECT p FROM ProgramaEntrenamiento p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "ProgramaEntrenamiento.findByCodEmp", query = "SELECT p FROM ProgramaEntrenamiento p WHERE p.codEmp = :codEmp")})
public class ProgramaEntrenamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramaEntrenamientoPK programaEntrenamientoPK;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @Column(name = "OBSERVACION", length = 100)
    private String observacion;
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaEntrenamiento")
    private List<DetProgramaEntrenamiento> detProgramaEntrenamientoList;

    public ProgramaEntrenamiento() {
    }

    public ProgramaEntrenamiento(ProgramaEntrenamientoPK programaEntrenamientoPK) {
        this.programaEntrenamientoPK = programaEntrenamientoPK;
    }

    public ProgramaEntrenamiento(short codCia, short periodo, short codDepto) {
        this.programaEntrenamientoPK = new ProgramaEntrenamientoPK(codCia, periodo, codDepto);
    }

    public ProgramaEntrenamientoPK getProgramaEntrenamientoPK() {
        return programaEntrenamientoPK;
    }

    public void setProgramaEntrenamientoPK(ProgramaEntrenamientoPK programaEntrenamientoPK) {
        this.programaEntrenamientoPK = programaEntrenamientoPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    @XmlTransient
    public List<DetProgramaEntrenamiento> getDetProgramaEntrenamientoList() {
        return detProgramaEntrenamientoList;
    }

    public void setDetProgramaEntrenamientoList(List<DetProgramaEntrenamiento> detProgramaEntrenamientoList) {
        this.detProgramaEntrenamientoList = detProgramaEntrenamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaEntrenamientoPK != null ? programaEntrenamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaEntrenamiento)) {
            return false;
        }
        ProgramaEntrenamiento other = (ProgramaEntrenamiento) object;
        if ((this.programaEntrenamientoPK == null && other.programaEntrenamientoPK != null) || (this.programaEntrenamientoPK != null && !this.programaEntrenamientoPK.equals(other.programaEntrenamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ProgramaEntrenamiento[ programaEntrenamientoPK=" + programaEntrenamientoPK + " ]";
    }
    
}
