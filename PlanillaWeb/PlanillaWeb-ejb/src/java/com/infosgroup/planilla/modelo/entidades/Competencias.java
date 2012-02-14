/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "COMPETENCIAS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencias.findAll", query = "SELECT c FROM Competencias c"),
    @NamedQuery(name = "Competencias.findByCodCia", query = "SELECT c FROM Competencias c WHERE c.competenciasPK.codCia = :codCia"),
    @NamedQuery(name = "Competencias.findByCodCompetencia", query = "SELECT c FROM Competencias c WHERE c.competenciasPK.codCompetencia = :codCompetencia"),
    @NamedQuery(name = "Competencias.findByNomCompetencia", query = "SELECT c FROM Competencias c WHERE c.nomCompetencia = :nomCompetencia"),
    @NamedQuery(name = "Competencias.findByEstado", query = "SELECT c FROM Competencias c WHERE c.estado = :estado")})
public class Competencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetenciasPK competenciasPK;
    @Size(max = 200)
    @Column(name = "NOM_COMPETENCIA", length = 200)
    private String nomCompetencia;
    @Size(max = 1)
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @JoinTable(name = "COMPETENCIAS_X_PUESTO", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_COMPETENCIA", referencedColumnName = "COD_COMPETENCIA", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false)})
    @ManyToMany
    private List<Puestos> puestosList;

    public Competencias() {
    }

    public Competencias(CompetenciasPK competenciasPK) {
        this.competenciasPK = competenciasPK;
    }

    public Competencias(BigInteger codCia, BigInteger codCompetencia) {
        this.competenciasPK = new CompetenciasPK(codCia, codCompetencia);
    }

    public CompetenciasPK getCompetenciasPK() {
        return competenciasPK;
    }

    public void setCompetenciasPK(CompetenciasPK competenciasPK) {
        this.competenciasPK = competenciasPK;
    }

    public String getNomCompetencia() {
        return nomCompetencia;
    }

    public void setNomCompetencia(String nomCompetencia) {
        this.nomCompetencia = nomCompetencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Puestos> getPuestosList() {
        return puestosList;
    }

    public void setPuestosList(List<Puestos> puestosList) {
        this.puestosList = puestosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenciasPK != null ? competenciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencias)) {
            return false;
        }
        Competencias other = (Competencias) object;
        if ((this.competenciasPK == null && other.competenciasPK != null) || (this.competenciasPK != null && !this.competenciasPK.equals(other.competenciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Competencias[ competenciasPK=" + competenciasPK + " ]";
    }
    
}
