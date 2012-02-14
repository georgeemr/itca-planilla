/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CANDIDATO_X_CARGO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CandidatoXCargo.findAll", query = "SELECT c FROM CandidatoXCargo c"),
    @NamedQuery(name = "CandidatoXCargo.findByCodCia", query = "SELECT c FROM CandidatoXCargo c WHERE c.candidatoXCargoPK.codCia = :codCia"),
    @NamedQuery(name = "CandidatoXCargo.findByCodCandidato", query = "SELECT c FROM CandidatoXCargo c WHERE c.candidatoXCargoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "CandidatoXCargo.findByCodPuesto", query = "SELECT c FROM CandidatoXCargo c WHERE c.candidatoXCargoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "CandidatoXCargo.findBySalarioAspirado", query = "SELECT c FROM CandidatoXCargo c WHERE c.salarioAspirado = :salarioAspirado"),
    @NamedQuery(name = "CandidatoXCargo.findByCodTipoPuesto", query = "SELECT c FROM CandidatoXCargo c WHERE c.codTipoPuesto = :codTipoPuesto")})
public class CandidatoXCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CandidatoXCargoPK candidatoXCargoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO_ASPIRADO", nullable = false, precision = 16, scale = 2)
    private BigDecimal salarioAspirado;
    @Column(name = "COD_TIPO_PUESTO")
    private Short codTipoPuesto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puestos puestos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public CandidatoXCargo() {
    }

    public CandidatoXCargo(CandidatoXCargoPK candidatoXCargoPK) {
        this.candidatoXCargoPK = candidatoXCargoPK;
    }

    public CandidatoXCargo(CandidatoXCargoPK candidatoXCargoPK, BigDecimal salarioAspirado) {
        this.candidatoXCargoPK = candidatoXCargoPK;
        this.salarioAspirado = salarioAspirado;
    }

    public CandidatoXCargo(short codCia, int codCandidato, short codPuesto) {
        this.candidatoXCargoPK = new CandidatoXCargoPK(codCia, codCandidato, codPuesto);
    }

    public CandidatoXCargoPK getCandidatoXCargoPK() {
        return candidatoXCargoPK;
    }

    public void setCandidatoXCargoPK(CandidatoXCargoPK candidatoXCargoPK) {
        this.candidatoXCargoPK = candidatoXCargoPK;
    }

    public BigDecimal getSalarioAspirado() {
        return salarioAspirado;
    }

    public void setSalarioAspirado(BigDecimal salarioAspirado) {
        this.salarioAspirado = salarioAspirado;
    }

    public Short getCodTipoPuesto() {
        return codTipoPuesto;
    }

    public void setCodTipoPuesto(Short codTipoPuesto) {
        this.codTipoPuesto = codTipoPuesto;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
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
        hash += (candidatoXCargoPK != null ? candidatoXCargoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidatoXCargo)) {
            return false;
        }
        CandidatoXCargo other = (CandidatoXCargo) object;
        if ((this.candidatoXCargoPK == null && other.candidatoXCargoPK != null) || (this.candidatoXCargoPK != null && !this.candidatoXCargoPK.equals(other.candidatoXCargoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CandidatoXCargo[ candidatoXCargoPK=" + candidatoXCargoPK + " ]";
    }
    
}
