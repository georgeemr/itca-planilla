/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "POR_RANGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PorRangos.findAll", query = "SELECT p FROM PorRangos p"),
    @NamedQuery(name = "PorRangos.findByCodCia", query = "SELECT p FROM PorRangos p WHERE p.porRangosPK.codCia = :codCia"),
    @NamedQuery(name = "PorRangos.findByCodRango", query = "SELECT p FROM PorRangos p WHERE p.porRangosPK.codRango = :codRango"),
    @NamedQuery(name = "PorRangos.findByPeriodo", query = "SELECT p FROM PorRangos p WHERE p.periodo = :periodo"),
    @NamedQuery(name = "PorRangos.findByDescipcion", query = "SELECT p FROM PorRangos p WHERE p.descipcion = :descipcion")})
public class PorRangos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PorRangosPK porRangosPK;
    @Basic(optional = false)
    @Column(name = "PERIODO", nullable = false)
    private short periodo;
    @Column(name = "DESCIPCION", length = 60)
    private String descipcion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PD", referencedColumnName = "COD_DP", nullable = false)})
    @ManyToOne(optional = false)
    private DeducPresta deducPresta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "porRangos")
    private List<DetRangos> detRangosList;

    public PorRangos() {
    }

    public PorRangos(PorRangosPK porRangosPK) {
        this.porRangosPK = porRangosPK;
    }

    public PorRangos(PorRangosPK porRangosPK, short periodo) {
        this.porRangosPK = porRangosPK;
        this.periodo = periodo;
    }

    public PorRangos(short codCia, short codRango) {
        this.porRangosPK = new PorRangosPK(codCia, codRango);
    }

    public PorRangosPK getPorRangosPK() {
        return porRangosPK;
    }

    public void setPorRangosPK(PorRangosPK porRangosPK) {
        this.porRangosPK = porRangosPK;
    }

    public short getPeriodo() {
        return periodo;
    }

    public void setPeriodo(short periodo) {
        this.periodo = periodo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public DeducPresta getDeducPresta() {
        return deducPresta;
    }

    public void setDeducPresta(DeducPresta deducPresta) {
        this.deducPresta = deducPresta;
    }

    @XmlTransient
    public List<DetRangos> getDetRangosList() {
        return detRangosList;
    }

    public void setDetRangosList(List<DetRangos> detRangosList) {
        this.detRangosList = detRangosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (porRangosPK != null ? porRangosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PorRangos)) {
            return false;
        }
        PorRangos other = (PorRangos) object;
        if ((this.porRangosPK == null && other.porRangosPK != null) || (this.porRangosPK != null && !this.porRangosPK.equals(other.porRangosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PorRangos[ porRangosPK=" + porRangosPK + " ]";
    }
    
}
