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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CTAS_X_DEPTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtasXDepto.findAll", query = "SELECT c FROM CtasXDepto c"),
    @NamedQuery(name = "CtasXDepto.findByCodCia", query = "SELECT c FROM CtasXDepto c WHERE c.ctasXDeptoPK.codCia = :codCia"),
    @NamedQuery(name = "CtasXDepto.findByCodDepto", query = "SELECT c FROM CtasXDepto c WHERE c.ctasXDeptoPK.codDepto = :codDepto"),
    @NamedQuery(name = "CtasXDepto.findByCodDp", query = "SELECT c FROM CtasXDepto c WHERE c.ctasXDeptoPK.codDp = :codDp"),
    @NamedQuery(name = "CtasXDepto.findByCta1", query = "SELECT c FROM CtasXDepto c WHERE c.cta1 = :cta1"),
    @NamedQuery(name = "CtasXDepto.findByCta2", query = "SELECT c FROM CtasXDepto c WHERE c.cta2 = :cta2"),
    @NamedQuery(name = "CtasXDepto.findByCta3", query = "SELECT c FROM CtasXDepto c WHERE c.cta3 = :cta3"),
    @NamedQuery(name = "CtasXDepto.findByCta4", query = "SELECT c FROM CtasXDepto c WHERE c.cta4 = :cta4"),
    @NamedQuery(name = "CtasXDepto.findByCta5", query = "SELECT c FROM CtasXDepto c WHERE c.cta5 = :cta5")})
public class CtasXDepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CtasXDeptoPK ctasXDeptoPK;
    @Column(name = "CTA_1")
    private Short cta1;
    @Column(name = "CTA_2")
    private Short cta2;
    @Column(name = "CTA_3")
    private Short cta3;
    @Column(name = "CTA_4")
    private Short cta4;
    @Column(name = "CTA_5")
    private Short cta5;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DP", referencedColumnName = "COD_DP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DeducPresta deducPresta;

    public CtasXDepto() {
    }

    public CtasXDepto(CtasXDeptoPK ctasXDeptoPK) {
        this.ctasXDeptoPK = ctasXDeptoPK;
    }

    public CtasXDepto(short codCia, short codDepto, short codDp) {
        this.ctasXDeptoPK = new CtasXDeptoPK(codCia, codDepto, codDp);
    }

    public CtasXDeptoPK getCtasXDeptoPK() {
        return ctasXDeptoPK;
    }

    public void setCtasXDeptoPK(CtasXDeptoPK ctasXDeptoPK) {
        this.ctasXDeptoPK = ctasXDeptoPK;
    }

    public Short getCta1() {
        return cta1;
    }

    public void setCta1(Short cta1) {
        this.cta1 = cta1;
    }

    public Short getCta2() {
        return cta2;
    }

    public void setCta2(Short cta2) {
        this.cta2 = cta2;
    }

    public Short getCta3() {
        return cta3;
    }

    public void setCta3(Short cta3) {
        this.cta3 = cta3;
    }

    public Short getCta4() {
        return cta4;
    }

    public void setCta4(Short cta4) {
        this.cta4 = cta4;
    }

    public Short getCta5() {
        return cta5;
    }

    public void setCta5(Short cta5) {
        this.cta5 = cta5;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public DeducPresta getDeducPresta() {
        return deducPresta;
    }

    public void setDeducPresta(DeducPresta deducPresta) {
        this.deducPresta = deducPresta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctasXDeptoPK != null ? ctasXDeptoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtasXDepto)) {
            return false;
        }
        CtasXDepto other = (CtasXDepto) object;
        if ((this.ctasXDeptoPK == null && other.ctasXDeptoPK != null) || (this.ctasXDeptoPK != null && !this.ctasXDeptoPK.equals(other.ctasXDeptoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CtasXDepto[ ctasXDeptoPK=" + ctasXDeptoPK + " ]";
    }
    
}
