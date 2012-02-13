/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DEDUCPRESTA_X_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeducprestaXPuesto.findAll", query = "SELECT d FROM DeducprestaXPuesto d"),
    @NamedQuery(name = "DeducprestaXPuesto.findByCodCia", query = "SELECT d FROM DeducprestaXPuesto d WHERE d.deducprestaXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "DeducprestaXPuesto.findByCodPuesto", query = "SELECT d FROM DeducprestaXPuesto d WHERE d.deducprestaXPuestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "DeducprestaXPuesto.findByCodDp", query = "SELECT d FROM DeducprestaXPuesto d WHERE d.deducprestaXPuestoPK.codDp = :codDp"),
    @NamedQuery(name = "DeducprestaXPuesto.findByValor", query = "SELECT d FROM DeducprestaXPuesto d WHERE d.valor = :valor")})
public class DeducprestaXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeducprestaXPuestoPK deducprestaXPuestoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR", precision = 16, scale = 2)
    private BigDecimal valor;

    public DeducprestaXPuesto() {
    }

    public DeducprestaXPuesto(DeducprestaXPuestoPK deducprestaXPuestoPK) {
        this.deducprestaXPuestoPK = deducprestaXPuestoPK;
    }

    public DeducprestaXPuesto(short codCia, short codPuesto, int codDp) {
        this.deducprestaXPuestoPK = new DeducprestaXPuestoPK(codCia, codPuesto, codDp);
    }

    public DeducprestaXPuestoPK getDeducprestaXPuestoPK() {
        return deducprestaXPuestoPK;
    }

    public void setDeducprestaXPuestoPK(DeducprestaXPuestoPK deducprestaXPuestoPK) {
        this.deducprestaXPuestoPK = deducprestaXPuestoPK;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deducprestaXPuestoPK != null ? deducprestaXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeducprestaXPuesto)) {
            return false;
        }
        DeducprestaXPuesto other = (DeducprestaXPuesto) object;
        if ((this.deducprestaXPuestoPK == null && other.deducprestaXPuestoPK != null) || (this.deducprestaXPuestoPK != null && !this.deducprestaXPuestoPK.equals(other.deducprestaXPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DeducprestaXPuesto[ deducprestaXPuestoPK=" + deducprestaXPuestoPK + " ]";
    }
    
}
