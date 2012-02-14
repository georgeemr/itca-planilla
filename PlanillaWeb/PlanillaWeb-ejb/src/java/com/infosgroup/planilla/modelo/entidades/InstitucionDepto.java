/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "INSTITUCION_DEPTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionDepto.findAll", query = "SELECT i FROM InstitucionDepto i"),
    @NamedQuery(name = "InstitucionDepto.findByCodCia", query = "SELECT i FROM InstitucionDepto i WHERE i.institucionDeptoPK.codCia = :codCia"),
    @NamedQuery(name = "InstitucionDepto.findByCodInsti", query = "SELECT i FROM InstitucionDepto i WHERE i.institucionDeptoPK.codInsti = :codInsti"),
    @NamedQuery(name = "InstitucionDepto.findByCodDepto", query = "SELECT i FROM InstitucionDepto i WHERE i.institucionDeptoPK.codDepto = :codDepto"),
    @NamedQuery(name = "InstitucionDepto.findByCta1", query = "SELECT i FROM InstitucionDepto i WHERE i.cta1 = :cta1"),
    @NamedQuery(name = "InstitucionDepto.findByCta2", query = "SELECT i FROM InstitucionDepto i WHERE i.cta2 = :cta2"),
    @NamedQuery(name = "InstitucionDepto.findByCta3", query = "SELECT i FROM InstitucionDepto i WHERE i.cta3 = :cta3"),
    @NamedQuery(name = "InstitucionDepto.findByCta4", query = "SELECT i FROM InstitucionDepto i WHERE i.cta4 = :cta4"),
    @NamedQuery(name = "InstitucionDepto.findByCta5", query = "SELECT i FROM InstitucionDepto i WHERE i.cta5 = :cta5")})
public class InstitucionDepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstitucionDeptoPK institucionDeptoPK;
    @Column(name = "CTA_1")
    private Short cta1;
    @Column(name = "CTA_2")
    private Short cta2;
    @Column(name = "CTA_3")
    private Short cta3;
    @Column(name = "CTA_4")
    private Short cta4;
    @Column(name = "CTA_5")
    private Integer cta5;

    public InstitucionDepto() {
    }

    public InstitucionDepto(InstitucionDeptoPK institucionDeptoPK) {
        this.institucionDeptoPK = institucionDeptoPK;
    }

    public InstitucionDepto(short codCia, short codInsti, short codDepto) {
        this.institucionDeptoPK = new InstitucionDeptoPK(codCia, codInsti, codDepto);
    }

    public InstitucionDeptoPK getInstitucionDeptoPK() {
        return institucionDeptoPK;
    }

    public void setInstitucionDeptoPK(InstitucionDeptoPK institucionDeptoPK) {
        this.institucionDeptoPK = institucionDeptoPK;
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

    public Integer getCta5() {
        return cta5;
    }

    public void setCta5(Integer cta5) {
        this.cta5 = cta5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institucionDeptoPK != null ? institucionDeptoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionDepto)) {
            return false;
        }
        InstitucionDepto other = (InstitucionDepto) object;
        if ((this.institucionDeptoPK == null && other.institucionDeptoPK != null) || (this.institucionDeptoPK != null && !this.institucionDeptoPK.equals(other.institucionDeptoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.InstitucionDepto[ institucionDeptoPK=" + institucionDeptoPK + " ]";
    }
    
}
