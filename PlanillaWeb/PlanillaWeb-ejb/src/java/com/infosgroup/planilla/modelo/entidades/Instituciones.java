/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "INSTITUCIONES", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituciones.findAll", query = "SELECT i FROM Instituciones i"),
    @NamedQuery(name = "Instituciones.findByCodCia", query = "SELECT i FROM Instituciones i WHERE i.institucionesPK.codCia = :codCia"),
    @NamedQuery(name = "Instituciones.findByCodInsti", query = "SELECT i FROM Instituciones i WHERE i.institucionesPK.codInsti = :codInsti"),
    @NamedQuery(name = "Instituciones.findByDesInsti", query = "SELECT i FROM Instituciones i WHERE i.desInsti = :desInsti"),
    @NamedQuery(name = "Instituciones.findByNomCortoInsti", query = "SELECT i FROM Instituciones i WHERE i.nomCortoInsti = :nomCortoInsti"),
    @NamedQuery(name = "Instituciones.findByDirInsti", query = "SELECT i FROM Instituciones i WHERE i.dirInsti = :dirInsti"),
    @NamedQuery(name = "Instituciones.findByTelInsti1", query = "SELECT i FROM Instituciones i WHERE i.telInsti1 = :telInsti1"),
    @NamedQuery(name = "Instituciones.findByTelInsti2", query = "SELECT i FROM Instituciones i WHERE i.telInsti2 = :telInsti2"),
    @NamedQuery(name = "Instituciones.findByPorInnsti", query = "SELECT i FROM Instituciones i WHERE i.porInnsti = :porInnsti"),
    @NamedQuery(name = "Instituciones.findByCodDp", query = "SELECT i FROM Instituciones i WHERE i.codDp = :codDp")})
public class Instituciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstitucionesPK institucionesPK;
    @Size(max = 60)
    @Column(name = "DES_INSTI", length = 60)
    private String desInsti;
    @Size(max = 15)
    @Column(name = "NOM_CORTO_INSTI", length = 15)
    private String nomCortoInsti;
    @Size(max = 120)
    @Column(name = "DIR_INSTI", length = 120)
    private String dirInsti;
    @Size(max = 15)
    @Column(name = "TEL_INSTI1", length = 15)
    private String telInsti1;
    @Size(max = 15)
    @Column(name = "TEL_INSTI2", length = 15)
    private String telInsti2;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "POR_INNSTI", precision = 8, scale = 4)
    private BigDecimal porInnsti;
    @Column(name = "COD_DP")
    private Integer codDp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instituciones")
    private List<DetInstitucion> detInstitucionList;

    public Instituciones() {
    }

    public Instituciones(InstitucionesPK institucionesPK) {
        this.institucionesPK = institucionesPK;
    }

    public Instituciones(short codCia, short codInsti) {
        this.institucionesPK = new InstitucionesPK(codCia, codInsti);
    }

    public InstitucionesPK getInstitucionesPK() {
        return institucionesPK;
    }

    public void setInstitucionesPK(InstitucionesPK institucionesPK) {
        this.institucionesPK = institucionesPK;
    }

    public String getDesInsti() {
        return desInsti;
    }

    public void setDesInsti(String desInsti) {
        this.desInsti = desInsti;
    }

    public String getNomCortoInsti() {
        return nomCortoInsti;
    }

    public void setNomCortoInsti(String nomCortoInsti) {
        this.nomCortoInsti = nomCortoInsti;
    }

    public String getDirInsti() {
        return dirInsti;
    }

    public void setDirInsti(String dirInsti) {
        this.dirInsti = dirInsti;
    }

    public String getTelInsti1() {
        return telInsti1;
    }

    public void setTelInsti1(String telInsti1) {
        this.telInsti1 = telInsti1;
    }

    public String getTelInsti2() {
        return telInsti2;
    }

    public void setTelInsti2(String telInsti2) {
        this.telInsti2 = telInsti2;
    }

    public BigDecimal getPorInnsti() {
        return porInnsti;
    }

    public void setPorInnsti(BigDecimal porInnsti) {
        this.porInnsti = porInnsti;
    }

    public Integer getCodDp() {
        return codDp;
    }

    public void setCodDp(Integer codDp) {
        this.codDp = codDp;
    }

    @XmlTransient
    public List<DetInstitucion> getDetInstitucionList() {
        return detInstitucionList;
    }

    public void setDetInstitucionList(List<DetInstitucion> detInstitucionList) {
        this.detInstitucionList = detInstitucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institucionesPK != null ? institucionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituciones)) {
            return false;
        }
        Instituciones other = (Instituciones) object;
        if ((this.institucionesPK == null && other.institucionesPK != null) || (this.institucionesPK != null && !this.institucionesPK.equals(other.institucionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Instituciones[ institucionesPK=" + institucionesPK + " ]";
    }
    
}
