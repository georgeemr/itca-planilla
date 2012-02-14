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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ENTREVISTA_X_CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntrevistaXCandidato.findAll", query = "SELECT e FROM EntrevistaXCandidato e"),
    @NamedQuery(name = "EntrevistaXCandidato.findByCodCia", query = "SELECT e FROM EntrevistaXCandidato e WHERE e.entrevistaXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "EntrevistaXCandidato.findByCodCandidato", query = "SELECT e FROM EntrevistaXCandidato e WHERE e.entrevistaXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "EntrevistaXCandidato.findByCodPuesto", query = "SELECT e FROM EntrevistaXCandidato e WHERE e.entrevistaXCandidatoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "EntrevistaXCandidato.findByCodEntrevista", query = "SELECT e FROM EntrevistaXCandidato e WHERE e.entrevistaXCandidatoPK.codEntrevista = :codEntrevista"),
    @NamedQuery(name = "EntrevistaXCandidato.findByDescripcion", query = "SELECT e FROM EntrevistaXCandidato e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EntrevistaXCandidato.findByFecha", query = "SELECT e FROM EntrevistaXCandidato e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EntrevistaXCandidato.findByCodEmp", query = "SELECT e FROM EntrevistaXCandidato e WHERE e.codEmp = :codEmp"),
    @NamedQuery(name = "EntrevistaXCandidato.findByResultado", query = "SELECT e FROM EntrevistaXCandidato e WHERE e.resultado = :resultado")})
public class EntrevistaXCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntrevistaXCandidatoPK entrevistaXCandidatoPK;
    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @Size(max = 200)
    @Column(name = "RESULTADO", length = 200)
    private String resultado;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public EntrevistaXCandidato() {
    }

    public EntrevistaXCandidato(EntrevistaXCandidatoPK entrevistaXCandidatoPK) {
        this.entrevistaXCandidatoPK = entrevistaXCandidatoPK;
    }

    public EntrevistaXCandidato(short codCia, int codCandidato, short codPuesto, short codEntrevista) {
        this.entrevistaXCandidatoPK = new EntrevistaXCandidatoPK(codCia, codCandidato, codPuesto, codEntrevista);
    }

    public EntrevistaXCandidatoPK getEntrevistaXCandidatoPK() {
        return entrevistaXCandidatoPK;
    }

    public void setEntrevistaXCandidatoPK(EntrevistaXCandidatoPK entrevistaXCandidatoPK) {
        this.entrevistaXCandidatoPK = entrevistaXCandidatoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
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
        hash += (entrevistaXCandidatoPK != null ? entrevistaXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntrevistaXCandidato)) {
            return false;
        }
        EntrevistaXCandidato other = (EntrevistaXCandidato) object;
        if ((this.entrevistaXCandidatoPK == null && other.entrevistaXCandidatoPK != null) || (this.entrevistaXCandidatoPK != null && !this.entrevistaXCandidatoPK.equals(other.entrevistaXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EntrevistaXCandidato[ entrevistaXCandidatoPK=" + entrevistaXCandidatoPK + " ]";
    }
    
}
