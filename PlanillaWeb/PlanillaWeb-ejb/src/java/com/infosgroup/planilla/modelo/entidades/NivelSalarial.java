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
@Table(name = "NIVEL_SALARIAL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelSalarial.findAll", query = "SELECT n FROM NivelSalarial n"),
    @NamedQuery(name = "NivelSalarial.findByCodCia", query = "SELECT n FROM NivelSalarial n WHERE n.nivelSalarialPK.codCia = :codCia"),
    @NamedQuery(name = "NivelSalarial.findByCodNivel", query = "SELECT n FROM NivelSalarial n WHERE n.nivelSalarialPK.codNivel = :codNivel"),
    @NamedQuery(name = "NivelSalarial.findByLimiteInferior", query = "SELECT n FROM NivelSalarial n WHERE n.limiteInferior = :limiteInferior"),
    @NamedQuery(name = "NivelSalarial.findByLimiteSuperior", query = "SELECT n FROM NivelSalarial n WHERE n.limiteSuperior = :limiteSuperior")})
public class NivelSalarial implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NivelSalarialPK nivelSalarialPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIMITE_INFERIOR", nullable = false, precision = 16, scale = 2)
    private BigDecimal limiteInferior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIMITE_SUPERIOR", nullable = false, precision = 16, scale = 2)
    private BigDecimal limiteSuperior;

    public NivelSalarial() {
    }

    public NivelSalarial(NivelSalarialPK nivelSalarialPK) {
        this.nivelSalarialPK = nivelSalarialPK;
    }

    public NivelSalarial(NivelSalarialPK nivelSalarialPK, BigDecimal limiteInferior, BigDecimal limiteSuperior) {
        this.nivelSalarialPK = nivelSalarialPK;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    public NivelSalarial(short codCia, short codNivel) {
        this.nivelSalarialPK = new NivelSalarialPK(codCia, codNivel);
    }

    public NivelSalarialPK getNivelSalarialPK() {
        return nivelSalarialPK;
    }

    public void setNivelSalarialPK(NivelSalarialPK nivelSalarialPK) {
        this.nivelSalarialPK = nivelSalarialPK;
    }

    public BigDecimal getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(BigDecimal limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public BigDecimal getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(BigDecimal limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivelSalarialPK != null ? nivelSalarialPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelSalarial)) {
            return false;
        }
        NivelSalarial other = (NivelSalarial) object;
        if ((this.nivelSalarialPK == null && other.nivelSalarialPK != null) || (this.nivelSalarialPK != null && !this.nivelSalarialPK.equals(other.nivelSalarialPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.NivelSalarial[ nivelSalarialPK=" + nivelSalarialPK + " ]";
    }
    
}
