/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CRITERIOS_X_CANDIDATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriosXCandidato.findAll", query = "SELECT c FROM CriteriosXCandidato c"),
    @NamedQuery(name = "CriteriosXCandidato.findByCodCia", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "CriteriosXCandidato.findByCandidato", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.candidato = :candidato"),
    @NamedQuery(name = "CriteriosXCandidato.findByCriterio", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.criterio = :criterio"),
    @NamedQuery(name = "CriteriosXCandidato.findByTipoCriterio", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.tipoCriterio = :tipoCriterio"),
    @NamedQuery(name = "CriteriosXCandidato.findByCorrelativo", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.correlativo = :correlativo"),
    @NamedQuery(name = "CriteriosXCandidato.findByValor", query = "SELECT c FROM CriteriosXCandidato c WHERE c.valor = :valor"),
    @NamedQuery(name = "CriteriosXCandidato.findByCampo", query = "SELECT c FROM CriteriosXCandidato c WHERE c.campo = :campo"),
    @NamedQuery(name = "CriteriosXCandidato.findByEntidad", query = "SELECT c FROM CriteriosXCandidato c WHERE c.entidad = :entidad")
})
public class CriteriosXCandidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriosXCandidatoPK criteriosXCandidatoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "VALOR", nullable = false, length = 200)
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CAMPO", nullable = false, length = 200)
    private String campo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ENTIDAD", nullable = false, length = 200)
    private String entidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ENTIDADPK", nullable = false, length = 200)
    private String entidadPk;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_CRITERIO", referencedColumnName = "TIPO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CRITERIO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Criterio criterio1;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Candidato candidato1;

    public CriteriosXCandidato() {
    }

    public CriteriosXCandidato(CriteriosXCandidatoPK criteriosXCandidatoPK) {
        this.criteriosXCandidatoPK = criteriosXCandidatoPK;
    }

    public CriteriosXCandidato(CriteriosXCandidatoPK criteriosXCandidatoPK, String valor, String campo, String entidad) {
        this.criteriosXCandidatoPK = criteriosXCandidatoPK;
        this.valor = valor;
        this.campo = campo;
        this.entidad = entidad;
    }

    public CriteriosXCandidato(long codCia, long candidato, long criterio, long tipoCriterio, long correlativo) {
        this.criteriosXCandidatoPK = new CriteriosXCandidatoPK(codCia, candidato, criterio, tipoCriterio, correlativo);
    }

    public CriteriosXCandidatoPK getCriteriosXCandidatoPK() {
        return criteriosXCandidatoPK;
    }

    public void setCriteriosXCandidatoPK(CriteriosXCandidatoPK criteriosXCandidatoPK) {
        this.criteriosXCandidatoPK = criteriosXCandidatoPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Criterio getCriterio1() {
        return criterio1;
    }

    public void setCriterio1(Criterio criterio1) {
        this.criterio1 = criterio1;
    }

    public Candidato getCandidato1() {
        return candidato1;
    }

    public void setCandidato1(Candidato candidato1) {
        this.candidato1 = candidato1;
    }

    public String getEntidadPk() {
        return entidadPk;
    }

    public void setEntidadPk(String entidadPk) {
        this.entidadPk = entidadPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriosXCandidatoPK != null ? criteriosXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXCandidato)) {
            return false;
        }
        CriteriosXCandidato other = (CriteriosXCandidato) object;
        if ((this.criteriosXCandidatoPK == null && other.criteriosXCandidatoPK != null) || (this.criteriosXCandidatoPK != null && !this.criteriosXCandidatoPK.equals(other.criteriosXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CriteriosXCandidato[ criteriosXCandidatoPK=" + criteriosXCandidatoPK + " ]";
    }
}
